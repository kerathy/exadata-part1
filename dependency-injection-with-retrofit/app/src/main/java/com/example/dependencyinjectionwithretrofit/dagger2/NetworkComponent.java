package com.example.dependencyinjectionwithretrofit.dagger2;

import com.example.dependencyinjectionwithretrofit.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {
    public void inject(MainActivity activity);
}
