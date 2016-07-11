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
    public static MediaPlayer mMediaPlayer;
    SongService songService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        songService = new SongService();

        stopButton = (Button)findViewById(R.id.stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopServiceIntent = new Intent(MainActivity.this, songService.getClass());
                stopService(stopServiceIntent);
                Log.d("SONG", "onClick: pause");

            }
        });


        Button playButton = (Button)findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startServiceIntent = new Intent(MainActivity.this, songService.getClass());
                startService(startServiceIntent);
                Log.d("SongService", "onClick: ");
            }
        });

        Button pauseButton = (Button)findViewById(R.id.pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();


            }
        });

    }
    public void pause(){
        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
        } else{
            mMediaPlayer.start();

        }
    }
}
