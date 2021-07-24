package com.example.simpleexampleofusingandroiddagger2javaversion;

import dagger.Component;

@Component(modules = {ActivitiesModule.class})
public interface AppComponent {
    void inject(MyApplication myApplication);
}
