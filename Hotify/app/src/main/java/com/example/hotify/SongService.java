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
    MediaPlayer mMediaPlayer;
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
        int resID=getResources().getIdentifier("ftwt7am", "raw", getPackageName());
        mMediaPlayer = MediaPlayer.create(this,resID);
        mMediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SongService", "Destroyed!");
    }
}
