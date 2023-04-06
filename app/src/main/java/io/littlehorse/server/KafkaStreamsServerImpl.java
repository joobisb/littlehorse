package io.littlehorse.server;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.TlsServerCredentials;
import io.grpc.stub.StreamObserver;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.exceptions.LHConnectionError;
import io.littlehorse.common.exceptions.LHSerdeError;
import io.littlehorse.common.exceptions.LHValidationError;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.common.model.command.SubCommand;
import io.littlehorse.common.model.command.subcommand.DeleteExternalEventDef;
import io.littlehorse.common.model.command.subcommand.DeleteTaskDef;
import io.littlehorse.common.model.command.subcommand.DeleteWfRun;
import io.littlehorse.common.model.command.subcommand.DeleteWfSpec;
import io.littlehorse.common.model.command.subcommand.PutExternalEvent;
import io.littlehorse.common.model.command.subcommand.PutExternalEventDef;
import io.littlehorse.common.model.command.subcommand.PutTaskDef;
import io.littlehorse.common.model.command.subcommand.PutWfSpec;
import io.littlehorse.common.model.command.subcommand.ResumeWfRun;
import io.littlehorse.common.model.command.subcommand.RunWf;
import io.littlehorse.common.model.command.subcommand.StopWfRun;
import io.littlehorse.common.model.command.subcommand.TaskClaimEvent;
import io.littlehorse.common.model.command.subcommand.TaskResultEvent;
import io.littlehorse.common.model.meta.ExternalEventDef;
import io.littlehorse.common.model.meta.TaskDef;
import io.littlehorse.common.model.meta.WfSpec;
import io.littlehorse.common.model.metrics.TaskDefMetrics;
import io.littlehorse.common.model.metrics.WfSpecMetrics;
import io.littlehorse.common.model.objectId.ExternalEventDefId;
import io.littlehorse.common.model.objectId.ExternalEventId;
import io.littlehorse.common.model.objectId.NodeRunId;
import io.littlehorse.common.model.objectId.TaskDefId;
import io.littlehorse.common.model.objectId.VariableId;
import io.littlehorse.common.model.objectId.WfRunId;
import io.littlehorse.common.model.objectId.WfSpecId;
import io.littlehorse.common.model.wfrun.ExternalEvent;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.common.model.wfrun.TaskScheduleRequest;
import io.littlehorse.common.model.wfrun.Variable;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.proto.CentralStoreQueryReplyPb;
import io.littlehorse.common.proto.CommandPb.CommandCase;
import io.littlehorse.common.proto.InternalScanReplyPb;
import io.littlehorse.common.proto.StoreQueryStatusPb;
import io.littlehorse.common.proto.WaitForCommandReplyPb;
import io.littlehorse.common.util.LHProducer;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.jlib.common.proto.DeleteExternalEventDefPb;
import io.littlehorse.jlib.common.proto.DeleteObjectReplyPb;
import io.littlehorse.jlib.common.proto.DeleteTaskDefPb;
import io.littlehorse.jlib.common.proto.DeleteWfRunPb;
import io.littlehorse.jlib.common.proto.DeleteWfSpecPb;
import io.littlehorse.jlib.common.proto.ExternalEventDefIdPb;
import io.littlehorse.jlib.common.proto.ExternalEventIdPb;
import io.littlehorse.jlib.common.proto.GetExternalEventDefReplyPb;
import io.littlehorse.jlib.common.proto.GetExternalEventReplyPb;
import io.littlehorse.jlib.common.proto.GetLatestWfSpecPb;
import io.littlehorse.jlib.common.proto.GetNodeRunReplyPb;
import io.littlehorse.jlib.common.proto.GetTaskDefReplyPb;
import io.littlehorse.jlib.common.proto.GetVariableReplyPb;
import io.littlehorse.jlib.common.proto.GetWfRunReplyPb;
import io.littlehorse.jlib.common.proto.GetWfSpecReplyPb;
import io.littlehorse.jlib.common.proto.HealthCheckPb;
import io.littlehorse.jlib.common.proto.HealthCheckReplyPb;
import io.littlehorse.jlib.common.proto.LHHealthResultPb;
import io.littlehorse.jlib.common.proto.LHPublicApiGrpc.LHPublicApiImplBase;
import io.littlehorse.jlib.common.proto.LHResponseCodePb;
import io.littlehorse.jlib.common.proto.ListExternalEventsPb;
import io.littlehorse.jlib.common.proto.ListExternalEventsReplyPb;
import io.littlehorse.jlib.common.proto.ListNodeRunsPb;
import io.littlehorse.jlib.common.proto.ListNodeRunsReplyPb;
import io.littlehorse.jlib.common.proto.ListTaskMetricsPb;
import io.littlehorse.jlib.common.proto.ListTaskMetricsReplyPb;
import io.littlehorse.jlib.common.proto.ListVariablesPb;
import io.littlehorse.jlib.common.proto.ListVariablesReplyPb;
import io.littlehorse.jlib.common.proto.ListWfMetricsPb;
import io.littlehorse.jlib.common.proto.ListWfMetricsReplyPb;
import io.littlehorse.jlib.common.proto.NodeRunIdPb;
import io.littlehorse.jlib.common.proto.PollTaskPb;
import io.littlehorse.jlib.common.proto.PollTaskReplyPb;
import io.littlehorse.jlib.common.proto.PutExternalEventDefPb;
import io.littlehorse.jlib.common.proto.PutExternalEventDefReplyPb;
import io.littlehorse.jlib.common.proto.PutExternalEventPb;
import io.littlehorse.jlib.common.proto.PutExternalEventReplyPb;
import io.littlehorse.jlib.common.proto.PutTaskDefPb;
import io.littlehorse.jlib.common.proto.PutTaskDefReplyPb;
import io.littlehorse.jlib.common.proto.PutWfSpecPb;
import io.littlehorse.jlib.common.proto.PutWfSpecReplyPb;
import io.littlehorse.jlib.common.proto.RegisterTaskWorkerPb;
import io.littlehorse.jlib.common.proto.RegisterTaskWorkerReplyPb;
import io.littlehorse.jlib.common.proto.ReportTaskReplyPb;
import io.littlehorse.jlib.common.proto.ResumeWfRunPb;
import io.littlehorse.jlib.common.proto.ResumeWfRunReplyPb;
import io.littlehorse.jlib.common.proto.RunWfPb;
import io.littlehorse.jlib.common.proto.RunWfReplyPb;
import io.littlehorse.jlib.common.proto.SearchExternalEventDefPb;
import io.littlehorse.jlib.common.proto.SearchExternalEventDefReplyPb;
import io.littlehorse.jlib.common.proto.SearchExternalEventPb;
import io.littlehorse.jlib.common.proto.SearchExternalEventReplyPb;
import io.littlehorse.jlib.common.proto.SearchNodeRunPb;
import io.littlehorse.jlib.common.proto.SearchNodeRunReplyPb;
import io.littlehorse.jlib.common.proto.SearchTaskDefPb;
import io.littlehorse.jlib.common.proto.SearchTaskDefReplyPb;
import io.littlehorse.jlib.common.proto.SearchVariablePb;
import io.littlehorse.jlib.common.proto.SearchVariableReplyPb;
import io.littlehorse.jlib.common.proto.SearchWfRunPb;
import io.littlehorse.jlib.common.proto.SearchWfRunReplyPb;
import io.littlehorse.jlib.common.proto.SearchWfSpecPb;
import io.littlehorse.jlib.common.proto.SearchWfSpecReplyPb;
import io.littlehorse.jlib.common.proto.StopWfRunPb;
import io.littlehorse.jlib.common.proto.StopWfRunReplyPb;
import io.littlehorse.jlib.common.proto.TaskDefIdPb;
import io.littlehorse.jlib.common.proto.TaskDefMetricsQueryPb;
import io.littlehorse.jlib.common.proto.TaskDefMetricsReplyPb;
import io.littlehorse.jlib.common.proto.TaskResultEventPb;
import io.littlehorse.jlib.common.proto.VariableIdPb;
import io.littlehorse.jlib.common.proto.WfRunIdPb;
import io.littlehorse.jlib.common.proto.WfSpecIdPb;
import io.littlehorse.jlib.common.proto.WfSpecMetricsQueryPb;
import io.littlehorse.jlib.common.proto.WfSpecMetricsReplyPb;
import io.littlehorse.server.streamsimpl.BackendInternalComms;
import io.littlehorse.server.streamsimpl.ServerTopology;
import io.littlehorse.server.streamsimpl.lhinternalscan.PublicScanReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.PublicScanRequest;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.ListExternalEvents;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.ListNodeRuns;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.ListTaskMetrics;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.ListVariables;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.ListWfMetrics;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchExternalEvent;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchExternalEventDef;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchNodeRun;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchTaskDef;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchVariable;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchWfRun;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicrequests.SearchWfSpec;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.ListExternalEventsReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.ListNodeRunsReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.ListTaskMetricsReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.ListVariablesReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.ListWfMetricsReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchExternalEventDefReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchExternalEventReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchNodeRunReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchTaskDefReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchVariableReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchWfRunReply;
import io.littlehorse.server.streamsimpl.lhinternalscan.publicsearchreplies.SearchWfSpecReply;
import io.littlehorse.server.streamsimpl.storeinternals.utils.StoreUtils;
import io.littlehorse.server.streamsimpl.taskqueue.PollTaskRequestObserver;
import io.littlehorse.server.streamsimpl.taskqueue.TaskQueueManager;
import io.littlehorse.server.streamsimpl.util.GETStreamObserver;
import io.littlehorse.server.streamsimpl.util.POSTStreamObserver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KafkaStreams.State;
import org.apache.log4j.Logger;

