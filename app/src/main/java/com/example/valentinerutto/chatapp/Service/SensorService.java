package com.example.valentinerutto.chatapp.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class SensorService extends Service {
    public int counter=0;
   public SensorService(Context applicationContext){
       super();
       Log.i("HERE","here i am");

   }

public SensorService(){}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
         startTimer();
         return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("EXIT","ondestroy");
        Intent broadcastIntent = new Intent("ac.in.ActivityRecognition.RestartSensor");
        sendBroadcast(broadcastIntent);
        stoptimertask();
    }
    private Timer timer;
    private TimerTask timerTask;
    long oldTime=0;


    private void startTimer() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask,1000,1000);
    }

    private void initializeTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.i("in timer","in timer ++++ "+ (counter++));
            }
        };
    }

    private void stoptimertask() {
        if (timer != null){
            timer.cancel();
            timer=null;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
