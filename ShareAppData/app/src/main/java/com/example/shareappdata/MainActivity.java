package com.example.shareappdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
                String appUrl = "https://play.google.com/store/apps/details?id=my.example.javatpoint";
                intent.putExtra(Intent.EXTRA_TEXT, appUrl);
                startActivity(Intent.createChooser(intent, "Share via  "));
            }
        });
    }
}