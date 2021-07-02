package com.example.temp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.relative_layout);
        relativeLayout.setBackgroundResource(R.drawable.room_image2);
//        relativeLayout.setBackground(Drawable.createFromPath(String.valueOf(R.drawable.room_image2)));
//        relativeLayout.setBackground(Drawable.createFromPath("res"));
    }
}