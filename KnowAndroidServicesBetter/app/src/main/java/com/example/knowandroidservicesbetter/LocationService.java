package com.example.knowandroidservicesbetter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LocationService extends Service {
    private static final String TAG = "MESSAGE";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null; //Used for bind service
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Called when you startService() is invoked
        System.out.println("onStartCommand method");
        Toast.makeText(this, "startService() is invoked", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
    /*
    To use foreground service, just call foregroundService() and passing it a notification id and notification. To stop foreground service call stopForeground(true)
    */
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        System.out.println("On Destroy method");
        Toast.makeText(this, "stopService() is invoked", Toast.LENGTH_LONG).show();
        super.onDestroy();
        //Called when stopService() or stopSelf() is invoked
    }
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.i(TAG, "onTaskRemoved: ");
        Toast.makeText(this, "on Task Removed is invoked", Toast.LENGTH_LONG).show();
        super.onTaskRemoved(rootIntent);
        //Called when you remove your app from recents screen while your service is active
    }
}
