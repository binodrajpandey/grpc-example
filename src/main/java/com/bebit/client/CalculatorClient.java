package com.bebit.client;

import com.bebit.calculator.CalculatorServiceGrpc;
import com.bebit.calculator.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import com.bebit.calculator.CalculatorServiceGrpc.CalculatorServiceStub;
import com.bebit.calculator.ComputeRequest;
import com.bebit.calculator.ComputeResponse;
import com.bebit.calculator.FindMaximumRequest;
import com.bebit.calculator.FindMaximumResponse;
import com.bebit.calculator.SquareRootRequest;
import com.bebit.calculator.SquareRootResponse;
import com.bebit.calculator.SumRequest;
import com.bebit.calculator.SumResponse;
import com.bebit.calculator.TableRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public class CalculatorClient {

  public static void main(String[] args) throws SSLException {
    System.out.println("Hello, I am gRPC client");
    ManagedChannel channel =
        //For plain text
        // ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        NettyChannelBuilder.forAddress("localhost", 50051)
            .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
            .build();
    new CalculatorClient().main(channel);
    new GreetingClient().doUnaryCallWithDeadline(channel);

    System.out.println("Shutting down channel....");
    channel.shutdown();
  }

  public void main(ManagedChannel channel) {
    doUnaryCall(channel);
    doServerStreamingCall(channel);
    doClientStreamingCall(channel);
    doBiDirectionalStreaming(channel);
    doErrorCall(channel);
  }

  private void doUnaryCall(ManagedChannel channel) {
    System.out.println("Creating stub ...");
    CalculatorServiceBlockingStub calculatorServiceBlockingStub =
        CalculatorServiceGrpc.newBlockingStub(channel);

    SumRequest sumRequest = SumRequest.newBuilder().setFirstNumber(40).setSecondNumber(30).build();

    SumResponse sumResponse = calculatorServiceBlockingStub.sum(sumRequest);

    System.out.println(
        sumRequest.getFirstNumber()
            + "+ "
            + sumRequest.getSecondNumber()
            + "= "
            + sumResponse.getSumResult());
  }

  private void doServerStreamingCall(ManagedChannel channel) {
    System.out.println("Server streaming............");
    TableRequest tableRequest = TableRequest.newBuilder().setNumber(11).build();
    CalculatorServiceBlockingStub calculatorServiceBlockingStub =
        CalculatorServiceGrpc.newBlockingStub(channel);

    calculatorServiceBlockingStub
        .getTable(tableRequest)
        .forEachRemaining(
            tableResponse -> {
              System.out.println(tableResponse.getResult());
            });
  }

  private void doClientStreamingCall(ManagedChannel channel) {
    System.out.println("Client streaming......");
    // async stub
    CalculatorServiceStub calculatorServiceStub = CalculatorServiceGrpc.newStub(channel);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    StreamObserver<ComputeRequest> computeRequestStreamObserver =
        calculatorServiceStub.computeAverage(
            new StreamObserver<ComputeResponse>() {
              @Override
              public void onNext(ComputeResponse computeResponse) {
                System.out.println("Received a response from the server.");
                System.out.println(computeResponse.getAverage());
              }

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onCompleted() {
                System.out.println("Server completed sending us data.");
                countDownLatch.countDown();
              }
            });

    computeRequestStreamObserver.onNext(ComputeRequest.newBuilder().setNumber(5).build());
    computeRequestStreamObserver.onNext(ComputeRequest.newBuilder().setNumber(15).build());
    computeRequestStreamObserver.onNext(ComputeRequest.newBuilder().setNumber(25).build());
    computeRequestStreamObserver.onNext(ComputeRequest.newBuilder().setNumber(35).build());

    computeRequestStreamObserver.onCompleted();
    try {
      countDownLatch.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    countDownLatch.countDown();
  }

  private void doBiDirectionalStreaming(ManagedChannel channel) {
    CalculatorServiceStub calculatorServiceStub = CalculatorServiceGrpc.newStub(channel);
    System.out.println("Bi-directional streaming....");
    CountDownLatch latch = new CountDownLatch(1);

    StreamObserver<FindMaximumRequest> findMaximumRequestStreamObserver =
        calculatorServiceStub.findMaximum(
            new StreamObserver<>() {
              @Override
              public void onNext(FindMaximumResponse findMaximumResponse) {
                System.out.println("maximum value: " + findMaximumResponse.getMaximum());
              }

              @Override
              public void onError(Throwable t) {
                System.out.println("error" + t.getMessage());
                t.getStackTrace();
                latch.countDown();
              }

              @Override
              public void onCompleted() {
                System.out.println("server done sending response...");
                latch.countDown();
              }
            });

    Arrays.asList(4, 6, 1, 12, 32, 21, 1, 33, 12, 25)
        .forEach(
            value -> {
              System.out.println("sending value" + value);
              findMaximumRequestStreamObserver.onNext(
                  FindMaximumRequest.newBuilder().setNumber(value).build());
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    findMaximumRequestStreamObserver.onCompleted();
    try {
      latch.await(15, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doErrorCall(ManagedChannel channel) {
    System.out.println("callinig remote");
    CalculatorServiceBlockingStub calculatorServiceBlockingStub =
        CalculatorServiceGrpc.newBlockingStub(channel);
    try {
      SquareRootRequest squareRootRequest = SquareRootRequest.newBuilder().setNumber(16).build();
      SquareRootResponse response = calculatorServiceBlockingStub.squareRoot(squareRootRequest);
      System.out.println(
          "Square root of " + squareRootRequest.getNumber() + " is " + response.getSquareRoot());
      squareRootRequest = SquareRootRequest.newBuilder().setNumber(-1).build();
      response = calculatorServiceBlockingStub.squareRoot(squareRootRequest);
      System.out.println(
          "Square root of " + squareRootRequest.getNumber() + " is " + response.getSquareRoot());

    } catch (StatusRuntimeException statusRuntimeException) {
      statusRuntimeException.printStackTrace();
    }
  }
}
