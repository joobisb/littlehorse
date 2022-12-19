package io.littlehorse.common.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: internal_server.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LHInternalsGrpc {

  private LHInternalsGrpc() {}

  public static final String SERVICE_NAME = "lh_proto.LHInternals";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.littlehorse.common.proto.CentralStoreQueryPb,
      io.littlehorse.common.proto.CentralStoreQueryReplyPb> getCentralStoreQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CentralStoreQuery",
      requestType = io.littlehorse.common.proto.CentralStoreQueryPb.class,
      responseType = io.littlehorse.common.proto.CentralStoreQueryReplyPb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.littlehorse.common.proto.CentralStoreQueryPb,
      io.littlehorse.common.proto.CentralStoreQueryReplyPb> getCentralStoreQueryMethod() {
    io.grpc.MethodDescriptor<io.littlehorse.common.proto.CentralStoreQueryPb, io.littlehorse.common.proto.CentralStoreQueryReplyPb> getCentralStoreQueryMethod;
    if ((getCentralStoreQueryMethod = LHInternalsGrpc.getCentralStoreQueryMethod) == null) {
      synchronized (LHInternalsGrpc.class) {
        if ((getCentralStoreQueryMethod = LHInternalsGrpc.getCentralStoreQueryMethod) == null) {
          LHInternalsGrpc.getCentralStoreQueryMethod = getCentralStoreQueryMethod =
              io.grpc.MethodDescriptor.<io.littlehorse.common.proto.CentralStoreQueryPb, io.littlehorse.common.proto.CentralStoreQueryReplyPb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CentralStoreQuery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.CentralStoreQueryPb.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.CentralStoreQueryReplyPb.getDefaultInstance()))
              .setSchemaDescriptor(new LHInternalsMethodDescriptorSupplier("CentralStoreQuery"))
              .build();
        }
      }
    }
    return getCentralStoreQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.littlehorse.common.proto.PaginatedTagQueryPb,
      io.littlehorse.common.proto.PaginatedTagQueryReplyPb> getPaginatedTagQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PaginatedTagQuery",
      requestType = io.littlehorse.common.proto.PaginatedTagQueryPb.class,
      responseType = io.littlehorse.common.proto.PaginatedTagQueryReplyPb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.littlehorse.common.proto.PaginatedTagQueryPb,
      io.littlehorse.common.proto.PaginatedTagQueryReplyPb> getPaginatedTagQueryMethod() {
    io.grpc.MethodDescriptor<io.littlehorse.common.proto.PaginatedTagQueryPb, io.littlehorse.common.proto.PaginatedTagQueryReplyPb> getPaginatedTagQueryMethod;
    if ((getPaginatedTagQueryMethod = LHInternalsGrpc.getPaginatedTagQueryMethod) == null) {
      synchronized (LHInternalsGrpc.class) {
        if ((getPaginatedTagQueryMethod = LHInternalsGrpc.getPaginatedTagQueryMethod) == null) {
          LHInternalsGrpc.getPaginatedTagQueryMethod = getPaginatedTagQueryMethod =
              io.grpc.MethodDescriptor.<io.littlehorse.common.proto.PaginatedTagQueryPb, io.littlehorse.common.proto.PaginatedTagQueryReplyPb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PaginatedTagQuery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.PaginatedTagQueryPb.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.PaginatedTagQueryReplyPb.getDefaultInstance()))
              .setSchemaDescriptor(new LHInternalsMethodDescriptorSupplier("PaginatedTagQuery"))
              .build();
        }
      }
    }
    return getPaginatedTagQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.littlehorse.common.proto.ProcessCommandPb,
      io.littlehorse.common.proto.ProcessCommandReplyPb> getProcessCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessCommand",
      requestType = io.littlehorse.common.proto.ProcessCommandPb.class,
      responseType = io.littlehorse.common.proto.ProcessCommandReplyPb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.littlehorse.common.proto.ProcessCommandPb,
      io.littlehorse.common.proto.ProcessCommandReplyPb> getProcessCommandMethod() {
    io.grpc.MethodDescriptor<io.littlehorse.common.proto.ProcessCommandPb, io.littlehorse.common.proto.ProcessCommandReplyPb> getProcessCommandMethod;
    if ((getProcessCommandMethod = LHInternalsGrpc.getProcessCommandMethod) == null) {
      synchronized (LHInternalsGrpc.class) {
        if ((getProcessCommandMethod = LHInternalsGrpc.getProcessCommandMethod) == null) {
          LHInternalsGrpc.getProcessCommandMethod = getProcessCommandMethod =
              io.grpc.MethodDescriptor.<io.littlehorse.common.proto.ProcessCommandPb, io.littlehorse.common.proto.ProcessCommandReplyPb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.ProcessCommandPb.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.ProcessCommandReplyPb.getDefaultInstance()))
              .setSchemaDescriptor(new LHInternalsMethodDescriptorSupplier("ProcessCommand"))
              .build();
        }
      }
    }
    return getProcessCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.littlehorse.common.proto.InternalPollTaskPb,
      io.littlehorse.common.proto.InternalPollTaskReplyPb> getInternalPollTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InternalPollTask",
      requestType = io.littlehorse.common.proto.InternalPollTaskPb.class,
      responseType = io.littlehorse.common.proto.InternalPollTaskReplyPb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.littlehorse.common.proto.InternalPollTaskPb,
      io.littlehorse.common.proto.InternalPollTaskReplyPb> getInternalPollTaskMethod() {
    io.grpc.MethodDescriptor<io.littlehorse.common.proto.InternalPollTaskPb, io.littlehorse.common.proto.InternalPollTaskReplyPb> getInternalPollTaskMethod;
    if ((getInternalPollTaskMethod = LHInternalsGrpc.getInternalPollTaskMethod) == null) {
      synchronized (LHInternalsGrpc.class) {
        if ((getInternalPollTaskMethod = LHInternalsGrpc.getInternalPollTaskMethod) == null) {
          LHInternalsGrpc.getInternalPollTaskMethod = getInternalPollTaskMethod =
              io.grpc.MethodDescriptor.<io.littlehorse.common.proto.InternalPollTaskPb, io.littlehorse.common.proto.InternalPollTaskReplyPb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InternalPollTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.InternalPollTaskPb.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.littlehorse.common.proto.InternalPollTaskReplyPb.getDefaultInstance()))
              .setSchemaDescriptor(new LHInternalsMethodDescriptorSupplier("InternalPollTask"))
              .build();
        }
      }
    }
    return getInternalPollTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LHInternalsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LHInternalsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LHInternalsStub>() {
        @java.lang.Override
        public LHInternalsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LHInternalsStub(channel, callOptions);
        }
      };
    return LHInternalsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LHInternalsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LHInternalsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LHInternalsBlockingStub>() {
        @java.lang.Override
        public LHInternalsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LHInternalsBlockingStub(channel, callOptions);
        }
      };
    return LHInternalsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LHInternalsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LHInternalsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LHInternalsFutureStub>() {
        @java.lang.Override
        public LHInternalsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LHInternalsFutureStub(channel, callOptions);
        }
      };
    return LHInternalsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LHInternalsImplBase implements io.grpc.BindableService {

    /**
     */
    public void centralStoreQuery(io.littlehorse.common.proto.CentralStoreQueryPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.CentralStoreQueryReplyPb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCentralStoreQueryMethod(), responseObserver);
    }

    /**
     */
    public void paginatedTagQuery(io.littlehorse.common.proto.PaginatedTagQueryPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.PaginatedTagQueryReplyPb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPaginatedTagQueryMethod(), responseObserver);
    }

    /**
     */
    public void processCommand(io.littlehorse.common.proto.ProcessCommandPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.ProcessCommandReplyPb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessCommandMethod(), responseObserver);
    }

    /**
     */
    public void internalPollTask(io.littlehorse.common.proto.InternalPollTaskPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.InternalPollTaskReplyPb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInternalPollTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCentralStoreQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.littlehorse.common.proto.CentralStoreQueryPb,
                io.littlehorse.common.proto.CentralStoreQueryReplyPb>(
                  this, METHODID_CENTRAL_STORE_QUERY)))
          .addMethod(
            getPaginatedTagQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.littlehorse.common.proto.PaginatedTagQueryPb,
                io.littlehorse.common.proto.PaginatedTagQueryReplyPb>(
                  this, METHODID_PAGINATED_TAG_QUERY)))
          .addMethod(
            getProcessCommandMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.littlehorse.common.proto.ProcessCommandPb,
                io.littlehorse.common.proto.ProcessCommandReplyPb>(
                  this, METHODID_PROCESS_COMMAND)))
          .addMethod(
            getInternalPollTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.littlehorse.common.proto.InternalPollTaskPb,
                io.littlehorse.common.proto.InternalPollTaskReplyPb>(
                  this, METHODID_INTERNAL_POLL_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class LHInternalsStub extends io.grpc.stub.AbstractAsyncStub<LHInternalsStub> {
    private LHInternalsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LHInternalsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LHInternalsStub(channel, callOptions);
    }

    /**
     */
    public void centralStoreQuery(io.littlehorse.common.proto.CentralStoreQueryPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.CentralStoreQueryReplyPb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCentralStoreQueryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void paginatedTagQuery(io.littlehorse.common.proto.PaginatedTagQueryPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.PaginatedTagQueryReplyPb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPaginatedTagQueryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processCommand(io.littlehorse.common.proto.ProcessCommandPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.ProcessCommandReplyPb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void internalPollTask(io.littlehorse.common.proto.InternalPollTaskPb request,
        io.grpc.stub.StreamObserver<io.littlehorse.common.proto.InternalPollTaskReplyPb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInternalPollTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LHInternalsBlockingStub extends io.grpc.stub.AbstractBlockingStub<LHInternalsBlockingStub> {
    private LHInternalsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LHInternalsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LHInternalsBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.littlehorse.common.proto.CentralStoreQueryReplyPb centralStoreQuery(io.littlehorse.common.proto.CentralStoreQueryPb request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCentralStoreQueryMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.littlehorse.common.proto.PaginatedTagQueryReplyPb paginatedTagQuery(io.littlehorse.common.proto.PaginatedTagQueryPb request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPaginatedTagQueryMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.littlehorse.common.proto.ProcessCommandReplyPb processCommand(io.littlehorse.common.proto.ProcessCommandPb request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessCommandMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.littlehorse.common.proto.InternalPollTaskReplyPb internalPollTask(io.littlehorse.common.proto.InternalPollTaskPb request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInternalPollTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LHInternalsFutureStub extends io.grpc.stub.AbstractFutureStub<LHInternalsFutureStub> {
    private LHInternalsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LHInternalsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LHInternalsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.littlehorse.common.proto.CentralStoreQueryReplyPb> centralStoreQuery(
        io.littlehorse.common.proto.CentralStoreQueryPb request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCentralStoreQueryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.littlehorse.common.proto.PaginatedTagQueryReplyPb> paginatedTagQuery(
        io.littlehorse.common.proto.PaginatedTagQueryPb request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPaginatedTagQueryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.littlehorse.common.proto.ProcessCommandReplyPb> processCommand(
        io.littlehorse.common.proto.ProcessCommandPb request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessCommandMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.littlehorse.common.proto.InternalPollTaskReplyPb> internalPollTask(
        io.littlehorse.common.proto.InternalPollTaskPb request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInternalPollTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CENTRAL_STORE_QUERY = 0;
  private static final int METHODID_PAGINATED_TAG_QUERY = 1;
  private static final int METHODID_PROCESS_COMMAND = 2;
  private static final int METHODID_INTERNAL_POLL_TASK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LHInternalsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LHInternalsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CENTRAL_STORE_QUERY:
          serviceImpl.centralStoreQuery((io.littlehorse.common.proto.CentralStoreQueryPb) request,
              (io.grpc.stub.StreamObserver<io.littlehorse.common.proto.CentralStoreQueryReplyPb>) responseObserver);
          break;
        case METHODID_PAGINATED_TAG_QUERY:
          serviceImpl.paginatedTagQuery((io.littlehorse.common.proto.PaginatedTagQueryPb) request,
              (io.grpc.stub.StreamObserver<io.littlehorse.common.proto.PaginatedTagQueryReplyPb>) responseObserver);
          break;
        case METHODID_PROCESS_COMMAND:
          serviceImpl.processCommand((io.littlehorse.common.proto.ProcessCommandPb) request,
              (io.grpc.stub.StreamObserver<io.littlehorse.common.proto.ProcessCommandReplyPb>) responseObserver);
          break;
        case METHODID_INTERNAL_POLL_TASK:
          serviceImpl.internalPollTask((io.littlehorse.common.proto.InternalPollTaskPb) request,
              (io.grpc.stub.StreamObserver<io.littlehorse.common.proto.InternalPollTaskReplyPb>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LHInternalsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LHInternalsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.littlehorse.common.proto.InternalServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LHInternals");
    }
  }

  private static final class LHInternalsFileDescriptorSupplier
      extends LHInternalsBaseDescriptorSupplier {
    LHInternalsFileDescriptorSupplier() {}
  }

  private static final class LHInternalsMethodDescriptorSupplier
      extends LHInternalsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LHInternalsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LHInternalsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LHInternalsFileDescriptorSupplier())
              .addMethod(getCentralStoreQueryMethod())
              .addMethod(getPaginatedTagQueryMethod())
              .addMethod(getProcessCommandMethod())
              .addMethod(getInternalPollTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
