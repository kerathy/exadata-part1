package com.example.dagger2scopesandsubcomponentspart2

import dagger.Component
import dagger.Subcomponent

//@WarriorScreenScope
//@Component(modules = [WarriorScreenModule::class],
//    dependencies = [AppComponent::class])
//interface WarriorScreenComponent {
//    fun inject(warriorActivity: WarriorActivity)
//}


@WarriorScreenScope
@Subcomponent(modules = [WarriorScreenModule::class])
interface WarriorScreenComponent {
    fun inject(warriorActivity: WarriorActivity)
}