package com.caoguzelmas.server;

import com.caoguzelmas.models.*;
import io.grpc.Status;
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

    @Override
    public void withDraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        int accountNumber = request.getAccountNumber();
        int amount = request.getAmount();
        int balance = AccountDatabase.getBalance(accountNumber);

        if (balance < amount) {
            // status codes doc
            // https://developers.google.com/maps-booking/reference/grpc-api-v2/status_codes
            Status status = Status.FAILED_PRECONDITION.withDescription("balance < amount");
            responseObserver.onError(status.asRuntimeException());

            return;
        }

        for (int i = 0; i < (amount / 10); i++) {
            Money money = Money.newBuilder().setValue(10).build();
            responseObserver.onNext(money);
            AccountDatabase.deductBalance(accountNumber, 10);
        }
        responseObserver.onCompleted();
    }
}
