package com.example.gilby.shadeapp;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LlamadaActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat = null;
    private LinearLayout emergencia, contacto1,contacto2,contacto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);
        emergencia = (LinearLayout) findViewById(R.id.ViewEmergencia);
        contacto1 = (LinearLayout)findViewById(R.id.Contacto1);
        contacto2 = (LinearLayout)findViewById(R.id.Contacto2);
        contacto3 = (LinearLayout)findViewById(R.id.Contacto3);

        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        emergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LlamadaActivity.this,LlamadaEmergencia.class);
                startActivity(intent);
                finish();
            }
        });

        contacto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LlamadaActivity.this,Llamada2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        contacto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LlamadaActivity.this,LlamadaEmergencia.class);
                startActivity(intent);
                finish();
            }
        });

        contacto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LlamadaActivity.this,LlamadaEmergencia.class);
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


    public void AccionDet(String Accion)
    {

        if (Accion == "derecha"){

            Intent regist = new Intent(LlamadaActivity.this,MenuActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();


        }


    }


}
