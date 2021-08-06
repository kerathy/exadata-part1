package com.example.dagger2example;

import android.app.Application;

import com.example.dagger2example.dagger.ActivityComponent;
import com.example.dagger2example.dagger.AppComponent;
import com.example.dagger2example.dagger.DaggerAppComponent;
//import com.example.dagger2example.dagger.DaggerActivityComponent;

public class ExampleApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
