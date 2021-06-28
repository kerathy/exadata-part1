package com.example.cardswipeviewjavaversion;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PetAdapter petAdapter;
    private ArrayList<PetsModel> models;
    private ViewPager viewPager;
    private LinearLayout sliderDotspanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        sliderDotspanel = findViewById(R.id.slider_dots);

        models = new ArrayList<>();
        String[] titles = {"Dobby", "Kitto", "Cozmo", "Tiger", "Husky", "Cat"};
        String[] descs = {"Dog", "Cat", "Lambardor", "German Shepherd", "Husky", "Unknown"};

        for (int i = 0; i < titles.length; i++) {
            models.add(new PetsModel(R.drawable.dummy_image, titles[i], descs[i]));
        }

        petAdapter = new PetAdapter(models, MainActivity.this);
        viewPager.setAdapter(petAdapter);

    }
}
