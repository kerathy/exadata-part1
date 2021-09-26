package com.example.unittestexample.data;

public class EmailValidator {

    public static boolean isValidOrNot(String email, String emailPattern) {
        if (email.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }
}
