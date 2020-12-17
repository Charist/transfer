package com.nova.aodingplayermonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, App.TEST_CHANNEL_ID)
                .setContentTitle("测试App")
                .setContentText("测试App正在运行...")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        startForeground(10000, builder.build());
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
