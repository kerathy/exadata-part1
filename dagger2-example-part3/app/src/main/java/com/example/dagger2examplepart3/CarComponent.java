package com.example.dagger2examplepart3;

import dagger.Component;

@Component
public interface CarComponent {

    void inject(MainActivity mainActivity);
}

