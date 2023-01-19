package com.caoguzelmas.protobuf;

import com.caoguzelmas.models.BodyStyle;
import com.caoguzelmas.models.Car;
import com.caoguzelmas.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {
        Car mustang = Car.newBuilder()
                .setMake("Ford")
                .setModel("Mustang")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(1967)
                .build();

        Car ka = Car.newBuilder()
                .setMake("Ford")
                .setModel("Ka")
                .setBodyStyle(BodyStyle.HATCHBACK)
                .setYear(1997)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(1967, mustang)
                .putModel(1997, ka)
                .build();

        System.out.println(dealer.getModelOrThrow(1997).getBodyStyle());
    }
}
