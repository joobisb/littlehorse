package io.littlehorse.server.streamsimpl;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.exceptions.LHConnectionError;
import io.littlehorse.common.model.GETable;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.common.model.meta.ExternalEventDef;
import io.littlehorse.common.model.meta.TaskDef;
import io.littlehorse.common.model.meta.WfSpec;
import io.littlehorse.common.model.wfrun.TaskScheduleRequest;
import io.littlehorse.common.proto.BookmarkPb;
import io.littlehorse.common.proto.CentralStoreQueryPb;
import io.littlehorse.common.proto.CentralStoreQueryPb.CentralStoreSubQueryPb;
import io.littlehorse.common.proto.CentralStoreQueryReplyPb;
import io.littlehorse.common.proto.GETableClassEnumPb;
import io.littlehorse.common.proto.HostInfoPb;
import io.littlehorse.common.proto.InternalGetAdvertisedHostsPb;
import io.littlehorse.common.proto.InternalGetAdvertisedHostsReplyPb;
import io.littlehorse.common.proto.InternalSearchReplyPb;
import io.littlehorse.common.proto.LHInternalSearchPb;
import io.littlehorse.common.proto.LHInternalSearchPb.PrefixCase;
import io.littlehorse.common.proto.LHInternalsGrpc;
import io.littlehorse.common.proto.LHInternalsGrpc.LHInternalsBlockingStub;
import io.littlehorse.common.proto.LHInternalsGrpc.LHInternalsImplBase;
import io.littlehorse.common.proto.LHInternalsGrpc.LHInternalsStub;
import io.littlehorse.common.proto.LHResponseCodePb;
import io.littlehorse.common.proto.PartitionBookmarkPb;
import io.littlehorse.common.proto.RegisterTaskWorkerPb;
import io.littlehorse.common.proto.RegisterTaskWorkerReplyPb;
import io.littlehorse.common.proto.StoreQueryStatusPb;
import io.littlehorse.common.proto.WaitForCommandPb;
import io.littlehorse.common.proto.WaitForCommandReplyPb;
import io.littlehorse.common.util.LHGlobalMetaStores;
import io.littlehorse.common.util.LHProducer;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.server.streamsimpl.searchutils.LHInternalSearch;
import io.littlehorse.server.streamsimpl.storeinternals.LHROStoreWrapper;
import io.littlehorse.server.streamsimpl.storeinternals.index.Attribute;
import io.littlehorse.server.streamsimpl.storeinternals.index.Tag;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHIterKeyValue;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHKeyValueIterator;
import io.littlehorse.server.streamsimpl.util.AsyncWaiters;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyQueryMetadata;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsMetadata;
import org.apache.kafka.streams.TaskMetadata;
import org.apache.kafka.streams.ThreadMetadata;
import org.apache.kafka.streams.state.HostInfo;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

public class BackendInternalComms implements Closeable {

    private LHConfig config;
    private Server internalGrpcServer;
    private KafkaStreams coreStreams;
    private HostInfo thisHost;
    private LHProducer producer;

    private Map<String, ManagedChannel> channels;
    // private ConcurrentHashMap<String, StreamObserver<WaitForCommandReplyPb>> asyncWaiters;
    private AsyncWaiters asyncWaiters;
    private ConcurrentHashMap<HostInfo, InternalGetAdvertisedHostsReplyPb> otherHosts;

