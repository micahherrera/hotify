package com.example.hotify;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by aaronfields on 7/11/16.
 */
public class SongService extends Service {

    Thread mThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("SongService", "Creating Service!");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SongService", "Starting Service!");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                int resID=getResources().getIdentifier("ftwt7am", "raw", getPackageName());
                MainActivity.mMediaPlayer = MediaPlayer.create(getBaseContext(),resID);
                MainActivity.mMediaPlayer.start();

                //stop and calls ondestroy
                //stopSelf();
            }
        };

        mThread = new Thread(r);
        mThread.start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SongService", "Destroyed and paused!");
        mThread.interrupt();
        MainActivity.mMediaPlayer.stop();
        stopSelf();

    }



    public SongService() {
        super();
    }
}
