package com.example.gilby.shadeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class DetectSwipeDirectionActivity extends AppCompatActivity {

    // This textview is used to display swipe or tap status info.
    private TextView textView = null;
    private ImageView logo = null;

    // This is the gesture detector compat instance.
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reloj);

        setTitle("dev2qa.com - Detect Android Swipe Direction Example.");

        // Get the text view.
        textView = (TextView)findViewById(R.id.detect_swipe_direction_textview);
        logo = (ImageView)findViewById(R.id.logo1);
        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event listeners.
        return true;
    }

    public void displayMessage(String message)
    {

        if(textView!=null)
        {
            // Display text in the text view.
            textView.setText(message);
        }

        if (message == "arriba"){

            Intent regist = new Intent(DetectSwipeDirectionActivity.this, ConfiguracionActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bot);
            finish();

        }

        if (message == "abajo"){

            Intent regist = new Intent(DetectSwipeDirectionActivity.this, ConfiguracionActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
            finish();

        }


    }
}