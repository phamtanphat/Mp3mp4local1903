package com.ptp.phamtanphat.mp3mp4local1903;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnMp3, btnMp4;
    VideoView videoView;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMp3 = findViewById(R.id.buttonMp3);
        btnMp4 = findViewById(R.id.buttonMp4);
        videoView = findViewById(R.id.videoview);

        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Playmp3Local();
                PlayNhacMp3("http://khoapham.vn/download/vietnamoi.mp3");

            }
        });
        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Playmp4Local();
                PlayMp4online();
            }
        });
    }

    private void PlayMp4online() {
        videoView.setVideoURI(Uri.parse("https://khoapham.vn/download/vuoncaovietnam.mp4"));
        videoView.setMediaController(new MediaController(MainActivity.this));
        videoView.start();
    }

    //    public void BatsukienMp4(View view){
//        Toast.makeText(this, "Button mp4", Toast.LENGTH_SHORT).show();
//    }
    public void Playmp4Local() {
        // duong dan thuc te
//                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.codieugisaokhongnoi));
//                videoView.start();
//
//                MediaController mediaController = new MediaController(MainActivity.this);
//                videoView.setMediaController(mediaController);
    }

    public void Playmp3Local() {
//        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.dungnhumotthoiquen);
//        mediaPlayer.start();

    }
    public void PlayNhacMp3(String url){
        //url = "http://khoapham.vn/download/vietnamoi.mp3";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
