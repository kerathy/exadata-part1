package com.example.dagger2examplepart4;

import android.util.Log;

import javax.inject.Inject;

public class Car {

    private static final String TAG = "PrintCar";

    @Inject
    Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Wheels wheels) {
        this.wheels = wheels;
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        Log.d(TAG, "drive method...");
    }

}
