package com.example.passdatafromonfragmenttoanotherfragment;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements OnButtonPressListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonPressed(String msg) {
        SecondFragment Obj = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.frag_2);
        Obj.onFragmentInteraction(msg);
    }
}