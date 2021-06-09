package com.example.explicitintentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Bundle bundle = getIntent().getExtras();
//        String val1 = bundle.getString("value1");
//        String val2 = bundle.getString("value2");

        String val1 = getIntent().getExtras().getString("value1");
        String val2 = getIntent().getExtras().getString("value2");
//        Toast.makeText(getApplicationContext(), "first value: " + val1 + "; second value: " + val2, Toast.LENGTH_LONG).show();
        Toast.makeText(SecondActivity.this, "first value: " + val1 + " ; second value: " + val2, Toast.LENGTH_LONG).show();
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFirstActivity(v);
            }
        });
    }

    public void callFirstActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}