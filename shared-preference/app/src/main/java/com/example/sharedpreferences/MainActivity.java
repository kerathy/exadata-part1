package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPreference";
    public static final String TEXT = "text";
    public static final String SWITCH = "switch";
    Button buttonApplyText, buttonSaveData;
    EditText editText;
    Switch aSwitch;
    TextView textView;

    private String text;
    private Boolean switchOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonApplyText = findViewById(R.id.button_apply_text);
        buttonSaveData = findViewById(R.id.button_save_data);
        editText = findViewById(R.id.editTextText);
        aSwitch = findViewById(R.id.switch1);
        textView = findViewById(R.id.textView);

        buttonApplyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });

        buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateViews();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, editText.getText().toString());
        editor.putBoolean(SWITCH, aSwitch.isChecked());

        editor.apply();
        Toast.makeText(this, "save data", Toast.LENGTH_LONG).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOn = sharedPreferences.getBoolean(SWITCH, false);
    }

    public void updateViews() {
        editText.setText(text);
        aSwitch.setChecked(switchOn);
    }
}