package com.example.dagger2scopesandsubcomponentspart2

import dagger.Module
import dagger.Provides

@Module
class WarriorScreenModule {

    @Provides
    @WarriorScreenScope
    fun provideWarriorPresenter(warrior : Warrior): WarriorPresenter {
        return WarriorPresenter(warrior)
    }
}