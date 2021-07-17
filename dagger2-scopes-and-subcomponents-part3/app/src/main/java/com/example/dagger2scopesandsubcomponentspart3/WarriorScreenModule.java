package com.example.dagger2scopesandsubcomponentspart3;


import dagger.Module;
import dagger.Provides;

@Module
public class WarriorScreenModule {

    @Provides
    @WarriorScreenScope
    WarriorPresenter warriorPresenter(Warrior warrior) {
        return new WarriorPresenter(warrior);
    }
}
