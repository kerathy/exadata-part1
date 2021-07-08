package com.example.dependencyinjectionwithdagger2;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(MyActivity myActivity);

}
