package com.lepsoy.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView lepsoysVideoView = (VideoView)findViewById(R.id.lepsoysVideoView);
        lepsoysVideoView.setVideoPath("https://www.thenewboston.com/forum/project_files/006_testVideo.mp4");

        //Player controls(play, pause, stop etc...)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(lepsoysVideoView);
        lepsoysVideoView.setMediaController(mediaController);

        lepsoysVideoView.start();
    }



}
