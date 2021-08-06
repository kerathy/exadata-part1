package com.example.dagger2example.car;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {

    private static final String TAG = "Print: PetrolEngine";

    private int horsePower;

    @Inject
    public PetrolEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: Petrol Engine started, the value of horsePower: " + horsePower);
    }
}
