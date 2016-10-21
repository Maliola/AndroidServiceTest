package com.mahui.androidservicetest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.mahui.androidservicetest.timetask.DoTimeTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/21.
 */
public class FirstService extends Service{
    private Timer timer;
    private TimerTask timerTask;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(timer!=null&&timerTask!=null){
            timer.cancel();
            timerTask.cancel();
            timer=null;
            timerTask=null;
        }
        timer=new Timer();
        timerTask=new DoTimeTask();
        long period=1000*5;
        Calendar calendar=Calendar.getInstance();
        Date firsttime=calendar.getTime();
        timer.schedule(timerTask,firsttime,period);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer!=null&&timerTask!=null){
            timer.cancel();
            timerTask.cancel();
            timer=null;
            timerTask=null;
        }
    }
}
