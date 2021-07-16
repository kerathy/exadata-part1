package com.example.dagger2scopeandsubcomponentspart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class WarriorPresenterActivity extends AppCompatActivity {
    private static final String TAG = "WarriorPresenterActivit";

    @Inject
    WarriorPresenter warriorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WarriorComponent warriorComponent = DaggerWarriorComponent.builder()
                .warriorModule(new WarriorModule())
                .build();

        WarriorPresenterComponent warriorPresenterComponent = DaggerWarriorPresenterComponent.builder()
                .warriorComponent(warriorComponent)
                .build();

        warriorPresenterComponent.inject(this);

        String name1 = warriorPresenterComponent.getWarriorPresenter().getWarrior().getName();
        String name2 = warriorPresenterComponent.getWarriorPresenter().getWarrior().getName();
        String name3 = warriorPresenter.getWarrior().getName();

        Log.d(TAG, "onCreate: name1: " + name1);
        Log.d(TAG, "onCreate: name2: " + name2);
        Log.d(TAG, "onCreate: name3: " + name3);
        Toast.makeText(this, name1, Toast.LENGTH_LONG).show();
    }
}