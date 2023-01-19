package com.caoguzelmas.server;

import com.caoguzelmas.models.Balance;
import com.caoguzelmas.models.BalanceCheckRequest;
import com.caoguzelmas.models.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {

        Balance balance = Balance.newBuilder()
                .setAmount(AccountDatabase.getBalance(request.getAccountNumber()))
                .build();

        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }
}
