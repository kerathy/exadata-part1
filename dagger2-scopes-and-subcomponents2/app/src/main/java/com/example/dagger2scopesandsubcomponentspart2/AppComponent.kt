package com.example.dagger2scopesandsubcomponentspart2

import dagger.Component

//@ApplicationScope
//@Component(modules = [AppModule::class])
//interface AppComponent {
//    fun getWarrior(): Warrior
//}


@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun warriorScreenComponent(warriorScreenModule: WarriorScreenModule) : WarriorScreenComponent
}