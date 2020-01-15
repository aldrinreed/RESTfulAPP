package com.firstSpringProject.app.ws.combined;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/30/2019
 * Time:   2:00 PM
 */

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserID(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length){
        StringBuilder returnValue = new StringBuilder(length);

        for(int i = 0; i < length; i++){
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String((returnValue));
    }
}
