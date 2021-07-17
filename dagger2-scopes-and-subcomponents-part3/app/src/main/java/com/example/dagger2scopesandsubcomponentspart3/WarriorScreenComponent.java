package com.example.dagger2scopesandsubcomponentspart3;

import dagger.Component;
import dagger.Subcomponent;

@WarriorScreenScope
@Subcomponent(modules = {WarriorScreenModule.class})
public interface WarriorScreenComponent {

    void inject(WarriorActivity warriorActivity);
}
