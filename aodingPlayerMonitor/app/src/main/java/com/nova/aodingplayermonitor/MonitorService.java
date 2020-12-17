package com.nova.aodingplayermonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.TimerTask;

public class MonitorService extends Service {
    public String TAG = "AoDingMonitorService";

    public MonitorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind !!");
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate !!");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart !!");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy !!");
    }

}
