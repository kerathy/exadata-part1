package com.example.dependencyinjectionwithdagger2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import javax.inject.Inject;
import okhttp3.OkHttpClient;

public class MyActivity extends Activity {

    @Inject
    OkHttpClient mOkHttpClient;

    @Inject
    SharedPreferences sharedPreferences;

    public void onCreate(Bundle savedInstance) {
        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ((MyApp) getApplication()).getUserComponent().inject(this);
    }

}
