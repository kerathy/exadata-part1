package com.example.geofenceintentservicepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String EXIT_GEOFENCE_STRING = "EXIT";
    static final String ENTER_GEOFENCE_STRING = "ENTER";
    static final String DWELL_GEOFENCE_STRING = "DWELL";

    static Button button;
    static TextView textView;
    MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GeofenceIntentService.class);
                startService(intent);
            }
        });


    }





    private void setReceiver() {
        myBroadCastReceiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("transition_broadcast");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadCastReceiver, intentFilter);
    }

    @Override
    protected void onStart() {
        setReceiver();
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(myBroadCastReceiver);
        super.onStop();
    }

    private class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("action");
            textView.setText("geofenceintentservice type: " + message);
        }
    }

    //    @Override
//    protected void onDestroy() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadCastReceiver);
//        super.onDestroy();
//    }


    //    private class MyBroadCastReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getAction().equals("transition_broadcast")) {
//                String type = intent.getStringExtra("action");
//                textView.setText(type);
//            } else {
//                Toast.makeText(context, "Action Not Found", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}
