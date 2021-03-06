package com.example.dagger2example.dagger;


import com.example.dagger2example.MainActivity;
import com.example.dagger2example.car.Car;

import dagger.Component;

@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}


