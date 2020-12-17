package com.nova.aodingplayermonitor;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class App extends Application {

    public static final String   TEST_CHANNEL_ID = "Test_CHANNEL_ID";
    @Override
    public void onCreate() {
        super.onCreate() ;
        createNotificationChannel() ;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(
                    TEST_CHANNEL_ID,
                    "数据正在同步中",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager  manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }
}
