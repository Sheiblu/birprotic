package com.smteck.androbd.birprotic.controler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.smteck.androbd.birprotic.R;

public class LogoActivity extends AppCompatActivity {

    private TextView tvMuktijurda;
    private ImageView iv;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_logo);

        sound = MediaPlayer.create(this, R.raw.bd);
        SharedPreferences getPrefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkbox", true);

        if (music == true)
            sound.start();

        tvMuktijurda = (TextView)findViewById(R.id.text);
        iv =(ImageView)findViewById(R.id.imageView2);

        Animation animation= AnimationUtils.loadAnimation(this, R.anim.opening_animation);
        tvMuktijurda.setAnimation(animation);
        iv.setAnimation(animation);



        Thread timer=new Thread() {

            Intent myIntent = new Intent(LogoActivity.this,MainActivity.class);
            public void run() {


                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(myIntent);
                    finish();
                }


            }};

        timer.start();
    }
}
