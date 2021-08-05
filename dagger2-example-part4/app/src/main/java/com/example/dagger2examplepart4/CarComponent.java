package com.example.dagger2examplepart4;

import dagger.Component;

@Component
public interface CarComponent {
    Car getCar();
    void inject(MainActivity mainActivity);
}