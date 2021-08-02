package com.example.dagger2scopesandsubcomponents

import dagger.Component

//@Component(modules = [AppModule::class])
//interface AppComponent {
//    fun getWarrior(): Warrior
//}

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getWarrior(): Warrior
}