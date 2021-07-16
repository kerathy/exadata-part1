package com.example.dagger2scopeandsubcomponentspart2;


import dagger.Component;

@Component(modules = {WarriorModule.class})
@WarriorScope
public interface WarriorComponent {

    Warrior getWarrior();

}
