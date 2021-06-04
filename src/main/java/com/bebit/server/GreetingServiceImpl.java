package com.bebit.server;

import com.bebit.greeting.GreetWithDeadlineRequest;
import com.bebit.greeting.GreetWithDeadlineResponse;
import com.bebit.greeting.GreetingServiceGrpc.GreetingServiceImplBase;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceImplBase {

  @Override
  public void greetWithDeadline(
      GreetWithDeadlineRequest request,
      StreamObserver<GreetWithDeadlineResponse> responseObserver) {
    Context current = Context.current();
    try {
      for (int i = 0; i < 3; i++) {
        if (!current.isCancelled()) {
          System.out.println("sleep for 100 seconds.");
          Thread.sleep(100);
        } else {
          return;
        }
      }
      responseObserver.onNext(
          GreetWithDeadlineResponse.newBuilder()
              .setResponse("Hello " + request.getFirstName())
              .build());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    responseObserver.onCompleted();
  }
}
