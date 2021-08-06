package com.example.dagger2example.car;

import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
//public class Driver {
//
//    @Inject
//    public Driver() {
//
//    }
//}

//create module
public class Driver {

    String name;

    public Driver(String name) {
        this.name = name;
    }
}
