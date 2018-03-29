package com.kanoon.topapps.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Space;

import com.bumptech.glide.Glide;
import com.kanoon.topapps.R;
import com.kanoon.topapps.configs.Prefs;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    ImageView kanoonLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        kanoonLogo = (ImageView) findViewById(R.id.kanoon_splash_logo);
        Glide.with(getApplicationContext())
                .load(R.drawable.logo)
                .animate(R.anim.zoom_in)
                .into(kanoonLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent;
                if (!Prefs.getAppPrefs(getApplicationContext()).getBoolean("isLoggedin", false)) {
                    mainIntent = new Intent(Splash.this, LoginActivity.class);
                }
                else
                    mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


}
