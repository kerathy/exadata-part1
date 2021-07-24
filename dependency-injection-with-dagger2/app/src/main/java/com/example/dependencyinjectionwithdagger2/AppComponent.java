package com.example.dependencyinjectionwithdagger2;


import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(MyActivity activity);
}
