package com.mahui.androidservicetest.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.mahui.androidservicetest.MainActivity;
import com.mahui.androidservicetest.R;
import com.mahui.androidservicetest.SecondActivity;

/**
 * Created by Administrator on 2016/10/21.
 */
public class TopService extends Service {
    private static final int NOTIFY_ID=123;
    @Override
    public void onCreate() {
        super.onCreate();
        showNotification();
    }
    public void showNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("今天").setContentText("天气很好");
        Intent resultintent=new Intent(this, SecondActivity.class);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultintent);
        PendingIntent resultRending=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(resultRending);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification=builder.build();
        notificationManager.notify(NOTIFY_ID,notification);
        startForeground(NOTIFY_ID,notification);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}