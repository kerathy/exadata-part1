package com.example.dagger2example.car;

import android.util.Log;

import com.example.dagger2example.car.Engine;
import com.example.dagger2example.car.Remote;
import com.example.dagger2example.car.Wheels;

import javax.inject.Inject;

//public class Car {
//
//    private static final String TAG = "Car";
//
//    private Engine engine;
//
//    private Wheels wheels;
//
//    @Inject
//    public Car(Engine engine, Wheels wheels) {
//        this.engine = engine;
//        this.wheels = wheels;
//    }
//
//    public void drive() {
//        Log.d(TAG, "drive method...");
//    }
//
//}


public class Car {

    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;
    private Driver driver;

    @Inject
    public Car(Wheels wheels, Driver driver, Engine engine) {
        this.wheels = wheels;
        this.driver = driver;
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, driver + "drive: " + this);
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}