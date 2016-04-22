package com.example.admin.w4d5mediaplayers;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {
    private static final String URL = "http://www.noiseaddicts.com/samples_1w72b820/47.mp3";
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mp =  new MediaPlayer();
        try {
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setDataSource(URL);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            // TODO: handle exception
            Log.d("TAG", "onCreate: " + e.toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }
}
