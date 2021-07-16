package com.example.dagger2scopeandsubcomponentspart1;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    public Warrior getWarrior();

    void inject(WarriorApplication warriorApplication);
}


////example with applicationscope
//@ApplicationScope
//@Component(modules = {AppModule.class})
//public interface AppComponent {
//
//    public Warrior getWarrior();
//
//    void inject(WarriorApplication warriorApplication);
////    void inject(MainActivity mainActivity);
//}