package com.bebit.client;

import com.bebit.greeting.GreetWithDeadlineRequest;
import com.bebit.greeting.GreetWithDeadlineResponse;
import com.bebit.greeting.GreetingServiceGrpc;
import com.bebit.greeting.GreetingServiceGrpc.GreetingServiceBlockingStub;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;

public class GreetingClient {
  public void doUnaryCallWithDeadline(ManagedChannel channel) {
    GreetingServiceBlockingStub greetingServiceBlockingStub =
        GreetingServiceGrpc.newBlockingStub(channel);

    // first call with 2000 millisecond, it should succeed.
    try {
      GreetWithDeadlineResponse greetWithDeadlineResponse =
          greetingServiceBlockingStub
              .withDeadline(Deadline.after(2000, TimeUnit.MILLISECONDS))
              .greetWithDeadline(
                  GreetWithDeadlineRequest.newBuilder().setFirstName("Binod").build());
      System.out.println(greetWithDeadlineResponse.getResponse());
    } catch (StatusRuntimeException statusRuntimeException) {
      if (statusRuntimeException.getStatus().getCode()
          == Status.DEADLINE_EXCEEDED.getCode()) {
        System.out.println("Deadline has exceeded, we don't want the response.");
      } else {
        statusRuntimeException.printStackTrace();
      }
    }

    // first call with 300 millisecond, should get deadline exception.
    try {
      GreetWithDeadlineResponse greetWithDeadlineResponse =
          greetingServiceBlockingStub
              .withDeadline(Deadline.after(100, TimeUnit.MILLISECONDS))
              .greetWithDeadline(
                  GreetWithDeadlineRequest.newBuilder().setFirstName("Binod").build());
      System.out.println(greetWithDeadlineResponse.getResponse());
    } catch (StatusRuntimeException statusRuntimeException) {
      if (statusRuntimeException.getStatus().getCode()
          == Status.DEADLINE_EXCEEDED.getCode()) {
        System.out.println("Deadline has exceeded, we don't want the response.");
        }
        else {
        statusRuntimeException.printStackTrace();
      }
    }
  }
}
