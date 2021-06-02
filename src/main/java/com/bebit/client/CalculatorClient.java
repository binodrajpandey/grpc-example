package com.bebit.client;

import com.bebit.calculator.CalculatorServiceGrpc;
import com.bebit.calculator.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import com.bebit.calculator.SumRequest;
import com.bebit.calculator.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {
  public static void main(String[] args) {
    System.out.println("Hello, I am gRPC client");

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build();
    System.out.println("Creating stub ...");
    CalculatorServiceBlockingStub calculatorServiceBlockingStub = CalculatorServiceGrpc.newBlockingStub(channel);

    SumRequest sumRequest = SumRequest.newBuilder()
        .setFirstNumber(40)
        .setSecondNumber(30)
        .build();

    SumResponse sumResponse = calculatorServiceBlockingStub.sum(sumRequest);

    System.out.println(sumRequest.getFirstNumber()
        + "+ " + sumRequest.getSecondNumber() + "= "+ sumResponse.getSumResult());


    System.out.println("Shutting down channel....");
    channel.shutdown();
  }
}