public class KafkaStreamsServerImpl extends LHPublicApiImplBase {

    private static final Logger log = Logger.getLogger(KafkaStreamsServerImpl.class);
    private LHConfig config;
    private Server grpcServer;
    private TaskQueueManager taskQueueManager;

    private KafkaStreams coreStreams;
    private KafkaStreams timerStreams;

    private State coreState;
    private State timerState;

    private BackendInternalComms internalComms;
    private boolean isHealthy;

    public KafkaStreamsServerImpl(LHConfig config) {
        this.config = config;

        this.taskQueueManager = new TaskQueueManager(this);
        isHealthy = false;

        coreStreams =
            new KafkaStreams(
                ServerTopology.initCoreTopology(config, this),
                // Core topology must be EOS
                config.getStreamsConfig("core", true)
            );
        timerStreams =
            new KafkaStreams(
                ServerTopology.initTimerTopology(config),
                // We don't want the Timer topology to be EOS. The reason for this
                // has to do with the fact that:
                // a) Timer is idempotent, so it doesn't really matter
                // b) If it's EOS, then there will be transactional records on
                //    the core command topic. With the EOS for the core topology,
                //    that means processing will block until the commit() of the
                //    timer, which means latency will jump from 15ms to >100ms
                config.getStreamsConfig("timer", false)
            );

        ServerBuilder<?> builder;

        Executor executor = Executors.newFixedThreadPool(16);
        TlsServerCredentials.Builder security = config.getServerCreds();
        if (security == null) {
            builder = ServerBuilder.forPort(config.getApiBindPort());
        } else {
            builder =
                Grpc.newServerBuilderForPort(
                    config.getApiBindPort(),
                    security.build()
                );
        }

        builder
            .keepAliveTime(10, TimeUnit.SECONDS)
            .keepAliveTimeout(3, TimeUnit.SECONDS)
            .permitKeepAliveTime(10, TimeUnit.SECONDS)
            .permitKeepAliveWithoutCalls(true)
            .addService(this)
            .executor(executor);

        grpcServer = builder.build();

        coreStreams.setStateListener((newState, oldState) -> {
            coreState = newState;
            log.info("" + new Date() + " New state for core: " + coreState);
            updateHealth();
        });

        timerStreams.setStateListener((newState, oldState) -> {
            timerState = newState;
            LHUtil.log("" + new Date() + " New state for timer: " + timerState);
            updateHealth();
        });

        // metricsStreams.setStateListener((newState, oldState) -> {
        //     metricsState = newState;
        //     LHUtil.log("" + new Date() + " New state for metrics: " + metricsState);
        // });

        internalComms = new BackendInternalComms(config, coreStreams);
    }

