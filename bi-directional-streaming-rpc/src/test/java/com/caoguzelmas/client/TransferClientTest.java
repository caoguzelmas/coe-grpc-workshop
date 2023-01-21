package com.caoguzelmas.client;

import com.caoguzelmas.models.BankServiceGrpc;
import com.caoguzelmas.models.TransferRequest;
import com.caoguzelmas.models.TransferServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferClientTest {

    private TransferServiceGrpc.TransferServiceStub stub;


    @BeforeAll
    public void setUp() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
        this.stub = TransferServiceGrpc.newStub(managedChannel);
    }

    @Test
    public void transferTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TransferStreamingResponse response = new TransferStreamingResponse(countDownLatch);

        StreamObserver<TransferRequest> requestStreamObserver = this.stub.transfer(response);

        for (int i = 0; i < 100; i++) {
            TransferRequest transferRequest = TransferRequest.newBuilder()
                    .setFromAccount(ThreadLocalRandom.current().nextInt(1, 11))
                    .setToAccount(ThreadLocalRandom.current().nextInt(1, 11))
                    .setAmount(ThreadLocalRandom.current().nextInt(1, 21)).build();

            requestStreamObserver.onNext(transferRequest);
        }

        requestStreamObserver.onCompleted();
        countDownLatch.await();
    }
}
