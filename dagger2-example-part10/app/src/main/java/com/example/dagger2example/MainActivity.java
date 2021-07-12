package com.example.dagger2example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dagger2example.car.Car;
import com.example.dagger2example.dagger.CarComponent;
import com.example.dagger2example.dagger.DaggerCarComponent;
import com.example.dagger2example.dagger.DieselEngineModule;

import javax.inject.Inject;

//public class MainActivity extends AppCompatActivity {
//
//    private Car car;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        CarComponent carComponent = DaggerCarComponent.create();
//        car = carComponent.getCar();
//        car.drive();
//    }
//}


//field injection
public class MainActivity extends AppCompatActivity {

//    @Inject
//    Car car1, car2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        CarComponent carComponent = DaggerCarComponent.builder()
//                .horsePower(150)
//                .engineCapacity(1000)
//                .build();
//
//        carComponent.inject(this);
//        car1.drive();
//        car2.drive();
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent1 = DaggerCarComponent.builder()
                .horsePower(150)
                .engineCapacity(1000)
                .build();

        CarComponent carComponent2 = DaggerCarComponent.builder()
                .horsePower(150)
                .engineCapacity(1000)
                .build();

        carComponent1.getCar().drive();;
        carComponent2.getCar().drive();
    }
}