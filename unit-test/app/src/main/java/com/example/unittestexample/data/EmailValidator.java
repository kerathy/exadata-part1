package com.example.unittestexample.data;

public class EmailValidator {

    public static boolean isValidEmail(String email, String emailPattern) {
        return email.matches(emailPattern);
    }
}
