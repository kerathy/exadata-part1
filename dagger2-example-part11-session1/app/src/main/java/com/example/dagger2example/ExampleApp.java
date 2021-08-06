package com.example.dagger2example;

import android.app.Application;

import com.example.dagger2example.dagger.CarComponent;
import com.example.dagger2example.dagger.DaggerCarComponent;

public class ExampleApp extends Application {

    private CarComponent carComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        carComponent = DaggerCarComponent.builder()
                .horsePower(120)
                .engineCapacity(1400)
                .build();
    }

    public CarComponent getAppComponent() {
        return carComponent;
    }
}
