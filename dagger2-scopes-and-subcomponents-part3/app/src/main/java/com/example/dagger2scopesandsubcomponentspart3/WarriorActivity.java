package com.example.dagger2scopesandsubcomponentspart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class WarriorActivity extends AppCompatActivity {
    private static final String TAG = "WarriorActivity";

    @Inject
    WarriorPresenter warriorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior);

        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();

        WarriorScreenComponent warriorScreenComponent = appComponent.warriorScreenComponent(new WarriorScreenModule());

        warriorScreenComponent.inject(this);

        String name1 = warriorPresenter.getWarrior().getName();
        String name2 = warriorPresenter.getWarrior().getName();

        Log.d(TAG, "onCreate: name1: " + name1);
        Log.d(TAG, "onCreate: name2: " + name2);
        Toast.makeText(this, name1, Toast.LENGTH_LONG).show();

    }
}