package com.mahui.androidservicetest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.mahui.androidservicetest.timetask.DoTimeTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/21.
 */
public class SecondSrevice extends Service{
    private Timer timer;
    private TimerTask timerTask;
    private MyBinder myBinder=new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    public class MyBinder extends Binder{
        public void startrun(){
            if (timer!=null&&timerTask!=null) {
                timer.cancel();
                timerTask.cancel();
                timer=null;
                timerTask=null;
            }
            timer=new Timer();
            timerTask=new DoTimeTask();
            Calendar calendar=Calendar.getInstance();
            Date firsttime=calendar.getTime();
            long period=1000*5;
            timer.schedule(timerTask,firsttime,period);
        }
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