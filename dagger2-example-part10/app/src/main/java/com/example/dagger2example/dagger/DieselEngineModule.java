package com.example.dagger2example.dagger;

import com.example.dagger2example.car.DieselEngine;
import com.example.dagger2example.car.Engine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

//@Module
//public abstract class DieselEngineModule {
//
//    @Binds
//    abstract Engine bindEngine(DieselEngine engine);
//}


@Module
public class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    int provideHorsePower() {
        return horsePower;
    }

    @Provides
    Engine provideEngine(DieselEngine dieselEngine) {
        return dieselEngine;
    }
}