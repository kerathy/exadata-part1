package com.example.dependencyinjectionwithdagger2;

import android.app.Application;

public class MyApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger%COMPONENT_NAME%
        mAppComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();

    }

    public AppComponent getAppComponent() {
        System.out.println("print: AppComponent");
        return mAppComponent;
    }

}
