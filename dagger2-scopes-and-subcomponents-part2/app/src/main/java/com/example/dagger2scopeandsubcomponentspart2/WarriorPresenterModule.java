package com.example.dagger2scopeandsubcomponentspart2;


import dagger.Module;
import dagger.Provides;

@Module
public class WarriorPresenterModule {

    @Provides
    @WarriorPresenterScope
    WarriorPresenter provideWarriorPresenter(Warrior warrior) {
        return new WarriorPresenter(warrior);
    }
}
