package com.example.dagger2scopesandsubcomponentspart2

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    private var index = 0

    @ApplicationScope
    @Provides
    fun provideWarrior(): Warrior {
        index++
        return Warrior("Warrior $index")
    }
}