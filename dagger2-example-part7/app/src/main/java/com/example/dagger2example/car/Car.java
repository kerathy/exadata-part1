package com.example.dagger2example.car;

import android.util.Log;

import javax.inject.Inject;


public class Car {

    private static final String TAG = "Print: Car";

    @Inject
    Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Wheels wheels) {
        this.wheels = wheels;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "drive method...");
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}