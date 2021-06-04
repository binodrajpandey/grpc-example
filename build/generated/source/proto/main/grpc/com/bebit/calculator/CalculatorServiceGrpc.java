package com.bebit.calculator;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: calculator/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "calculator.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bebit.calculator.SumRequest,
      com.bebit.calculator.SumResponse> getSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sum",
      requestType = com.bebit.calculator.SumRequest.class,
      responseType = com.bebit.calculator.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bebit.calculator.SumRequest,
      com.bebit.calculator.SumResponse> getSumMethod() {
    io.grpc.MethodDescriptor<com.bebit.calculator.SumRequest, com.bebit.calculator.SumResponse> getSumMethod;
    if ((getSumMethod = CalculatorServiceGrpc.getSumMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getSumMethod = CalculatorServiceGrpc.getSumMethod) == null) {
          CalculatorServiceGrpc.getSumMethod = getSumMethod =
              io.grpc.MethodDescriptor.<com.bebit.calculator.SumRequest, com.bebit.calculator.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("sum"))
              .build();
        }
      }
    }
    return getSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bebit.calculator.TableRequest,
      com.bebit.calculator.TableResponse> getGetTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTable",
      requestType = com.bebit.calculator.TableRequest.class,
      responseType = com.bebit.calculator.TableResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.bebit.calculator.TableRequest,
      com.bebit.calculator.TableResponse> getGetTableMethod() {
    io.grpc.MethodDescriptor<com.bebit.calculator.TableRequest, com.bebit.calculator.TableResponse> getGetTableMethod;
    if ((getGetTableMethod = CalculatorServiceGrpc.getGetTableMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getGetTableMethod = CalculatorServiceGrpc.getGetTableMethod) == null) {
          CalculatorServiceGrpc.getGetTableMethod = getGetTableMethod =
              io.grpc.MethodDescriptor.<com.bebit.calculator.TableRequest, com.bebit.calculator.TableResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.TableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.TableResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("getTable"))
              .build();
        }
      }
    }
    return getGetTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bebit.calculator.ComputeRequest,
      com.bebit.calculator.ComputeResponse> getComputeAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "computeAverage",
      requestType = com.bebit.calculator.ComputeRequest.class,
      responseType = com.bebit.calculator.ComputeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.bebit.calculator.ComputeRequest,
      com.bebit.calculator.ComputeResponse> getComputeAverageMethod() {
    io.grpc.MethodDescriptor<com.bebit.calculator.ComputeRequest, com.bebit.calculator.ComputeResponse> getComputeAverageMethod;
    if ((getComputeAverageMethod = CalculatorServiceGrpc.getComputeAverageMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getComputeAverageMethod = CalculatorServiceGrpc.getComputeAverageMethod) == null) {
          CalculatorServiceGrpc.getComputeAverageMethod = getComputeAverageMethod =
              io.grpc.MethodDescriptor.<com.bebit.calculator.ComputeRequest, com.bebit.calculator.ComputeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "computeAverage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.ComputeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.ComputeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("computeAverage"))
              .build();
        }
      }
    }
    return getComputeAverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bebit.calculator.FindMaximumRequest,
      com.bebit.calculator.FindMaximumResponse> getFindMaximumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findMaximum",
      requestType = com.bebit.calculator.FindMaximumRequest.class,
      responseType = com.bebit.calculator.FindMaximumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.bebit.calculator.FindMaximumRequest,
      com.bebit.calculator.FindMaximumResponse> getFindMaximumMethod() {
    io.grpc.MethodDescriptor<com.bebit.calculator.FindMaximumRequest, com.bebit.calculator.FindMaximumResponse> getFindMaximumMethod;
    if ((getFindMaximumMethod = CalculatorServiceGrpc.getFindMaximumMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getFindMaximumMethod = CalculatorServiceGrpc.getFindMaximumMethod) == null) {
          CalculatorServiceGrpc.getFindMaximumMethod = getFindMaximumMethod =
              io.grpc.MethodDescriptor.<com.bebit.calculator.FindMaximumRequest, com.bebit.calculator.FindMaximumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findMaximum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.FindMaximumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bebit.calculator.FindMaximumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("findMaximum"))
              .build();
        }
      }
    }
    return getFindMaximumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceStub>() {
        @java.lang.Override
        public CalculatorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorServiceStub(channel, callOptions);
        }
      };
    return CalculatorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceBlockingStub>() {
        @java.lang.Override
        public CalculatorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorServiceBlockingStub(channel, callOptions);
        }
      };
    return CalculatorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorServiceFutureStub>() {
        @java.lang.Override
        public CalculatorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorServiceFutureStub(channel, callOptions);
        }
      };
    return CalculatorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void sum(com.bebit.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.bebit.calculator.SumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSumMethod(), responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void getTable(com.bebit.calculator.TableRequest request,
        io.grpc.stub.StreamObserver<com.bebit.calculator.TableResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTableMethod(), responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bebit.calculator.ComputeRequest> computeAverage(
        io.grpc.stub.StreamObserver<com.bebit.calculator.ComputeResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getComputeAverageMethod(), responseObserver);
    }

    /**
     * <pre>
     *bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bebit.calculator.FindMaximumRequest> findMaximum(
        io.grpc.stub.StreamObserver<com.bebit.calculator.FindMaximumResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getFindMaximumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.bebit.calculator.SumRequest,
                com.bebit.calculator.SumResponse>(
                  this, METHODID_SUM)))
          .addMethod(
            getGetTableMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.bebit.calculator.TableRequest,
                com.bebit.calculator.TableResponse>(
                  this, METHODID_GET_TABLE)))
          .addMethod(
            getComputeAverageMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.bebit.calculator.ComputeRequest,
                com.bebit.calculator.ComputeResponse>(
                  this, METHODID_COMPUTE_AVERAGE)))
          .addMethod(
            getFindMaximumMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.bebit.calculator.FindMaximumRequest,
                com.bebit.calculator.FindMaximumResponse>(
                  this, METHODID_FIND_MAXIMUM)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractAsyncStub<CalculatorServiceStub> {
    private CalculatorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void sum(com.bebit.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.bebit.calculator.SumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void getTable(com.bebit.calculator.TableRequest request,
        io.grpc.stub.StreamObserver<com.bebit.calculator.TableResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bebit.calculator.ComputeRequest> computeAverage(
        io.grpc.stub.StreamObserver<com.bebit.calculator.ComputeResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getComputeAverageMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bebit.calculator.FindMaximumRequest> findMaximum(
        io.grpc.stub.StreamObserver<com.bebit.calculator.FindMaximumResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getFindMaximumMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.bebit.calculator.SumResponse sum(com.bebit.calculator.SumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSumMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public java.util.Iterator<com.bebit.calculator.TableResponse> getTable(
        com.bebit.calculator.TableRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetTableMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bebit.calculator.SumResponse> sum(
        com.bebit.calculator.SumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUM = 0;
  private static final int METHODID_GET_TABLE = 1;
  private static final int METHODID_COMPUTE_AVERAGE = 2;
  private static final int METHODID_FIND_MAXIMUM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUM:
          serviceImpl.sum((com.bebit.calculator.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.bebit.calculator.SumResponse>) responseObserver);
          break;
        case METHODID_GET_TABLE:
          serviceImpl.getTable((com.bebit.calculator.TableRequest) request,
              (io.grpc.stub.StreamObserver<com.bebit.calculator.TableResponse>) responseObserver);
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
        case METHODID_COMPUTE_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.computeAverage(
              (io.grpc.stub.StreamObserver<com.bebit.calculator.ComputeResponse>) responseObserver);
        case METHODID_FIND_MAXIMUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findMaximum(
              (io.grpc.stub.StreamObserver<com.bebit.calculator.FindMaximumResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bebit.calculator.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculatorService");
    }
  }

  private static final class CalculatorServiceFileDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier {
    CalculatorServiceFileDescriptorSupplier() {}
  }

  private static final class CalculatorServiceMethodDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceFileDescriptorSupplier())
              .addMethod(getSumMethod())
              .addMethod(getGetTableMethod())
              .addMethod(getComputeAverageMethod())
              .addMethod(getFindMaximumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
