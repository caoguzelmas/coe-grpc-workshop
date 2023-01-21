package com.caoguzelmas.game.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(6565)
                .addService(new GameService())
                .build();

        server.start();
        server.awaitTermination();

    }
}