    public BackendInternalComms(LHConfig config, KafkaStreams coreStreams) {
        this.config = config;
        this.coreStreams = coreStreams;
        this.channels = new HashMap<>();
        otherHosts = new ConcurrentHashMap<>();

        this.internalGrpcServer =
            ServerBuilder
                .forPort(this.config.getInternalBindPort())
                .addService(new InterBrokerCommServer())
                .build();

        thisHost =
            new HostInfo(
                config.getInternalAdvertisedHost(),
                config.getInternalAdvertisedPort()
            );
        this.producer = new LHProducer(config, false);
        this.asyncWaiters = new AsyncWaiters();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20 * 1000);
                    this.asyncWaiters.cleanupOldWaiters();
                } catch (InterruptedException exn) {
                    throw new RuntimeException(exn);
                }
            }
        })
            .start();
    }

    public void start() throws IOException {
        internalGrpcServer.start();
    }

    public void close() {
        LHUtil.log("Closing backend internal comms");
        for (ManagedChannel channel : channels.values()) {
            channel.shutdown();
        }
        internalGrpcServer.shutdownNow();
        try {
            internalGrpcServer.awaitTermination();
        } catch (InterruptedException exn) {
            throw new RuntimeException(exn);
        }
    }

    /**
     * Performs a distributed point query by hashing the partition key and querying
     * the backing RocksDB store on the resulting host. This method is asynchronous;
     * so you provide a StreamObserver (which is a handy interface by grpc) which is
     * callback'ed once the data is available.
     *
     * Internally, this method uses the grpc async client.
     *
     * @param fullStoreKey is the FULL store key to query.
     * @param partitionKey is the partition key.
     * @param observer is the callback-able object.
     */
    public void getBytesAsync(
        String fullStoreKey,
        String partitionKey,
        StreamObserver<CentralStoreQueryReplyPb> observer
    ) {
        KeyQueryMetadata meta = coreStreams.queryMetadataForKey(
            ServerTopology.CORE_STORE,
            partitionKey,
            Serdes.String().serializer()
        );

        if (meta.activeHost().equals(thisHost)) {
            localGetBytesAsync(fullStoreKey, observer);
        } else {
            queryRemoteAsync(
                meta,
                CentralStoreSubQueryPb.newBuilder().setKey(fullStoreKey).build(),
                observer
            );
        }
    }

    private void localGetBytesAsync(
        String fullStoreKey,
        StreamObserver<CentralStoreQueryReplyPb> observer
    ) {
        ReadOnlyKeyValueStore<String, Bytes> store = getRawStore(null, false);
        Bytes result = store.get(fullStoreKey);

        CentralStoreQueryReplyPb.Builder out = CentralStoreQueryReplyPb
            .newBuilder()
            .setCode(StoreQueryStatusPb.RSQ_OK);
        if (result != null) out.setResult(ByteString.copyFrom(result.get()));

        observer.onNext(out.build());
    }

    public TaskScheduleRequest getTsr(String tsrId) {
        return new LHROStoreWrapper(getRawStore(null, false), config)
            .get(tsrId, TaskScheduleRequest.class);
    }

    public void getLastFromPrefixAsync(
        String prefix,
        String partitionKey,
        StreamObserver<CentralStoreQueryReplyPb> observer
    ) {
        KeyQueryMetadata meta = coreStreams.queryMetadataForKey(
            ServerTopology.CORE_STORE,
            partitionKey,
            Serdes.String().serializer()
        );

        if (meta.activeHost().equals(thisHost)) {
            LHROStoreWrapper wrapper = new LHROStoreWrapper(
                getRawStore(null, false),
                config
            );
            Bytes result = wrapper.getLastBytesFromFullPrefix(prefix);
            CentralStoreQueryReplyPb.Builder out = CentralStoreQueryReplyPb.newBuilder();
            out.setCode(StoreQueryStatusPb.RSQ_OK);
            if (result != null) {
                out.setResult(ByteString.copyFrom(result.get()));
            }
            observer.onNext(out.build());
        } else {
            queryRemoteAsync(
                meta,
                CentralStoreSubQueryPb.newBuilder().setLastFromPrefix(prefix).build(),
                observer
            );
        }
    }

    // EMPLOYEE_TODO: determine if we can use generics here to provide some guards
    // against passing in a Command that's incompatible with the POSTStreamObserver.
    public void waitForCommand(
        Command command,
        StreamObserver<WaitForCommandReplyPb> observer
    ) {
        KeyQueryMetadata meta = coreStreams.queryMetadataForKey(
            ServerTopology.CORE_STORE,
            command.getPartitionKey(),
            Serdes.String().serializer()
        );
        if (command.commandId == null) {
            command.commandId = LHUtil.generateGuid();
        }

        /*
         * Decided that everything is just simpler if we insist upon the server which
         * is responsible for processing the command also being the server that sends
         * the command to Kafka. That's because we need to make sure that the
         */
        if (meta.activeHost().equals(thisHost)) {
            localWaitForCommand(command.commandId, observer);
        } else {
            getInternalAsyncClient(meta.activeHost())
                .waitForCommand(
                    WaitForCommandPb
                        .newBuilder()
                        .setCommandId(command.commandId)
                        .build(),
                    observer
                );
        }
    }

    // EMPLOYEE_TODO: implement a mechanism whereby task worker groups split the
    // LH Server instances among them.
    public RegisterTaskWorkerReplyPb registerTaskWorker(RegisterTaskWorkerPb req) {
        Collection<StreamsMetadata> allMeta = coreStreams.metadataForAllStreamsClients();

        // TODO: in more optimized future versions, we will communicate about which
        // clients are assigned to which hosts in order to be smarter and less dumb
        Set<HostInfo> hosts = new HashSet<>();

        for (StreamsMetadata meta : allMeta) {
            hosts.add(meta.hostInfo());
        }

        RegisterTaskWorkerReplyPb.Builder out = RegisterTaskWorkerReplyPb.newBuilder();
        out.setCode(LHResponseCodePb.OK);

        for (HostInfo host : hosts) {
            InternalGetAdvertisedHostsReplyPb advertisedHostsForHost = getPublicListenersForHost(
                host
            );
            if (advertisedHostsForHost == null) {
                LHUtil.log("Warn: host", host.host(), host.port(), "unreachable");
                continue;
            }

            HostInfoPb desiredHost = advertisedHostsForHost.getHostsOrDefault(
                req.getListenerName(),
                null
            );
            if (desiredHost == null) {
                out.setCode(LHResponseCodePb.BAD_REQUEST_ERROR);
                out.setMessage(
                    "Unknown listener name " +
                    req.getListenerName() +
                    ". Check LHORSE_ADVERTISED_LISTENERS on " +
                    "LH Server and check the LISTENER_NAME config on task worker."
                );
                return out.build();
            }

            out.addAllHosts(desiredHost);
        }

        return out.build();
    }

    private InternalGetAdvertisedHostsReplyPb getPublicListenersForHost(
        HostInfo streamsHost
    ) {
        if (otherHosts.get(streamsHost) != null) {
            return otherHosts.get(streamsHost);
        }

        try {
            InternalGetAdvertisedHostsReplyPb info = getInternalClient(streamsHost)
                .getAdvertisedHosts(
                    InternalGetAdvertisedHostsPb.newBuilder().build()
                );

            otherHosts.put(streamsHost, info);
            return info;
        } catch (Exception exn) {
            exn.printStackTrace();
            return null;
        }
    }

    public LHProducer getProducer() {
        return producer;
    }

    public void onResponseReceived(String commandId, WaitForCommandReplyPb response) {
        asyncWaiters.put(commandId, response);
    }

    private void localWaitForCommand(
        String commandId,
        StreamObserver<WaitForCommandReplyPb> observer
    ) {
        asyncWaiters.put(commandId, observer);
        // Once the command has been recorded, we've got nothing to do: the
        // CommandProcessor will notify the StreamObserver once the command is
        // processed.
    }

    public void recordCommand(Command command) {
        // Next we record the command.
    }

    private ReadOnlyKeyValueStore<String, Bytes> getRawStore(
        Integer specificPartition,
        boolean enableStaleStores
    ) {
        StoreQueryParameters<ReadOnlyKeyValueStore<String, Bytes>> params = StoreQueryParameters.fromNameAndType(
            ServerTopology.CORE_STORE,
            QueryableStoreTypes.keyValueStore()
        );

        if (enableStaleStores) {
            params = params.enableStaleStores();
        }

        if (specificPartition != null) {
            params = params.withPartition(specificPartition);
        }

        return coreStreams.store(params);
    }

    private LHROStoreWrapper getLocalStore(
        Integer specificPartition,
        boolean enableStaleStores
    ) {
        ReadOnlyKeyValueStore<String, Bytes> rawStore = getRawStore(
            specificPartition,
            enableStaleStores
        );
        return new LHROStoreWrapper(rawStore, config);
    }

    /**
     * Performs an RPC call to remotely query the host specified by the provided
     * KeyQueryMetadata, and calls the callback provided in the StreamObserver
     * upon completion of the call.
     *
     * This method uses the gRPC async client.
     *
     * The original version was synchronous and included rpc's to the standby hosts
     * in the case that the active host was unavailable.
     *
     * EMPLOYEE_TODO: re-enable that functionality in the async environment.
     * @param meta is the metadata for the partion-key that we're searching for.
     * @param subQuery is the actual subquery we want to ask.
     */
    private void queryRemoteAsync(
        KeyQueryMetadata meta,
        CentralStoreSubQueryPb subQuery,
        StreamObserver<CentralStoreQueryReplyPb> observer
    ) {
        // todo
        LHInternalsStub client = getInternalAsyncClient(meta.activeHost());
        client.centralStoreQuery(
            CentralStoreQueryPb
                .newBuilder()
                .setEnableStaleStores(false)
                .setSpecificPartition(meta.partition())
                .setQuery(subQuery)
                .build(),
            observer
        );
    }

    private LHInternalsBlockingStub getInternalClient(HostInfo host) {
        return LHInternalsGrpc.newBlockingStub(getChannel(host));
    }

    private LHInternalsStub getInternalAsyncClient(HostInfo host) {
        return LHInternalsGrpc.newStub(getChannel(host));
    }

    private ManagedChannel getChannel(HostInfo host) {
        String key = host.host() + ":" + host.port();
        ManagedChannel channel = channels.get(key);
        if (channel == null) {
            channel =
                ManagedChannelBuilder
                    .forAddress(host.host(), host.port())
                    .usePlaintext()
                    .build();
            channels.put(key, channel);
        }
        return channel;
    }

    /*
     * Implements the internal_server.proto service, which is used
     * for communication between the LH servers to do distributed lookups etc.
     */
    private class InterBrokerCommServer extends LHInternalsImplBase {

        /*
         * Need to investigate:
         * - Behavior when not owner of partition
         * - What exception is thrown when the store is unavailable (eg. REBALANCING)?
         *
         * TODO for first hire: Figure out how to set the "approximateLag" field on
         * the response.
         */
        @Override
        public void centralStoreQuery(
            CentralStoreQueryPb req,
            StreamObserver<CentralStoreQueryReplyPb> ctx
        ) {
            Integer specificPartition = null;
            if (req.hasSpecificPartition()) {
                specificPartition = req.getSpecificPartition();
            }

            CentralStoreQueryReplyPb.Builder out = CentralStoreQueryReplyPb.newBuilder();

            ReadOnlyKeyValueStore<String, Bytes> rawStore;
            try {
                rawStore = getRawStore(specificPartition, req.getEnableStaleStores());
            } catch (Exception exn) {
                exn.printStackTrace();
                out.setCode(StoreQueryStatusPb.RSQ_NOT_AVAILABLE);
                ctx.onNext(out.build());
                ctx.onCompleted();
                return;
            }
            Bytes result = null;

            switch (req.getQuery().getQueryCase()) {
                case KEY:
                    result = rawStore.get(req.getQuery().getKey());
                    break;
                case LAST_FROM_PREFIX:
                    result =
                        new LHROStoreWrapper(rawStore, config)
                            .getLastBytesFromFullPrefix(
                                req.getQuery().getLastFromPrefix()
                            );
                    break;
                case QUERY_NOT_SET:
                default:
                    throw new RuntimeException("Not possible");
            }

            out.setCode(StoreQueryStatusPb.RSQ_OK);
            if (result != null) {
                out.setResult(ByteString.copyFrom(result.get()));
            }

            ctx.onNext(out.build());
            ctx.onCompleted();
        }

        @Override
        public void lHSearch(
            LHInternalSearchPb req,
            StreamObserver<InternalSearchReplyPb> ctx
        ) {
            LHInternalSearch lhis = LHSerializable.fromProto(
                req,
                LHInternalSearch.class
            );

            try {
                InternalSearchReplyPb reply = doSearch(lhis);
                ctx.onNext(reply);
            } catch (LHConnectionError exn) {
                ctx.onNext(
                    InternalSearchReplyPb
                        .newBuilder()
                        .setCode(StoreQueryStatusPb.RSQ_NOT_AVAILABLE)
                        .setMessage("Internal connection error: " + exn.getMessage())
                        .build()
                );
            }

            ctx.onCompleted();
        }

        @Override
        public void waitForCommand(
            WaitForCommandPb req,
            StreamObserver<WaitForCommandReplyPb> ctx
        ) {
            localWaitForCommand(req.getCommandId(), ctx);
        }

        @Override
        public void getAdvertisedHosts(
            InternalGetAdvertisedHostsPb req,
            StreamObserver<InternalGetAdvertisedHostsReplyPb> ctx
        ) {
            Map<String, HostInfoPb> hosts = config.getPublicAdvertisedHostMap();
            InternalGetAdvertisedHostsReplyPb.Builder out = InternalGetAdvertisedHostsReplyPb.newBuilder();

            out.putAllHosts(hosts);

            ctx.onNext(out.build());
            ctx.onCompleted();
        }
    }

    /*
     * Scans over all local tags...note that this should be renamed a bit because
     * it might involve scanning partitions that aren't local.
     * EMPLOYEE_TODO: maybe figure out how to name this better.
     */
    public InternalSearchReplyPb doSearch(LHInternalSearch search)
        throws LHConnectionError {
        if (
            search.partitionKey != null &&
            search.prefixType == PrefixCase.OBJECT_ID_PREFIX
        ) {
            return objectIdPrefixScan(search);
        } else if (
            search.partitionKey != null && search.prefixType == PrefixCase.TAG_PREFIX
        ) {
            throw new RuntimeException("Hashed Tag Scan not yet supported");
        } else if (
            search.partitionKey == null && search.prefixType == PrefixCase.TAG_PREFIX
        ) {
            return unhashedTagScan(search);
        } else {
            throw new RuntimeException("Impossible: Unrecognized search type");
        }
    }

    private InternalSearchReplyPb objectIdPrefixScan(LHInternalSearch search)
        throws LHConnectionError {
        HostInfo correctHost = getHostForKey(search.partitionKey);
        if (getHostForKey(search.partitionKey).equals(thisHost)) {
            return objectIdPrefixScanOnThisHost(search);
        } else {
            try {
                return getInternalClient(correctHost)
                    .lHSearch(search.toProto().build());
            } catch (Exception exn) {
                // EMPLOYEE_TODO: make the caught exn specific to grpc
                // EMPLOYEE_TODO: use standby hosts
                return InternalSearchReplyPb
                    .newBuilder()
                    .setCode(StoreQueryStatusPb.RSQ_NOT_AVAILABLE)
                    .setMessage("Failed contacting host: " + exn.getMessage())
                    .build();
            }
        }
    }

    private InternalSearchReplyPb objectIdPrefixScanOnThisHost(LHInternalSearch req) {
        int curLimit = req.limit;
        BookmarkPb reqBookmark = req.bookmark;
        if (reqBookmark == null) {
            reqBookmark = BookmarkPb.newBuilder().build();
        }
        InternalSearchReplyPb.Builder out = InternalSearchReplyPb.newBuilder();

        KeyQueryMetadata meta = coreStreams.queryMetadataForKey(
            ServerTopology.CORE_STORE,
            req.partitionKey,
            Serdes.String().serializer()
        );
        int partition = meta.partition();

        LHROStoreWrapper store = getLocalStore(partition, false);
        PartitionBookmarkPb partBookmark = reqBookmark.getInProgressPartitionsOrDefault(
            partition,
            null
        );

        Set<String> objectIds = new HashSet<>(); // TODO

        String endKey = req.objectIdPrefix + "~";
        String startKey;
        if (partBookmark == null) {
            startKey = req.objectIdPrefix;
        } else {
            startKey = partBookmark.getLastKey();
        }
        String lastSeenKey = null;
        boolean brokenBecauseLimitFull = false;

        try (
            LHKeyValueIterator<? extends GETable<?>> iter = store.range(
                startKey,
                endKey,
                GETable.getCls(req.objectType)
            )
        ) {
            while (iter.hasNext()) {
                LHIterKeyValue<? extends GETable<?>> next = iter.next();
                String key = next.getKey();
                if (--curLimit < 0) {
                    brokenBecauseLimitFull = true;
                    break;
                }
                out.addObjectIds(key);
                lastSeenKey = key;
            }
        }

        if (brokenBecauseLimitFull) {
            // Then we have more data for the next request, so we want to return
            // a bookmark.

            PartitionBookmarkPb nextBookmark = PartitionBookmarkPb
                .newBuilder()
                .setParttion(partition)
                .setLastKey(lastSeenKey)
                .build();

            out.setUpdatedBookmark(
                BookmarkPb
                    .newBuilder()
                    .putInProgressPartitions(partition, nextBookmark)
            );
        } else {
            // Out of data, so we don't set bookmark on the response.
            // Nothing to do here.
        }

        curLimit -= objectIds.size();
        out.addAllObjectIds(objectIds);

        return out.build();
    }

    private InternalSearchReplyPb unhashedTagScan(LHInternalSearch search)
        throws LHConnectionError {
        int limit = search.limit;

        // First, see what results we have locally. Then if we need more results
        // to hit the limit, we query another host.
        // How do we know which host to query? Well, we find a partition which
        // hasn't been completed yet (by consulting the Bookmark), and then
        // query the owner of that partition.

        InternalSearchReplyPb out = localUnhashedTagScan(search);
        if (out.getObjectIdsCount() >= limit) {
            // Then we've gotten all the data the client asked for.
            return out;
        }
        if (!out.hasUpdatedBookmark()) {
            // Then we've gotten all the data there is.
            return out;
        }

        // OK, now we need to figure out a host to query.

        // We *know* that if a partition is in the bookmark, then that partition
        // is still in progress. We can infer that the partition probably doesn't
        // live on this host, because otherwise the query would have either pulled
        // to the end of that partition or returned because it reached the limit.
        // Note however, it's POSSIBLE that the partition lives on this host if
        // there was a rebalance between the first request and the second request.
        // That's quite unlikely.

        // Basically, what we need to do is find the set of all partitions that
        // AREN'T in the BookmarkPb::getCompletedPartitionsList();
        while (out.hasUpdatedBookmark() && out.getObjectIdsCount() < search.limit) {
            HostInfo otherHost = getHostForPartition(
                getRandomUnfinishedPartition(out.getUpdatedBookmark())
            );
            if (otherHost.equals(thisHost)) {
                throw new RuntimeException("wtf, host the same");
            }
            LHInternalsBlockingStub stub = getInternalClient(otherHost);

            LHInternalSearch newReq = new LHInternalSearch();
            newReq.bookmark = out.getUpdatedBookmark();
            newReq.limit = search.limit - out.getObjectIdsCount();
            newReq.tagPrefix = search.tagPrefix;
            newReq.prefixType = PrefixCase.TAG_PREFIX;
            newReq.objectType = search.objectType;

            InternalSearchReplyPb reply;
            try {
                reply = stub.lHSearch(newReq.toProto().build());
            } catch (Exception exn) {
                throw new LHConnectionError(exn, "Failed connecting to backend.");
            }
            if (reply.getCode() != StoreQueryStatusPb.RSQ_OK) {
                throw new LHConnectionError(null, "Failed connecting to backend.");
            }
            InternalSearchReplyPb.Builder newOutBuilder = InternalSearchReplyPb
                .newBuilder()
                .addAllObjectIds(out.getObjectIdsList())
                .addAllObjectIds(reply.getObjectIdsList());
            if (reply.hasUpdatedBookmark()) {
                newOutBuilder.setUpdatedBookmark(reply.getUpdatedBookmark());
            } else {
                newOutBuilder.clearUpdatedBookmark();
            }
            out = newOutBuilder.build();
        }

        return out;
    }

    private HostInfo getHostForPartition(int partition) {
        if (partition >= config.getClusterPartitions()) {
            throw new RuntimeException("Colt you need to sleep more you moron");
        }

        // This is O(N) where N is # of partitions...not too great yikerz
        Collection<StreamsMetadata> all = coreStreams.metadataForAllStreamsClients();
        for (StreamsMetadata meta : all) {
            for (TopicPartition tp : meta.topicPartitions()) {
                if (tp.partition() != partition) continue;
                if (isCommandProcessor(tp, config)) {
                    return meta.hostInfo();
                }
            }
        }
        return null;
    }

    private HostInfo getHostForKey(String partitionKey) {
        KeyQueryMetadata meta = coreStreams.queryMetadataForKey(
            ServerTopology.CORE_STORE,
            partitionKey,
            Serdes.String().serializer()
        );
        return meta.activeHost();
    }

    /*
     * Precondition: bm represents bookmark for uncompleted LOCAL search (not a
     * REMOTE_HASH search).
     */
    private Set<Integer> getUnfininshedPartitions(BookmarkPb bm) {
        Set<Integer> out = new HashSet<>();
        for (int i = 0; i < config.getClusterPartitions(); i++) {
            out.add(i);
        }
        out.removeAll(bm.getCompletedPartitionsList());

        return out;
    }

    private int getRandomUnfinishedPartition(BookmarkPb bm) {
        Set<Integer> unfinished = getUnfininshedPartitions(bm);
        for (int i : unfinished) {
            return i;
        }
        throw new RuntimeException("Not possible");
    }

    public LHGlobalMetaStores getGlobalStoreImpl() {
        return new GlobalMetaStoresServerImpl(coreStreams, config);
    }

    private InternalSearchReplyPb localUnhashedTagScan(LHInternalSearch req) {
        if (req.partitionKey != null) {
            throw new RuntimeException("Not possible you nincompoop");
        }

        int curLimit = req.limit;

        BookmarkPb reqBookmark = req.bookmark;
        if (reqBookmark == null) {
            reqBookmark = BookmarkPb.newBuilder().build();
        }

        BookmarkPb.Builder outBookmark = reqBookmark.toBuilder();
        InternalSearchReplyPb.Builder out = InternalSearchReplyPb.newBuilder();

        // iterate through all active and standby local partitions
        for (int partition : getLocalActiveCommandProcessorPartitions()) {
            LHROStoreWrapper partStore = getLocalStore(partition, false);
            if (reqBookmark.getCompletedPartitionsList().contains(partition)) {
                // This partition has already been accounted for
                continue;
            }
            PartitionBookmarkPb partBookmark = null;
            if (reqBookmark != null) {
                partBookmark =
                    reqBookmark.getInProgressPartitionsOrDefault(partition, null);
            }

            // Add all matching objects from that partition
            Pair<Set<String>, PartitionBookmarkPb> result = onePartitionPaginatedTagScan(
                req.tagPrefix,
                partBookmark,
                curLimit,
                req.objectType,
                partition,
                partStore
            );

            curLimit -= result.getLeft().size();
            out.addAllObjectIds(result.getLeft());
            PartitionBookmarkPb thisPartionBookmark = result.getRight();
            if (thisPartionBookmark == null) {
                // then the partition is done
                outBookmark.addCompletedPartitions(partition);
                outBookmark.removeInProgressPartitions(partition);
            } else {
                outBookmark.putInProgressPartitions(partition, thisPartionBookmark);
            }

            if (curLimit == 0) {
                break;
            }
            if (curLimit < 0) {
                throw new RuntimeException("WTF?");
            }
        }

        if (
            outBookmark.getCompletedPartitionsCount() < config.getClusterPartitions()
        ) {
            out.setUpdatedBookmark(outBookmark);
        } else {
            // Then every partition has been scanned, so the paginated query is
            // complete. That means we don't return a bookmark.
            out.clearUpdatedBookmark();
        }
        return out.build();
    }

    private Pair<Set<String>, PartitionBookmarkPb> onePartitionPaginatedTagScan(
        List<Attribute> attributes,
        PartitionBookmarkPb bookmark,
        int limit,
        GETableClassEnumPb objectType,
        int partition,
        LHROStoreWrapper store
    ) {
        PartitionBookmarkPb bmOut = null;
        Set<String> idsOut = new HashSet<>();

        String endKey =
            Tag.getAttributeString(objectType, attributes) + "~~~~~~~~~~~";
        String startKey;
        if (bookmark == null) {
            startKey = Tag.getAttributeString(objectType, attributes) + "/";
        } else {
            startKey = bookmark.getLastKey();
        }

        try (
            LHKeyValueIterator<Tag> iter = store.range(startKey, endKey, Tag.class)
        ) {
            boolean brokenBecauseOutOfData = true;
            while (iter.hasNext()) {
                LHIterKeyValue<Tag> next = iter.next();
                Tag tag = next.getValue();
                if (--limit < 0) {
                    bmOut =
                        PartitionBookmarkPb
                            .newBuilder()
                            .setParttion(partition)
                            .setLastKey(tag.getObjectId())
                            .build();

                    // broke loop because we filled up the limit
                    brokenBecauseOutOfData = false;
                    break;
                }

                idsOut.add(tag.describedObjectId);
            }

            if (brokenBecauseOutOfData) {
                bmOut = null;
            }
        }
        return Pair.of(idsOut, bmOut);
    }

    private Set<Integer> getLocalActiveCommandProcessorPartitions() {
        Set<Integer> out = new HashSet<>();

        for (ThreadMetadata thread : coreStreams.metadataForLocalThreads()) {
            for (TaskMetadata activeTask : thread.activeTasks()) {
                // We only want to query active partitions.
                // Additionally, there may be many tasks...we only want the ones
                // that are for the command processor.
                if (isCommandProcessor(activeTask, config)) {
                    out.add(activeTask.taskId().partition());
                }
            }
        }
        return out;
    }

    private static boolean isCommandProcessor(TaskMetadata task, LHConfig config) {
        for (TopicPartition tPart : task.topicPartitions()) {
            if (isCommandProcessor(tPart, config)) return true;
        }
        return false;
    }

    private static boolean isCommandProcessor(TopicPartition tPart, LHConfig config) {
        return tPart.topic().equals(config.getCoreCmdTopicName());
    }
}

