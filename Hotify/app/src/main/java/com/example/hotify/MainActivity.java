package com.example.hotify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button stopButton;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopButton = (Button)findViewById(R.id.stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopServiceIntent = new Intent(MainActivity.this, SongService.class);
                stopService(stopServiceIntent);
                Log.d("SONG", "onClick: stop pressed");
            }
        });
        int resID=getResources().getIdentifier("ftwt7am", "raw", getPackageName());
        mMediaPlayer = MediaPlayer.create(this,resID);

        Button playButton = (Button)findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
            }
        });


    }
}
