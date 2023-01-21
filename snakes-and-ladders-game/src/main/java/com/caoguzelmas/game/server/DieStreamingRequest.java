package com.caoguzelmas.game.server;

import com.caoguzelmas.models.Die;
import com.caoguzelmas.models.GameState;
import com.caoguzelmas.models.Player;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ThreadLocalRandom;

public class DieStreamingRequest implements StreamObserver<Die> {
    private Player client;
    private Player server;
    private StreamObserver<GameState> gameStateStreamObserver;

    public DieStreamingRequest(Player client, Player server, StreamObserver<GameState> gameStateStreamObserver) {
        this.client = client;
        this.server = server;
        this.gameStateStreamObserver = gameStateStreamObserver;
    }

    @Override
    public void onNext(Die die) {
        this.client = this.updatePlayerPosition(this.client, die.getValue());

        if(this.client.getPosition() != 100) {
            this.server = this.updatePlayerPosition(this.server, ThreadLocalRandom.current().nextInt(1,7));
        }

        this.gameStateStreamObserver.onNext(this.getGameState());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        this.gameStateStreamObserver.onCompleted();
    }

    private Player updatePlayerPosition(Player player, int dieValue) {
        int currentPosition = player.getPosition() + dieValue;
        currentPosition = SnakesAndLaddersMap.getPosition(currentPosition);

        if (currentPosition <= 100) {
            player = player.toBuilder().setPosition(currentPosition).build();
        }

        return player;
    }

    private GameState getGameState() {
        return GameState.newBuilder()
                .addPlayers(this.client)
                .addPlayers(this.server).build();
    }
}
