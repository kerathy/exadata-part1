package com.example.dependencyinjectionwithdagger2;

import dagger.Subcomponent;

@MyActivityScope
@Subcomponent(modules={ MyActivityModule.class })
public interface MyActivitySubcomponent {

    void inject(MyActivity myActivity);

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<MyActivitySubcomponent> {
        Builder activityModule(MyActivityModule module);
    }
}

