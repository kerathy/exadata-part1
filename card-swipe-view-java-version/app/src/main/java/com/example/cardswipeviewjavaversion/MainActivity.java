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

        models.add(new PetsModel(R.drawable.dummy_image, "Dobby", "Dog"));
        models.add(new PetsModel(R.drawable.dummy_image, "Kitto", "Cat"));
        models.add(new PetsModel(R.drawable.dummy_image, "Cozmo", "Lambardor"));
        models.add(new PetsModel(R.drawable.dummy_image, "Tiger", "German Shepherd"));
        models.add(new PetsModel(R.drawable.dummy_image, "Husky", "Husky"));
        models.add(new PetsModel(R.drawable.dummy_image, "Cat", "Unknown"));

        petAdapter = new PetAdapter(models, MainActivity.this);
        viewPager.setAdapter(petAdapter);

    }
}
