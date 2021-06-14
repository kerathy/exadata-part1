package com.example.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    public static boolean isPlay;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        Log.i("Service", "onCrete method is created");
        mediaPlayer = MediaPlayer.create(this, R.raw.piano);
        mediaPlayer.setLooping(false);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Log.i("Service", "onStartCommand method is invoked");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service has been stopeed", Toast.LENGTH_LONG).show();
        Log.i("Service", "on Destroy method is invoked");
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}
