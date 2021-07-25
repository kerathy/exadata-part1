package com.example.dependencyinjectionwithdagger2;

import android.app.Application;

public class MyApp extends Application {

    private AppComponent mAppComponent;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//         Dagger%COMPONENT_NAME%
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        userComponent = DaggerUserComponent.builder()
                .appComponent(mAppComponent)
                .gitHubModule(new GitHubModule()) // this is optional
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
