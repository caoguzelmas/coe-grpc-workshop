package com.caoguzelmas.protobuf;

import com.caoguzelmas.models.Credentials;
import com.caoguzelmas.models.EmailCredentials;
import com.caoguzelmas.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("somename@somedomain.com")
                .setPassword("pwd123").build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1234567890)
                .setCode(123).build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }
    }
}
