package com.company.util;

public class LinkGeneratorUtils {

    public static String generateResetLink(String email) {
        return "http://localhost:8881/reset-password/" + email;
    }

}
