package com.caoguzelmas.protobuf;

import com.caoguzelmas.models.Address;
import com.caoguzelmas.models.Car;
import com.caoguzelmas.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("Main Street")
                .setCity("Amsterdam")
                .build();

        Car mustang = Car.newBuilder()
                .setMake("Ford")
                .setModel("Mustang")
                .setYear(1967)
                .build();

        Car ka = Car.newBuilder()
                .setMake("Ford")
                .setModel("Ka")
                .setYear(1997)
                .build();

        List<Car> carList = new ArrayList<>();
        carList.add(mustang);
        carList.add(ka);

        Person henry = Person.newBuilder()
                .setName("Henry")
                .setAge(44)
                .addAllCar(carList)
                .setAddress(address)
                .build();

        System.out.println(henry);

    }
}
