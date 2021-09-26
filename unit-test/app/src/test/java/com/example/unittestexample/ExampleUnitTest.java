package com.example.unittestexample;

import com.example.unittestexample.data.EmailValidator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {


    @Test
    public void test() {
        String email = "abc@gmail.com";
        String emailPattern = "^(.+)@(.+)$";
        assertEquals(true, email.matches(emailPattern));
    }





}