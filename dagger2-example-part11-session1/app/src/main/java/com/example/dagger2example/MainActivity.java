package com.example.dagger2example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dagger2example.car.Car;
import com.example.dagger2example.dagger.CarComponent;
import com.example.dagger2example.dagger.DaggerCarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent = ((ExampleApp)getApplication()).getAppComponent();
        carComponent.inject(this);
        car1.drive();
        car2.drive();
    }
}

