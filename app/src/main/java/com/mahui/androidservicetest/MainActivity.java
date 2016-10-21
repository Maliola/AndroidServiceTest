package com.mahui.androidservicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mahui.androidservicetest.service.FirstService;
import com.mahui.androidservicetest.service.MyIntentService;
import com.mahui.androidservicetest.service.SecondSrevice;
import com.mahui.androidservicetest.service.TopService;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    SecondSrevice.MyBinder myBinder;
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (SecondSrevice.MyBinder) service;
            myBinder.startrun();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void oneopenservice(View view){
        intent=new Intent(this, FirstService.class);
        startService(intent);
    }
    public void onecloseservice(View view){
        intent=new Intent(this, FirstService.class);
        stopService(intent);
    }
    public void oneopenservicetop(View view){
        intent=new Intent(this, TopService.class);
        startService(intent);
    }
    public void onecloseservicetop(View view){
        intent=new Intent(this, TopService.class);
        stopService(intent);
    }
    public void twoopenservice(View view){
        intent=new Intent(this, SecondSrevice.class);
        bindService(intent,conn,BIND_AUTO_CREATE);
    }
    public void twocloseservice(View view){
        unbindService(conn);
    }
    public void openintentservice(View view){
        startService(new Intent(this, MyIntentService.class));
    }
}
