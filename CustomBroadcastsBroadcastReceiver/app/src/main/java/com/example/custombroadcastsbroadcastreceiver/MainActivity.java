

package com.example.custombroadcastsbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    static final String TAG = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate method is invoked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("ACTION");
        intent.putExtra("TEXT", "Broadcast received");
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "on Start method is invoked");
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("ACTION");
        registerReceiver(exampleBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "on Stop method is invoked");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "on Destroy method is invoked");
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}


class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MESSAGE", "onReceive method is invoked");
        if ("ACTION".equals(intent.getAction())) {
            String text = intent.getStringExtra("TEXT");
            System.out.println("text: Receive the content of TEXT" + text);
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    }
}


