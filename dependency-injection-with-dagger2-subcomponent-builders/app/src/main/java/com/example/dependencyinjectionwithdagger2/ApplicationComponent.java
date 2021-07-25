package com.example.dependencyinjectionwithdagger2;

import java.util.Map;
import javax.inject.Provider;
import dagger.Component;

@Component(modules={ApplicationBinders.class})
public interface ApplicationComponent {

    Map<Class<?>, Provider<SubcomponentBuilder>> subcomponentBuilders();
}
