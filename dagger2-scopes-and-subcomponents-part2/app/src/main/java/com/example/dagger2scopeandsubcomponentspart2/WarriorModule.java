package com.example.dagger2scopeandsubcomponentspart2;


import dagger.Module;
import dagger.Provides;

@Module
public class WarriorModule {

    private int index = 0;

    @Provides
    @WarriorScope
    Warrior provideWarrior() {
        index++;
        return new Warrior("Warrior: " + index);
    }
}
