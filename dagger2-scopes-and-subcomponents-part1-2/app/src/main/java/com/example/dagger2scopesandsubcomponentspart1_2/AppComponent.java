package com.example.dagger2scopesandsubcomponentspart1_2;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    Warrior getWarrior();

    void inject(WarriorApplication warriorApplication);
}
