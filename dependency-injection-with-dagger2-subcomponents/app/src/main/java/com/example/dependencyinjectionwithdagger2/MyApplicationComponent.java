package com.example.dependencyinjectionwithdagger2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface MyApplicationComponent {

    MyActivitySubComponent newMyActivitySubcomponent(MyActivityModule activityModule);
}
