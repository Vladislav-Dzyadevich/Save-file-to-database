package com.company.util;

public class LinkGeneratorUtils {

    public static String generateResetLink(String email) {
        return "https://book-service.herokuapp.com/reset-password/" + email;
    }

}
