package com.bebit.server;

import com.bebit.calculator.CalculatorServiceGrpc.CalculatorServiceImplBase;
import com.bebit.calculator.ComputeRequest;
import com.bebit.calculator.ComputeResponse;
import com.bebit.calculator.FindMaximumRequest;
import com.bebit.calculator.FindMaximumResponse;
import com.bebit.calculator.SquareRootRequest;
import com.bebit.calculator.SquareRootResponse;
import com.bebit.calculator.SumRequest;
import com.bebit.calculator.SumResponse;
import com.bebit.calculator.TableRequest;
import com.bebit.calculator.TableResponse;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceImplBase {

  /**
   * Unary RPC.
   *
   * @param request coming from the client.
   * @param responseObserver async always.
   */
  @Override
  public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
    int result = request.getFirstNumber() + request.getSecondNumber();
    SumResponse sumResponse = SumResponse.newBuilder().setSumResult(result).build();
    responseObserver.onNext(sumResponse);
    responseObserver.onCompleted();
  }

  /** Server streaming example. Method signature is exactly same as that of Unary. */
  @Override
  public void getTable(TableRequest request, StreamObserver<TableResponse> responseObserver) {
    int number = request.getNumber();
    for (int i = 1; i <= 10; i++) {
      String result = number + " * " + i + " = " + number * i;
      TableResponse tableResponse = TableResponse.newBuilder().setResult(result).build();
      responseObserver.onNext(tableResponse);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    responseObserver.onCompleted();
  }

  /** client streaming example. */
  @Override
  public StreamObserver<ComputeRequest> computeAverage(
      StreamObserver<ComputeResponse> responseObserver) {
    return new StreamObserver<>() {
      int sum = 0;
      int count = 0;

      @Override
      public void onNext(ComputeRequest computeRequest) {
        sum += computeRequest.getNumber();
        count++;
      }

      @Override
      public void onError(Throwable t) {}

      @Override
      public void onCompleted() {
        // compute average
        double average = (double) sum / count;
        ComputeResponse computeResponse = ComputeResponse.newBuilder().setAverage(average).build();
        responseObserver.onNext(computeResponse);
        responseObserver.onCompleted();
      }
    };
  }

  @Override
  public StreamObserver<FindMaximumRequest> findMaximum(
      StreamObserver<FindMaximumResponse> responseObserver) {

    return new StreamObserver<FindMaximumRequest>() {
      int maximum = 0;

      @Override
      public void onNext(FindMaximumRequest findMaximumRequest) {
        try {
          if (findMaximumRequest.getNumber() > maximum) {
            maximum = findMaximumRequest.getNumber();
          }
          // here is a change for bidi against client streaming.
          responseObserver.onNext(FindMaximumResponse.newBuilder().setMaximum(maximum).build());
        } catch (Exception exception) {
          exception.getStackTrace();
        }
      }

      @Override
      public void onError(Throwable t) {
        System.out.println("erro ...." + t.getMessage());
        responseObserver.onCompleted();
      }

      @Override
      public void onCompleted() {
        // send last maximum.
        responseObserver.onNext(FindMaximumResponse.newBuilder().setMaximum(maximum).build());
        responseObserver.onCompleted();
      }
    };
  }

}
