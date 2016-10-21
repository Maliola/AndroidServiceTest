package com.mahui.androidservicetest.service;

import android.app.IntentService;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.util.Log;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/21.
 */
public class MyIntentService extends IntentService{
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        DateFormat format= DateFormat.getTimeInstance();
        Log.e("test", "onHandleIntent开始:" + format.format(new Date()));
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        Log.e("test", "onHandleIntent完成:" + format.format(new Date()));
    }

    @Override
    public void onDestroy() {
        Log.e("intentservice","onDestory");
        super.onDestroy();
    }
}
