package com.example.dagger2example.car;

import android.util.Log;
import javax.inject.Inject;

public class Car {

    private static final String TAG = "Print: Car";

    private Driver driver;
    @Inject
    Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Driver driver, Wheels wheels) {
        this.driver = driver;
        this.wheels = wheels;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, driver + " drives " + this);
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}