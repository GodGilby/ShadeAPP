package com.example.gilby.shadeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion2Activity extends AppCompatActivity {

    CountDownTimer timer;
    private GestureDetectorCompat gestureDetectorCompat = null;
    private int estado = 0;
    private int lock = 0;
    private TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion2);
        button = (TextView) findViewById(R.id.buttonRelajando);
        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);


    }







    public void didTapButton() {
        @SuppressLint("ResourceType") final Animation myAnim = AnimationUtils.loadAnimation(this, R.transition.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }



    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event list
        // eners.
        return true;
    }

    public void AccionDet(String Accion) {


        if (Accion == "Doble") {

            if(timer != null) {
                timer.cancel();
                timer = null;
            }
            Intent intent = new Intent(Relajacion2Activity.this, Relajacion5Activity.class);
            startActivity(intent);
            finish();


        }
        else if (Accion == "abajo") {

            if (lock == 0) {
                lock = 1;

                timer = new CountDownTimer(58000, 4000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        didTapButton();
                        if (estado == 0) {
                            estado = 1;
                            button.setText("Inhala");

                        } else if (estado == 1) {
                            estado = 0;
                            button.setText("Exhala");
                        }
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(Relajacion2Activity.this, Relajacion5Activity.class);
                        startActivity(intent);
                        finish();

                    }
                }.start();
            }
        }


    }

}
