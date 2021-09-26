package com.example.unittestexample.data;

public class EmailValidator {

    public static boolean isValidOrNot(String email, String emailPattern) {
        return email.matches(emailPattern);
    }
}
