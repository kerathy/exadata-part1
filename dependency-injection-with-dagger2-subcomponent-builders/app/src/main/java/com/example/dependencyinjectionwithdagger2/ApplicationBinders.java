package com.example.dependencyinjectionwithdagger2;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents={ MyActivitySubcomponent.class })
public abstract class ApplicationBinders {

    @Binds
    @IntoMap
    @SubcomponentKey(MyActivitySubcomponent.Builder.class)
    public abstract SubcomponentBuilder myActivity(MyActivitySubcomponent.Builder impl);
}
