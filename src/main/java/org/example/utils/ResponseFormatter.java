package org.example.utils;

public class ResponseFormatter {
    public static String removeEndQuotesAndLeadingSpaces(String response) {
        if (response == null || response.isEmpty()) {
            return response;
        }

        String trimmedResponse = response.strip();
        StringBuilder stringBuilder = new StringBuilder(trimmedResponse);

        while (!stringBuilder.isEmpty() && stringBuilder.charAt(0) == '\"') {
            stringBuilder.deleteCharAt(0);
        }

        while (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) == '\"') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }
}
