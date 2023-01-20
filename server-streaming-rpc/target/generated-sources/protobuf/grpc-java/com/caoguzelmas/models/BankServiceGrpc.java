package com.caoguzelmas.models;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.0)",
    comments = "Source: bank-service.proto")
public final class BankServiceGrpc {

  private BankServiceGrpc() {}

  public static final String SERVICE_NAME = "BankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.caoguzelmas.models.BalanceCheckRequest,
      com.caoguzelmas.models.Balance> getGetBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBalance",
      requestType = com.caoguzelmas.models.BalanceCheckRequest.class,
      responseType = com.caoguzelmas.models.Balance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.caoguzelmas.models.BalanceCheckRequest,
      com.caoguzelmas.models.Balance> getGetBalanceMethod() {
    io.grpc.MethodDescriptor<com.caoguzelmas.models.BalanceCheckRequest, com.caoguzelmas.models.Balance> getGetBalanceMethod;
    if ((getGetBalanceMethod = BankServiceGrpc.getGetBalanceMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetBalanceMethod = BankServiceGrpc.getGetBalanceMethod) == null) {
          BankServiceGrpc.getGetBalanceMethod = getGetBalanceMethod = 
              io.grpc.MethodDescriptor.<com.caoguzelmas.models.BalanceCheckRequest, com.caoguzelmas.models.Balance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BankService", "getBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caoguzelmas.models.BalanceCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caoguzelmas.models.Balance.getDefaultInstance()))
                  .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("getBalance"))
                  .build();
          }
        }
     }
     return getGetBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.caoguzelmas.models.WithdrawRequest,
      com.caoguzelmas.models.Money> getWithDrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "withDraw",
      requestType = com.caoguzelmas.models.WithdrawRequest.class,
      responseType = com.caoguzelmas.models.Money.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.caoguzelmas.models.WithdrawRequest,
      com.caoguzelmas.models.Money> getWithDrawMethod() {
    io.grpc.MethodDescriptor<com.caoguzelmas.models.WithdrawRequest, com.caoguzelmas.models.Money> getWithDrawMethod;
    if ((getWithDrawMethod = BankServiceGrpc.getWithDrawMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getWithDrawMethod = BankServiceGrpc.getWithDrawMethod) == null) {
          BankServiceGrpc.getWithDrawMethod = getWithDrawMethod = 
              io.grpc.MethodDescriptor.<com.caoguzelmas.models.WithdrawRequest, com.caoguzelmas.models.Money>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BankService", "withDraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caoguzelmas.models.WithdrawRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caoguzelmas.models.Money.getDefaultInstance()))
                  .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("withDraw"))
                  .build();
          }
        }
     }
     return getWithDrawMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankServiceStub newStub(io.grpc.Channel channel) {
    return new BankServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BankServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBalance(com.caoguzelmas.models.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.caoguzelmas.models.Balance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceMethod(), responseObserver);
    }

    /**
     */
    public void withDraw(com.caoguzelmas.models.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.caoguzelmas.models.Money> responseObserver) {
      asyncUnimplementedUnaryCall(getWithDrawMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.caoguzelmas.models.BalanceCheckRequest,
                com.caoguzelmas.models.Balance>(
                  this, METHODID_GET_BALANCE)))
          .addMethod(
            getWithDrawMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.caoguzelmas.models.WithdrawRequest,
                com.caoguzelmas.models.Money>(
                  this, METHODID_WITH_DRAW)))
          .build();
    }
  }

  /**
   */
  public static final class BankServiceStub extends io.grpc.stub.AbstractStub<BankServiceStub> {
    private BankServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankServiceStub(channel, callOptions);
    }

    /**
     */
    public void getBalance(com.caoguzelmas.models.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.caoguzelmas.models.Balance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void withDraw(com.caoguzelmas.models.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.caoguzelmas.models.Money> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getWithDrawMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankServiceBlockingStub extends io.grpc.stub.AbstractStub<BankServiceBlockingStub> {
    private BankServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.caoguzelmas.models.Balance getBalance(com.caoguzelmas.models.BalanceCheckRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.caoguzelmas.models.Money> withDraw(
        com.caoguzelmas.models.WithdrawRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getWithDrawMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankServiceFutureStub extends io.grpc.stub.AbstractStub<BankServiceFutureStub> {
    private BankServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.caoguzelmas.models.Balance> getBalance(
        com.caoguzelmas.models.BalanceCheckRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BALANCE = 0;
  private static final int METHODID_WITH_DRAW = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((com.caoguzelmas.models.BalanceCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.caoguzelmas.models.Balance>) responseObserver);
          break;
        case METHODID_WITH_DRAW:
          serviceImpl.withDraw((com.caoguzelmas.models.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<com.caoguzelmas.models.Money>) responseObserver);
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

  private static abstract class BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.caoguzelmas.models.BankServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankService");
    }
  }

  private static final class BankServiceFileDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier {
    BankServiceFileDescriptorSupplier() {}
  }

  private static final class BankServiceMethodDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankServiceFileDescriptorSupplier())
              .addMethod(getGetBalanceMethod())
              .addMethod(getWithDrawMethod())
              .build();
        }
      }
    }
    return result;
  }
}
