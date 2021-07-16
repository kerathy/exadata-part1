package com.example.dagger2scopeandsubcomponentspart1;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

public class WarriorApplication extends Application {

    private static final String TAG = "WarriorApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        String name1 = appComponent.getWarrior().getName();
        String name2 = appComponent.getWarrior().getName();

        Toast.makeText(WarriorApplication.this, "name1: " + name1, Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate: " + name1);
        Log.d(TAG, "onCreate: " + name2);
    }
}
