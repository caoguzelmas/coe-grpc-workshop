package com.caoguzelmas.client;

import com.caoguzelmas.models.Balance;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class BalanceStreamObserver implements StreamObserver<Balance> {
    private CountDownLatch countDownLatch;
    public BalanceStreamObserver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(Balance balance) {
        System.out.println("Final balance: " + balance.getAmount());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
        this.countDownLatch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Done...");
        this.countDownLatch.countDown();
    }
}
