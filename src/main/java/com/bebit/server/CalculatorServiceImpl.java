package com.bebit.server;

import com.bebit.calculator.CalculatorServiceGrpc.CalculatorServiceImplBase;
import com.bebit.calculator.SumRequest;
import com.bebit.calculator.SumResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceImplBase {

  @Override
  public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
    int result = request.getFirstNumber() + request.getSecondNumber();
    SumResponse sumResponse = SumResponse.newBuilder()
        .setSumResult(result)
        .build();
    responseObserver.onNext(sumResponse);
    responseObserver.onCompleted();
  }
}
