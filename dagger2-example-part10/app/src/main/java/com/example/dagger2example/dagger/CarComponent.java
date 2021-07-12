package com.example.dagger2example.dagger;

import com.example.dagger2example.car.Car;
import com.example.dagger2example.MainActivity;
import com.example.dagger2example.car.PetrolEngine;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

//@Component
//public interface CarComponent {
//
//    Car getCar();
//}



//field injection

//@Component (modules = {WheelsModule.class, PetrolEngineModule.class})
//public interface CarComponent {
//
//    Car getCar();
//
//    void inject(MainActivity mainActivity);
//}

//@Component (modules = {WheelsModule.class, DieselEngineModule.class})
//public interface CarComponent {
//
//    Car getCar();
//
//    void inject(MainActivity mainActivity);
//}

@Singleton
@Component (modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarComponent build();
    }
}