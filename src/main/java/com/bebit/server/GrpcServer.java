package com.bebit.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.File;
import java.io.IOException;

public class GrpcServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Hello gRPC......");

    Server server = ServerBuilder.forPort(50051)
        .addService(new CalculatorServiceImpl())
        .addService(new GreetingServiceImpl())
        //secure server. If you want plaintext server, comment below code.
        .useTransportSecurity(
            new File("ssl/server.crt"),
            new File("ssl/server.pem")
        )
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
