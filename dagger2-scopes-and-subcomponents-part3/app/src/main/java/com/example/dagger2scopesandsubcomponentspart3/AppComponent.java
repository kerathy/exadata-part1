package com.example.dagger2scopesandsubcomponentspart3;


import dagger.Component;

@Component(modules = {AppModule.class})
@ApplicationScope
public interface AppComponent {

    WarriorScreenComponent warriorScreenComponent(WarriorScreenModule warriorScreenModule);
}
