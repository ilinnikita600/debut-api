package org.example.utils;

import java.util.Base64;

public class Base64Converter {
    public static String encodeToBase64(String input) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(input.getBytes());
    }
}
