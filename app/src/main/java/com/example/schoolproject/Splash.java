package com.example.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity {

    long delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        requestWindowFeature( Window.FEATURE_NO_TITLE);

        setContentView( R.layout.activity_splash );

        Timer RunSplash = new Timer();

        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {

                finish();

                Intent i = new Intent(Splash.this, LoginRegistration.class);
                startActivity(i);

            }
        };

        RunSplash.schedule(ShowSplash, delay);

    }
}