package com.nova.aodingplayermonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class UpdateReceiver extends BroadcastReceiver {
    public static final String CLASS_NAME = "UpdateReceiver";
    static final String action_boot="android.intent.action.BOOT_COMPLETED";
    public static final String PACKAGE_NAME = "org.qtproject.aodingplayer";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(CLASS_NAME, "action = " + intent.getAction());

        if (intent.getAction().equals(action_boot)){
//            context.getPackageName()
            Intent bootServiceIntent=new Intent(context, MonitorService.class); //接收到广播后，跳转到MainActivity

            Log.d(CLASS_NAME, "onReceive BOOT_COMPLETED!! " +  context.getPackageName());
            context.startService(bootServiceIntent);//startForegroundService
            //context.startForegroundService(bootServiceIntent);//startForegroundService

        }


        if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
//            Toast.makeText(context, "升级了一个安装包,重新启动程序", Toast.LENGTH_SHORT).show();
            Log.i(CLASS_NAME, "action PACKAGE_REPLACED");

            PackageManager localObject = context.getPackageManager();
            if (checkPackInfo(context, PACKAGE_NAME)) {
                    String localPkgName = context.getPackageName();
                    Log.i(CLASS_NAME, "find package, ready to lanunch! "+localPkgName);
                    context.startActivity((localObject).getLaunchIntentForPackage(PACKAGE_NAME));
            } else {
                Log.i(CLASS_NAME, "not find package!");
//                Toast.makeText(context, "没有安装 com.arramr.xfapp", Toast.LENGTH_LONG).show();
            }
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            Log.i(CLASS_NAME, "action PACKAGE_ADDED");
//            Toast.makeText(context, "安装了 com.arramr.xfapp 包名的程序", Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            Log.i(CLASS_NAME, "action PACKAGE_REMOVED");
//            Toast.makeText(context, "卸载了 com.arramr.xfapp 包名的程序", Toast.LENGTH_LONG).show();
        }
    }


    private Boolean checkPackInfo(Context paramContext, String paramString ) {
        PackageInfo info = null;
        try {
            info = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (info != null) {
            return true;
        }
        return false;
    }


}
