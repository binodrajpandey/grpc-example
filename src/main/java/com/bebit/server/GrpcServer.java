package com.bebit.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Hello gRPC......");

    Server server = ServerBuilder.forPort(50051)
        .addService(new CalculatorServiceImpl())
        .addService(new GreetingServiceImpl())
        .build();
    server.start();

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  System.out.println("Received shutdown signal...");
                  server.shutdown();
                  System.out.println("Successfully shutdown server.");
                }));
    server.awaitTermination();
  }
}
