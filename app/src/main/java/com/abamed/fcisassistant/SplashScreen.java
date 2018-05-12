package com.abamed.fcisassistant;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import com.google.firebase.database.FirebaseDatabase;

import FcisAssistant.Adminstration;

public class SplashScreen extends AppCompatActivity {
    VideoView splashvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        setContentView(R.layout.activity_splash_screen);
                splashvideo=(VideoView)findViewById(R.id.splashvideo);
        splashvideo.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash));
        splashvideo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this,SignUp.class));
                SplashScreen.this.finish();
            }
        },8000);
    }

}
