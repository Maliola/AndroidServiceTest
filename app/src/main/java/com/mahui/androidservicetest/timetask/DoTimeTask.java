package com.mahui.androidservicetest.timetask;

import android.util.Log;

import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/21.
 */
public class DoTimeTask extends TimerTask{
    int i=0;
    @Override
    public void run() {
        i++;
        Log.e("dosomthing","----------------"+i);
    }
}
