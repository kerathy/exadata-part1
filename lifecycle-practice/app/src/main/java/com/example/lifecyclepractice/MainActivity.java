package com.example.lifecyclepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate Method");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart Method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume Method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause Method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop Method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart Method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy Method");
    }
}