package com.caoguzelmas.protobuf;

import com.caoguzelmas.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {
        Person person = Person.newBuilder().build();

        System.out.println("City: " + person.getAddress().getCity());

        System.out.println("Has address: " + person.hasAddress());
    }
}
