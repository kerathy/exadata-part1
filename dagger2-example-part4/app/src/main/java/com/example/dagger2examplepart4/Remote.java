package com.example.dagger2examplepart4;

import android.util.Log;

import javax.inject.Inject;

public class Remote {

    private static final String TAG = "Print:Remote";

    @Inject
    public Remote() {
    }

    public void setListener(Car car) {
        Log.d(TAG, "setListener method, parameter: Car");
    }
}

