package com.caoguzelmas.client;

import com.caoguzelmas.models.Balance;
import com.caoguzelmas.models.BalanceCheckRequest;
import com.caoguzelmas.models.BankServiceGrpc;
import com.caoguzelmas.models.WithdrawRequest;
import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;
    private BankServiceGrpc.BankServiceStub bankServiceStub;

    @BeforeAll
    public void setUp() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
        this.bankServiceStub = BankServiceGrpc.newStub(managedChannel);
    }

    @Test
    public void balanceTest() {
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(2)
                .build();

        Balance balance = this.blockingStub.getBalance(balanceCheckRequest);

        System.out.println("Received: " + balance.getAmount());
    }

    @Test
    public void withDrawTest() {
        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder().setAccountNumber(7).setAmount(40).build();
        this.blockingStub.withDraw(withdrawRequest)
                .forEachRemaining(money -> System.out.println("Received: " + money.getValue()));
    }

    @Test
    public void withDrawAsyncTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder().setAccountNumber(10).setAmount(50).build();
        this.bankServiceStub.withDraw(withdrawRequest, new MoneyStreamingResponse(countDownLatch));
        countDownLatch.await();
    }
}
