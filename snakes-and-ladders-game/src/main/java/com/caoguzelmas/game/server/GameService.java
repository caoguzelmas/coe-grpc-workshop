package com.caoguzelmas.game.server;

import com.caoguzelmas.models.Die;
import com.caoguzelmas.models.GameServiceGrpc;
import com.caoguzelmas.models.GameState;
import com.caoguzelmas.models.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder().setName("client").setPosition(0).build();
        Player server = Player.newBuilder().setName("server").setPosition(0).build();

        return new DieStreamingRequest(client, server, responseObserver);
    }
}
