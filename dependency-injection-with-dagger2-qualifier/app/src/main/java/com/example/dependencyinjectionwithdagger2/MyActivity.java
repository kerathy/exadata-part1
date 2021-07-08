package com.example.dependencyinjectionwithdagger2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;

public class MyActivity extends Activity {

    @Inject @Named("cached")
    OkHttpClient mOkHttpClient;
    @Inject
    SharedPreferences sharedPreferences;

    public void onCreate(Bundle savedInstance) {
        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method
        super.onCreate(savedInstance);
        ((MyApp) getApplication()).getAppComponent().inject(this);
    }

}
