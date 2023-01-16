package com.caoguzelmas.protobuf;

import com.caoguzelmas.models.Person;

public class PersonDemo {

    public static void main(String[] args) {
        Person p = Person.newBuilder().setName("Cagatay Oguz").setAge(25).build();

        System.out.println(p.toString());
    }
}
