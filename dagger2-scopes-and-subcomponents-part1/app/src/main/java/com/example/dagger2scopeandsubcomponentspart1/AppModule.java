package com.example.dagger2scopeandsubcomponentspart1;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private int index = 0;

    @Provides
    public Warrior provideWarrior() {
        index++;
        return new Warrior("Warrior " + index);
    }
}


//example with applicationscope
//@Module
//public class AppModule {
//    private int index = 0;
//
//    @Provides
//    @ApplicationScope
//    public Warrior provideWarrior() {
//        index++;
//        return new Warrior("Warrior " + index);
//    }
//}


