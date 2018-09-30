package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CancelarActivity3 extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat = null;
    private Button Acepto, NoAcepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelar3);
        Acepto = (Button)findViewById(R.id.Acepto);
        NoAcepto = (Button)findViewById(R.id.NoAcepto);



        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        Acepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CancelarActivity3.this,CancelarActivity4.class);
                startActivity(intent);
                finish();
            }
        });

        NoAcepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CancelarActivity3.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event list
        // eners.
        return true;
    }


    public void AccionDet(String Accion) {

        if (Accion == "derecha"){

            Intent regist = new Intent(CancelarActivity3.this, CancelarActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }

    }

}
