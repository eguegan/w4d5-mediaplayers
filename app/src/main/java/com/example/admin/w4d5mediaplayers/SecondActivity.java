package com.example.admin.w4d5mediaplayers;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    private static final String VIDEO_URL = "http://techslides.com/demos/sample-videos/small.mp4";

    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSurfaceView = (SurfaceView) findViewById(R.id.a_main_surface);
        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDisplay(holder);
                    mMediaPlayer.setDataSource(VIDEO_URL);
                    mMediaPlayer.prepare();
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            Log.d(TAG, "onPrepared: ");
                            mMediaPlayer.start();
                        }
                    });
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                } catch (IOException e) {
                    Log.e(TAG, "surfaceCreated: ", e);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    public void startThird(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
