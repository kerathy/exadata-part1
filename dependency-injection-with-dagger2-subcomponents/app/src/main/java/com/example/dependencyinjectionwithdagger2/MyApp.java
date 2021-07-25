package com.example.dependencyinjectionwithdagger2;

import android.app.Application;

public class MyApp extends Application {

    private MyApplicationComponent myApplicationComponent;

    @Override
    public void onCreate() {
        System.out.println("print: MyApp" );
        super.onCreate();
        myApplicationComponent = DaggerMyApplicationComponent.builder().build();
    }

    public MyApplicationComponent getMyApplicationComponent() {

        return myApplicationComponent;
    }
}
