package com.caoguzelmas.client;

import com.caoguzelmas.models.Die;
import com.caoguzelmas.models.GameState;
import com.caoguzelmas.models.Player;
import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GameStateStreamingResponse implements StreamObserver<GameState> {

    private StreamObserver<Die> dieStreamObserver;
    private CountDownLatch countDownLatch;

    public GameStateStreamingResponse(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(GameState gameState) {
        List<Player> playerList = gameState.getPlayersList();

        playerList.forEach(player -> System.out.println(player.getName() + " : " + player.getPosition()));
        boolean anyWinner = playerList.stream().anyMatch(player -> player.getPosition() == 100);


        if (anyWinner) {
            System.out.println("Game over");
            this.dieStreamObserver.onCompleted();
        } else {
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            this.roll();
        }
        System.out.println("########################################");
    }

    @Override
    public void onError(Throwable throwable) {
        this.countDownLatch.countDown();
    }

    @Override
    public void onCompleted() {
        this.countDownLatch.countDown();
    }

    public void setDieStreamObserver(StreamObserver<Die> streamObserver) {
        this.dieStreamObserver = streamObserver;
    }


    public void roll() {
        int dieValue = ThreadLocalRandom.current().nextInt(1,7);
        Die die = Die.newBuilder().setValue(dieValue).build();

        this.dieStreamObserver.onNext(die);
    }
}
