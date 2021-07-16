package com.example.dagger2scopesandsubcomponentspart1_2;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private int index;

    @ApplicationScope
    @Provides
    Warrior provideWarrior() {
        index++;
        return new Warrior("Warrior: " + index);
    }
}
