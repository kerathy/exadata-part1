package com.example.dependencyinjectionwithdagger2;

import dagger.Component;

@UserScope // using the previously defined scope, note that @Singleton will not work
@Component(dependencies = AppComponent.class, modules = GitHubModule.class)
public interface UserComponent {
    void inject(MyActivity myActivity);
}
