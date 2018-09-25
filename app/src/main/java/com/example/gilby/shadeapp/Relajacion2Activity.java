package com.example.gilby.shadeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion2Activity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Timer para el cambio de Activity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Relajacion2Activity.this,Relajacion3Activity.class);
                startActivity(intent);
                finish();
            }
        },5000);


        CountDownTimer timer2 = new CountDownTimer(30000, 4000) {
            @Override
            public void onTick(long millisUntilFinished) {
                didTapButton();
            }

            @Override
            public void onFinish() {

            }
        }.start();



    }







    public void didTapButton() {
        Button button = (Button) findViewById(R.id.buttonRelax);
        @SuppressLint("ResourceType") final Animation myAnim = AnimationUtils.loadAnimation(this, R.transition.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }


}