    private void updateHealth() {
        if (
            (coreState == State.RUNNING || coreState == State.REBALANCING) &&
            (timerState == State.RUNNING || timerState == State.REBALANCING)
        ) {
            if (!isHealthy) {
                File f = new File("/tmp/lhHealth");
                try {
                    f.createNewFile();
                } catch (IOException exn) {
                    exn.printStackTrace();
                }
                isHealthy = true;
            }
        }

        if (
            coreState == State.ERROR ||
            timerState == State.ERROR ||
            coreState == State.NOT_RUNNING ||
            timerState == State.NOT_RUNNING ||
            coreState == State.PENDING_ERROR ||
            timerState == State.PENDING_ERROR
        ) {
            if (isHealthy) {
                File f = new File("/tmp/lhHealth");
                f.delete();
                isHealthy = false;
            }
        }
    }

    public String getInstanceId() {
        return config.getLHInstanceId();
    }

    @Override
    public void getWfSpec(WfSpecIdPb req, StreamObserver<GetWfSpecReplyPb> ctx) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            WfSpec.class,
            GetWfSpecReplyPb.class,
            config
        );
        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(
                new WfSpecId(req.getName(), req.getVersion()),
                WfSpec.class
            ),
            LHConstants.META_PARTITION_KEY,
            observer
        );
    }

    @Override
    public void getLatestWfSpec(
        GetLatestWfSpecPb req,
        StreamObserver<GetWfSpecReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            WfSpec.class,
            GetWfSpecReplyPb.class,
            config
        );
        internalComms.getLastFromPrefixAsync(
            WfSpec.getFullPrefixByName(req.getName()),
            LHConstants.META_PARTITION_KEY,
            observer,
            ServerTopology.CORE_STORE
        );
    }

    @Override
    public void getTaskDef(TaskDefIdPb req, StreamObserver<GetTaskDefReplyPb> ctx) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            TaskDef.class,
            GetTaskDefReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(new TaskDefId(req.getName()), TaskDef.class),
            LHConstants.META_PARTITION_KEY,
            observer
        );
    }

    @Override
    public void getExternalEventDef(
        ExternalEventDefIdPb req,
        StreamObserver<GetExternalEventDefReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            ExternalEventDef.class,
            GetExternalEventDefReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(
                new ExternalEventDefId(req.getName()),
                ExternalEventDef.class
            ),
            LHConstants.META_PARTITION_KEY,
            observer
        );
    }

    @Override
    public void putTaskDef(PutTaskDefPb req, StreamObserver<PutTaskDefReplyPb> ctx) {
        processCommand(req, ctx, PutTaskDef.class, PutTaskDefReplyPb.class);
    }

    @Override
    public void putExternalEvent(
        PutExternalEventPb req,
        StreamObserver<PutExternalEventReplyPb> ctx
    ) {
        processCommand(
            req,
            ctx,
            PutExternalEvent.class,
            PutExternalEventReplyPb.class
        );
    }

    @Override
    public void putExternalEventDef(
        PutExternalEventDefPb req,
        StreamObserver<PutExternalEventDefReplyPb> ctx
    ) {
        processCommand(
            req,
            ctx,
            PutExternalEventDef.class,
            PutExternalEventDefReplyPb.class
        );
    }

    @Override
    public void putWfSpec(PutWfSpecPb req, StreamObserver<PutWfSpecReplyPb> ctx) {
        processCommand(req, ctx, PutWfSpec.class, PutWfSpecReplyPb.class);
    }

    @Override
    public void runWf(RunWfPb req, StreamObserver<RunWfReplyPb> ctx) {
        processCommand(req, ctx, RunWf.class, RunWfReplyPb.class);
    }

    @Override
    public StreamObserver<PollTaskPb> pollTask(StreamObserver<PollTaskReplyPb> ctx) {
        return new PollTaskRequestObserver(ctx, taskQueueManager);
    }

    @Override
    public void registerTaskWorker(
        RegisterTaskWorkerPb req,
        StreamObserver<RegisterTaskWorkerReplyPb> responseObserver
    ) {
        responseObserver.onNext(internalComms.registerTaskWorker(req));
        responseObserver.onCompleted();
    }

    @Override
    public void reportTask(
        TaskResultEventPb req,
        StreamObserver<ReportTaskReplyPb> ctx
    ) {
        processCommand(req, ctx, TaskResultEvent.class, ReportTaskReplyPb.class);
    }

    @Override
    public void getWfRun(WfRunIdPb req, StreamObserver<GetWfRunReplyPb> ctx) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            WfRun.class,
            GetWfRunReplyPb.class,
            config
        );
        WfRunId id = LHSerializable.fromProto(req, WfRunId.class);

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(id, WfRun.class),
            req.getId(),
            observer
        );
    }

    @Override
    public void getNodeRun(NodeRunIdPb req, StreamObserver<GetNodeRunReplyPb> ctx) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            NodeRun.class,
            GetNodeRunReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(
                new NodeRunId(
                    req.getWfRunId(),
                    req.getThreadRunNumber(),
                    req.getPosition()
                ),
                NodeRun.class
            ),
            req.getWfRunId(),
            observer
        );
    }

    @Override
    public void taskDefMetrics(
        TaskDefMetricsQueryPb req,
        StreamObserver<TaskDefMetricsReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            TaskDefMetrics.class,
            TaskDefMetricsReplyPb.class,
            config
        );
        System.out.println(TaskDefMetrics.getObjectId(req));

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_REPARTITION_STORE,
            StoreUtils.getFullStoreKey(
                TaskDefMetrics.getObjectId(req),
                TaskDefMetrics.class
            ),
            req.getTaskDefName(),
            observer
        );
    }

    @Override
    public void wfSpecMetrics(
        WfSpecMetricsQueryPb req,
        StreamObserver<WfSpecMetricsReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            WfSpecMetrics.class,
            WfSpecMetricsReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_REPARTITION_STORE,
            StoreUtils.getFullStoreKey(
                WfSpecMetrics.getObjectId(req),
                WfSpecMetrics.class
            ),
            req.getWfSpecName(),
            observer
        );
    }

    @Override
    public void getVariable(
        VariableIdPb req,
        StreamObserver<GetVariableReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            Variable.class,
            GetVariableReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(
                new VariableId(
                    req.getWfRunId(),
                    req.getThreadRunNumber(),
                    req.getName()
                ),
                Variable.class
            ),
            req.getWfRunId(),
            observer
        );
    }

    @Override
    public void getExternalEvent(
        ExternalEventIdPb req,
        StreamObserver<GetExternalEventReplyPb> ctx
    ) {
        StreamObserver<CentralStoreQueryReplyPb> observer = new GETStreamObserver<>(
            ctx,
            ExternalEvent.class,
            GetExternalEventReplyPb.class,
            config
        );

        internalComms.getStoreBytesAsync(
            ServerTopology.CORE_STORE,
            StoreUtils.getFullStoreKey(
                new ExternalEventId(
                    req.getWfRunId(),
                    req.getExternalEventDefName(),
                    req.getGuid()
                ),
                ExternalEvent.class
            ),
            req.getWfRunId(),
            observer
        );
    }

    @Override
    public void searchWfRun(
        SearchWfRunPb req,
        StreamObserver<SearchWfRunReplyPb> ctx
    ) {
        handleScan(SearchWfRun.fromProto(req), ctx, SearchWfRunReply.class);
    }

    @Override
    public void searchExternalEvent(
        SearchExternalEventPb req,
        StreamObserver<SearchExternalEventReplyPb> ctx
    ) {
        SearchExternalEvent see = LHSerializable.fromProto(
            req,
            SearchExternalEvent.class
        );
        handleScan(see, ctx, SearchExternalEventReply.class);
    }

    @Override
    public void searchNodeRun(
        SearchNodeRunPb req,
        StreamObserver<SearchNodeRunReplyPb> ctx
    ) {
        handleScan(SearchNodeRun.fromProto(req), ctx, SearchNodeRunReply.class);
    }

    @Override
    public void searchVariable(
        SearchVariablePb req,
        StreamObserver<SearchVariableReplyPb> ctx
    ) {
        handleScan(SearchVariable.fromProto(req), ctx, SearchVariableReply.class);
    }

    @Override
    public void searchTaskDef(
        SearchTaskDefPb req,
        StreamObserver<SearchTaskDefReplyPb> ctx
    ) {
        handleScan(SearchTaskDef.fromProto(req), ctx, SearchTaskDefReply.class);
    }

    @Override
    public void searchWfSpec(
        SearchWfSpecPb req,
        StreamObserver<SearchWfSpecReplyPb> ctx
    ) {
        handleScan(SearchWfSpec.fromProto(req), ctx, SearchWfSpecReply.class);
    }

    @Override
    public void searchExternalEventDef(
        SearchExternalEventDefPb req,
        StreamObserver<SearchExternalEventDefReplyPb> ctx
    ) {
        handleScan(
            SearchExternalEventDef.fromProto(req),
            ctx,
            SearchExternalEventDefReply.class
        );
    }

    // EMPLOYEE_TODO: this is a synchronous call. Make it asynchronous.
    // This will require refactoring the PaginatedTagQuery logic, which will be
    // hard. Once an employee can do this, they will have earned their lightsaber
    // and graduated to the rank of Jedi Padawan.
    //
    // EMPLOYEE_TODO: Right now, we just swallow any malformed requests and raise
    // a RuntimeException (eg. when the bookmark bytes are malformed), which means
    // the client just gets an internal error. Figure out a way to refactor this
    // so that we can return a useful error message to the client.
    @SuppressWarnings("unchecked")
    private <
        T extends Message,
        RP extends Message,
        OP extends Message,
        OJ extends LHSerializable<OP>,
        R extends PublicScanReply<RP, OP, OJ>
    > void handleScan(
        PublicScanRequest<T, RP, OP, OJ, R> req,
        StreamObserver<RP> ctx,
        Class<R> replyCls
    ) {
        R out;
        try {
            out = replyCls.getDeclaredConstructor().newInstance();
        } catch (
            NoSuchMethodException
            | InvocationTargetException
            | InstantiationException
            | IllegalAccessException exn
        ) {
            ctx.onError(exn);
            return;
        }

        try {
            InternalScanReplyPb raw = internalComms.doScan(
                req.getInternalSearch(internalComms.getGlobalStoreImpl())
            );
            out.code = LHResponseCodePb.OK;
            if (raw.hasUpdatedBookmark()) {
                out.bookmark = raw.getUpdatedBookmark().toByteString();
            }
            for (ByteString responseEntry : raw.getResultsList()) {
                out.results.add(
                    LHSerializable.fromBytes(
                        responseEntry.toByteArray(),
                        out.getResultJavaClass(),
                        config
                    )
                );
            }
        } catch (LHSerdeError | LHConnectionError exn) {
            out.code = LHResponseCodePb.CONNECTION_ERROR;
            out.message = "Failed connecting to backend: " + exn.getMessage();
        } catch (LHValidationError exn) {
            out.code = LHResponseCodePb.VALIDATION_ERROR;
            out.message = "Failed validating search request: " + exn.getMessage();
        }

        ctx.onNext((RP) out.toProto().build());
        ctx.onCompleted();
    }

    @Override
    public void listNodeRuns(
        ListNodeRunsPb req,
        StreamObserver<ListNodeRunsReplyPb> ctx
    ) {
        ListNodeRuns lnr = LHSerializable.fromProto(req, ListNodeRuns.class);
        handleScan(lnr, ctx, ListNodeRunsReply.class);
    }

    @Override
    public void listVariables(
        ListVariablesPb req,
        StreamObserver<ListVariablesReplyPb> ctx
    ) {
        ListVariables lv = LHSerializable.fromProto(req, ListVariables.class);
        handleScan(lv, ctx, ListVariablesReply.class);
    }

    @Override
    public void listExternalEvents(
        ListExternalEventsPb req,
        StreamObserver<ListExternalEventsReplyPb> ctx
    ) {
        ListExternalEvents lv = LHSerializable.fromProto(
            req,
            ListExternalEvents.class
        );
        handleScan(lv, ctx, ListExternalEventsReply.class);
    }

    @Override
    public void listTaskDefMetrics(
        ListTaskMetricsPb req,
        StreamObserver<ListTaskMetricsReplyPb> ctx
    ) {
        ListTaskMetrics ltm = LHSerializable.fromProto(req, ListTaskMetrics.class);
        handleScan(ltm, ctx, ListTaskMetricsReply.class);
    }

    @Override
    public void listWfSpecMetrics(
        ListWfMetricsPb req,
        StreamObserver<ListWfMetricsReplyPb> ctx
    ) {
        ListWfMetrics ltm = LHSerializable.fromProto(req, ListWfMetrics.class);
        handleScan(ltm, ctx, ListWfMetricsReply.class);
    }

    @Override
    public void stopWfRun(StopWfRunPb req, StreamObserver<StopWfRunReplyPb> ctx) {
        processCommand(req, ctx, StopWfRun.class, StopWfRunReplyPb.class);
    }

    @Override
    public void resumeWfRun(
        ResumeWfRunPb req,
        StreamObserver<ResumeWfRunReplyPb> ctx
    ) {
        processCommand(req, ctx, ResumeWfRun.class, ResumeWfRunReplyPb.class);
    }

    @Override
    public void deleteWfRun(
        DeleteWfRunPb req,
        StreamObserver<DeleteObjectReplyPb> ctx
    ) {
        processCommand(req, ctx, DeleteWfRun.class, DeleteObjectReplyPb.class);
    }

    @Override
    public void deleteWfSpec(
        DeleteWfSpecPb req,
        StreamObserver<DeleteObjectReplyPb> ctx
    ) {
        processCommand(req, ctx, DeleteWfSpec.class, DeleteObjectReplyPb.class);
    }

    @Override
    public void deleteTaskDef(
        DeleteTaskDefPb req,
        StreamObserver<DeleteObjectReplyPb> ctx
    ) {
        processCommand(req, ctx, DeleteTaskDef.class, DeleteObjectReplyPb.class);
    }

    @Override
    public void deleteExternalEventDef(
        DeleteExternalEventDefPb req,
        StreamObserver<DeleteObjectReplyPb> ctx
    ) {
        processCommand(
            req,
            ctx,
            DeleteExternalEventDef.class,
            DeleteObjectReplyPb.class
        );
    }

    @Override
    public void healthCheck(
        HealthCheckPb req,
        StreamObserver<HealthCheckReplyPb> ctx
    ) {
        ctx.onNext(
            HealthCheckReplyPb
                .newBuilder()
                .setCoreState(kafkaStateToLhHealthState(coreState))
                .setTimerState(kafkaStateToLhHealthState(timerState))
                .build()
        );
        ctx.onCompleted();
    }

    private LHHealthResultPb kafkaStateToLhHealthState(State kState) {
        switch (kState) {
            case CREATED:
            case NOT_RUNNING:
            case REBALANCING:
                return LHHealthResultPb.LH_HEALTH_REBALANCING;
            case RUNNING:
                return LHHealthResultPb.LH_HEALTH_RUNNING;
            case PENDING_ERROR:
            case PENDING_SHUTDOWN:
            case ERROR:
                return LHHealthResultPb.LH_HEALTH_ERROR;
            default:
                throw new RuntimeException("Unknown health status");
        }
    }

    public void returnTaskToClient(
        TaskScheduleRequest tsr,
        PollTaskRequestObserver client
    ) {
        TaskClaimEvent claimEvent = new TaskClaimEvent();
        claimEvent.wfRunId = tsr.wfRunId;
        claimEvent.threadRunNumber = tsr.threadRunNumber;
        claimEvent.taskRunPosition = tsr.taskRunPosition;
        claimEvent.taskRunNumber = tsr.taskRunNumber;
        claimEvent.time = new Date();

        Command taskClaimCommand = new Command();
        taskClaimCommand.type = CommandCase.TASK_CLAIM_EVENT;
        taskClaimCommand.taskClaimEvent = claimEvent;
        taskClaimCommand.time = new Date();

        // the old way which synchronously processes:
        processCommand(
            claimEvent.toProto().build(),
            client.getResponseObserver(),
            TaskClaimEvent.class,
            PollTaskReplyPb.class,
            false // it's a stream, so we don't want to complete it.
        );
        // // // the new way which short-circuits the need to wait for processing.
        // recordClaimEventAndReturnTask(
        //     taskClaimCommand,
        //     tsr,
        //     client.getResponseObserver()
        // );
    }

    // // DO NOT DELETE THIS
    // private void recordClaimEventAndReturnTask(
    //     Command taskClaimCommand,
    //     TaskScheduleRequest tsr,
    //     StreamObserver<PollTaskReplyPb> observer
    // ) {
    //     internalComms
    //         .getProducer()
    //         .send(
    //             taskClaimCommand.getPartitionKey(),
    //             taskClaimCommand,
    //             config.getCoreCmdTopicName(),
    //             (recordMeta, exn) -> {
    //                 if (exn != null) {
    //                     // Then the command wasn't successfully claimed. Just return
    //                     // an empty reply and get the client to try again later.
    //                     observer.onNext(
    //                         PollTaskReplyPb
    //                             .newBuilder()
    //                             .setCode(LHResponseCodePb.CONNECTION_ERROR)
    //                             .setMessage(
    //                                 "Unable to claim command, had a kafka error: " +
    //                                 exn.getMessage()
    //                             )
    //                             .build()
    //                     );
    //                 } else {
    //                     // Then the message has been accepted by Kafka. It's time to
    //                     // finally return the task to client.
    //                     observer.onNext(
    //                         PollTaskReplyPb
    //                             .newBuilder()
    //                             .setCode(LHResponseCodePb.OK)
    //                             .setResult(tsr.toProto())
    //                             .build()
    //                     );
    //                 }
    //             }
    //         );
    // }

    public LHProducer getProducer() {
        return internalComms.getProducer();
    }

    public void onResponseReceived(String commandId, WaitForCommandReplyPb response) {
        internalComms.onResponseReceived(commandId, response);
    }

    private <
        U extends Message, T extends SubCommand<U>, V extends Message
    > void processCommand(
        U request,
        StreamObserver<V> responseObserver,
        Class<T> subCmdCls,
        Class<V> responseCls
    ) {
        processCommand(request, responseObserver, subCmdCls, responseCls, true);
    }

    private <
        U extends Message, T extends SubCommand<U>, V extends Message
    > void processCommand(
        U request,
        StreamObserver<V> responseObserver,
        Class<T> subCmdCls,
        Class<V> responseCls,
        boolean shouldComplete // TODO: Document this
    ) {
        T subCmd = LHSerializable.fromProto(request, subCmdCls);
        Command command = new Command(subCmd);
        command.commandId = LHUtil.generateGuid();
        StreamObserver<WaitForCommandReplyPb> observer = new POSTStreamObserver<>(
            responseObserver,
            responseCls,
            shouldComplete
        );

        // Now actually record the command.
        internalComms
            .getProducer()
            .send(
                command.getPartitionKey(), // partition key
                command, // payload
                config.getCoreCmdTopicName(), // topic name
                (meta, exn) -> { // callback
                    if (exn != null) {
                        // Then we report back to the observer that we failed to record
                        // the command.
                        observer.onNext(
                            WaitForCommandReplyPb
                                .newBuilder()
                                .setCode(StoreQueryStatusPb.RSQ_NOT_AVAILABLE)
                                .setMessage(
                                    "Failed recording command to Kafka: " +
                                    exn.getMessage()
                                )
                                .build()
                        );
                        // EMPLOYEE_TODO: determine whether or not to use onError()
                        // instead.
                        observer.onCompleted();
                    } else {
                        // Now we wait for the processing
                        internalComms.waitForCommand(command, observer);
                    }
                }
            );
    }

    public void onTaskScheduled(String taskDefName, TaskScheduleRequest tsr) {
        taskQueueManager.onTaskScheduled(taskDefName, tsr);
    }

    public void start() throws IOException {
        coreStreams.start();
        timerStreams.start();
        // metricsStreams.start();
        internalComms.start();
        grpcServer.start();
    }

    public void close() {
        CountDownLatch latch = new CountDownLatch(4);

        new Thread(() -> {
            log.info("Closing timer");
            timerStreams.close();
            latch.countDown();
        })
            .start();

        new Thread(() -> {
            log.info("Closing core");
            coreStreams.close();
            latch.countDown();
        })
            .start();

        new Thread(() -> {
            log.info("Closing metrics");
            // metricsStreams.close();
            latch.countDown();
        })
            .start();

        new Thread(() -> {
            log.info("Closing internalComms");
            internalComms.close();
            latch.countDown();
        })
            .start();

        try {
            log.info("Shutting down main server");
            grpcServer.shutdownNow();
            grpcServer.awaitTermination();
        } catch (InterruptedException ignored) {}

        try {
            latch.await();
        } catch (Exception exn) {
            throw new RuntimeException(exn);
        }
    }

    public static void doMain(LHConfig config)
        throws IOException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        KafkaStreamsServerImpl server = new KafkaStreamsServerImpl(config);
        Runtime
            .getRuntime()
            .addShutdownHook(
                new Thread(() -> {
                    System.out.println("Closing now!");
                    server.close();
                    config.cleanup();
                    latch.countDown();
                })
            );
        new Thread(() -> {
            try {
                server.start();
            } catch (IOException exn) {
                throw new RuntimeException(exn);
            }
        })
            .start();

        latch.await();
        System.out.println("Done waiting for countdown latch");
    }
}
