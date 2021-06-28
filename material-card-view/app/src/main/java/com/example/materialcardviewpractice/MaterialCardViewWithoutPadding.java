package com.example.materialcardviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MaterialCardViewWithoutPadding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_card_view_without_padding);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MaterialCardViewWithoutPadding.this, MaterialCardViewWithPadding.class));
            }
        }, 1000);
    }
}