package com.example.dependencyinjectionwithdagger2;

import android.app.Application;

public class MyApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        System.out.println("print: MyApp" );
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().build();
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
