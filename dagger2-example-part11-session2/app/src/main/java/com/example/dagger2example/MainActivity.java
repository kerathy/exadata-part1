package com.example.dagger2example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dagger2example.car.Car;
import com.example.dagger2example.dagger.ActivityComponent;
import com.example.dagger2example.dagger.DaggerActivityComponent;
import com.example.dagger2example.dagger.DaggerAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .horsePower(120)
                .engineCapacity(1400)
                .appComponent(((ExampleApp) getApplication()).getAppComponent())
                .build();

        activityComponent.inject(this);
        car1.drive();
        car2.drive();
    }
}

