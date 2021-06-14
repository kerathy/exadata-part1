package com.example.geofenceintentservicepractice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

public class GeofenceIntentService extends IntentService {

    private static final String TAG = "MESSAGE";

    public GeofenceIntentService() {
        super("GeofenceIntentService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent");
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            int errorCode = geofencingEvent.getErrorCode();
            Log.i(TAG, errorCode + "");
            return;
        }

        int geofenceTransition = geofencingEvent.getGeofenceTransition();
        String type = "";
        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT ) {
            type = MainActivity.EXIT_GEOFENCE_STRING;
        } else if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER) {
            type = MainActivity.ENTER_GEOFENCE_STRING;
        } else if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_DWELL) {
            type = MainActivity.DWELL_GEOFENCE_STRING;
        } else {
            type = "Nothing";
        }
        intent.setAction("transition_broadcast");
        intent.putExtra("action", type);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
