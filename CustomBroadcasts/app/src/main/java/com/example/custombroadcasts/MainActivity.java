package com.example.custombroadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    static final String TAG = "MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate Method is invoked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View view) {
        Log.i(TAG, "sendBroadcast method is invoked");
        Intent intent = new Intent("ACTION");
        intent.putExtra("TEXT", "Broadcast received");
        sendBroadcast(intent);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "onReceive method is invoked");
            String text = intent.getStringExtra("TEXT");
//            System.out.println("text......" + text);
            textView.setText(text);
        }
    };


    @Override
    protected void onStart() {
        Log.i(TAG, "onStart Method is invoked");
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("ACTION");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Stop Service is invoked");
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }


}