package com.example.dagger2example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dagger2example.car.Car;
import com.example.dagger2example.dagger.ActivityComponent;
import com.example.dagger2example.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent = ((ExampleApp) getApplication()).getAppComponent()
                .getActivityComponent(new DieselEngineModule(120));

        activityComponent.inject(this);
        car1.drive();
        car2.drive();
    }
}

