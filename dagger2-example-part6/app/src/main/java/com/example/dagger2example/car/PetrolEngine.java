package com.example.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine{

    private static final String TAG = "Car";

    @Inject
    public PetrolEngine() {
    }

    @Override
    public void start() {
        Log.d(TAG, "PetrolEngine started");
    }
}
