package com.example.dagger2scopesandsubcomponentspart3;


import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private int index;

    @Provides
    @ApplicationScope
    Warrior provideWarrior() {
        index++;
        return new Warrior("Warrior: " + index);
    }
}
