package com.example.dependencyinjectionwithdagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import javax.inject.Inject;

public class MainActivity extends Activity {

//    AppCompat
//    @Inject MyTwitterApiClient mTwitterApiClient;
//    @Inject SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        InjectorClass.inject(this);
    }
}