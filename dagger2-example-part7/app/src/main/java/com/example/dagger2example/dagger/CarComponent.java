package com.example.dagger2example.dagger;

import com.example.dagger2example.car.Car;
import com.example.dagger2example.MainActivity;

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


@Component (modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);
}