package com.example.dagger2scopeandsubcomponentspart2;

import dagger.Component;

@Component(modules = {WarriorPresenterModule.class}, dependencies = {WarriorComponent.class})
@WarriorPresenterScope
public interface WarriorPresenterComponent {

    WarriorPresenter getWarriorPresenter();

    void inject(WarriorPresenterActivity warriorPresenterActivity);
}
