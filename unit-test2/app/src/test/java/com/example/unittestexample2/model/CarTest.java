package com.example.unittestexample2.model;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @org.junit.jupiter.api.Test
    void getMake() {
        Car car = new Car("make1");
        assertEquals("make1", car.getMake());
    }

    @org.junit.jupiter.api.Test
    void setMake() {
        fail();
    }

}