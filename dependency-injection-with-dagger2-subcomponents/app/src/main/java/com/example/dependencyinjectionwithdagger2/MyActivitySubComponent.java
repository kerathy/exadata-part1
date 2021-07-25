package com.example.dependencyinjectionwithdagger2;

import dagger.Subcomponent;

@MyActivityScope
@Subcomponent(modules={ MyActivityModule.class })
public interface MyActivitySubComponent {

    void inject(MyActivity myActivity);
}
