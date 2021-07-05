package com.example.srsproject.fingerprint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.biometric.BiometricPrompt;

import com.example.srsproject.R;
import com.example.srsproject.calendar.Reservation;

import java.util.concurrent.Executor;

public class FingerPrintRecognition extends AppCompatActivity {

    private ImageView imageView;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_recognition);

        imageView = findViewById(R.id.finger_print);
        executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(FingerPrintRecognition.this, executor, new BiometricPrompt.AuthenticationCallback(){
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(FingerPrintRecognition.this, "Authentication Error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(FingerPrintRecognition.this, "Authentication Succeeded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(FingerPrintRecognition.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login Using Fingerprint Authentication")
                .setNegativeButtonText("Use App Password")
                .build();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
                startActivity(new Intent(FingerPrintRecognition.this, Reservation.class));
            }
        });
    }
}