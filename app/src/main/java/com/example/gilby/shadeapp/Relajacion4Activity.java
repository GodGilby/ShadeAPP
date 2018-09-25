package com.example.gilby.shadeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion4Activity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion4);


        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Relajacion4Activity.this,Relajacion5Activity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

    public void didTapButton(View view) {
        Button button = (Button) findViewById(R.id.buttonRelax);
        @SuppressLint("ResourceType") final Animation myAnim = AnimationUtils.loadAnimation(this, R.transition.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