class GlobalMetaStoresServerImpl implements LHGlobalMetaStores {

    private LHROStoreWrapper store;

    public GlobalMetaStoresServerImpl(KafkaStreams coreStreams, LHConfig config) {
        StoreQueryParameters<ReadOnlyKeyValueStore<String, Bytes>> params = StoreQueryParameters.fromNameAndType(
            ServerTopology.GLOBAL_STORE,
            QueryableStoreTypes.keyValueStore()
        );

        store = new LHROStoreWrapper(coreStreams.store(params), config);
    }

    public WfSpec getWfSpec(String name, Integer version) {
        if (version != null) {
            return store.get(WfSpec.getSubKey(name, version), WfSpec.class);
        } else {
            return store.getLastFromPrefix(name, WfSpec.class);
        }
    }

    public TaskDef getTaskDef(String name, Integer version) {
        if (version != null) {
            return store.get(WfSpec.getSubKey(name, version), TaskDef.class);
        } else {
            return store.getLastFromPrefix(name, TaskDef.class);
        }
    }

    public ExternalEventDef getExternalEventDef(String name, Integer version) {
        if (version != null) {
            return store.get(WfSpec.getSubKey(name, version), ExternalEventDef.class);
        } else {
            return store.getLastFromPrefix(name, ExternalEventDef.class);
        }
    }
}
