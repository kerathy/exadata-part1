package com.example.dependencyinjectionwithretrofit;

import android.app.Application;

import com.example.dependencyinjectionwithretrofit.dagger2.DaggerNetworkComponent;
import com.example.dependencyinjectionwithretrofit.dagger2.NetworkComponent;
import com.example.dependencyinjectionwithretrofit.dagger2.NetworksModule;

public class CustomApplication extends Application {
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .networksModule(new NetworksModule(Helper.URL))
                .build();
    }

    public NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}
