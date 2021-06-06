package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        
        getFragmentManager().beginTransaction().add(R.id.framelayout1, fragmentA).commitAllowingStateLoss();
        getFragmentManager().beginTransaction().add(R.id.framelayout2, fragmentB).commitAllowingStateLoss();
    }
}