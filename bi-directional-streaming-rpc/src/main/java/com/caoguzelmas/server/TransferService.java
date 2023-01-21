package com.caoguzelmas.server;

import com.caoguzelmas.models.TransferRequest;
import com.caoguzelmas.models.TransferResponse;
import com.caoguzelmas.models.TransferServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TransferService extends TransferServiceGrpc.TransferServiceImplBase {

    @Override
    public StreamObserver<TransferRequest> transfer(StreamObserver<TransferResponse> responseObserver) {
        return new TransferStreamingRequest(responseObserver);
    }
}
