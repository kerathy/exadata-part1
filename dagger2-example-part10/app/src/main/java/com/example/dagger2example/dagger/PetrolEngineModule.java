package com.example.dagger2example.dagger;

import com.example.dagger2example.car.Engine;
import com.example.dagger2example.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

//@Module
//public class PetrolEngineModule {
//
//    @Provides
//    Engine provideEngine(PetrolEngine engine) {
//        return engine;
//    }
//}

//instead of provides



@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}