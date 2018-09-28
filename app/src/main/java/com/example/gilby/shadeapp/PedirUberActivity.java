package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class PedirUberActivity extends AppCompatActivity {

    private LinearLayout Posicionhome,Posiciontrabajo,PosicionIntec;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_uber);
        Posicionhome = (LinearLayout)findViewById(R.id.lugar_1);
        Posiciontrabajo = (LinearLayout)findViewById(R.id.lugar_2);
        PosicionIntec = (LinearLayout)findViewById(R.id.lugar_3);

        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        Posicionhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(PedirUberActivity.this, MapaUberActivity.class);
                 regist.putExtra("seleccion","1");
                startActivityForResult(regist,1);

                finish();
            }

        });
        Posiciontrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(PedirUberActivity.this, MapaUberActivity.class);
                regist.putExtra("seleccion","2");
                startActivityForResult(regist,2);

                finish();
            }

        });
        PosicionIntec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(PedirUberActivity.this, MapaUberActivity.class);
                regist.putExtra("seleccion","3");
                startActivityForResult(regist,3);

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

            Intent regist = new Intent(PedirUberActivity.this, MenuActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();


        }


    }

}
