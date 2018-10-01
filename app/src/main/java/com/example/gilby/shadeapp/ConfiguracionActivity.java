package com.example.gilby.shadeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ConfiguracionActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat = null;
    private Button buttonMasVibraciones, buttonMenosVibraciones,buttonMenosSonido,buttonMasSonido,buttonMenosBrillo,buttonMasBrillo;
    private int estadoV,estadoS,estadoB;
    private View Vibracion1,Vibracion2,Vibracion3,SonidoView1,SonidoView2,SonidoView3,BrilloView3,BrilloView2   ,BrilloView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        estadoV = 2;
        estadoB = 2;
        estadoS = 2;

        buttonMasVibraciones = (Button)findViewById(R.id.buttonMasVibraciones);
        buttonMenosVibraciones = (Button)findViewById(R.id.buttonMenosVibraciones);
        Vibracion1 = (View)findViewById(R.id.VibracionView1);
        Vibracion2 = (View)findViewById(R.id.VibracionView2);
        Vibracion3 = (View)findViewById(R.id.VibracionView3);
        buttonMenosSonido = (Button)findViewById(R.id.buttonMenosSonido);
        buttonMasSonido = (Button)findViewById(R.id.buttonMasSonido);
        SonidoView1 = (View)findViewById(R.id.SonidoView1);
        SonidoView2 = (View)findViewById(R.id.SonidoView2);
        SonidoView3 = (View)findViewById(R.id.SonidoView3);
        BrilloView1 = (View)findViewById(R.id.BrilloView1);
        BrilloView2 = (View)findViewById(R.id.BrilloView2);
        BrilloView3 = (View)findViewById(R.id.BrilloView3);
        buttonMenosBrillo = (Button)findViewById(R.id.buttonMenosBrillo);
        buttonMasBrillo = (Button)findViewById(R.id.buttonMasBrillo);
        Vibracion1.setBackgroundColor(Color.BLUE);
        Vibracion2.setBackgroundColor(Color.BLUE);
        Vibracion3.setBackgroundColor(Color.GRAY);
        SonidoView1.setBackgroundColor(Color.BLUE);
        SonidoView2.setBackgroundColor(Color.BLUE);
        SonidoView3.setBackgroundColor(Color.GRAY);
        BrilloView1.setBackgroundColor(Color.BLUE);
        BrilloView2.setBackgroundColor(Color.BLUE);
        BrilloView3.setBackgroundColor(Color.GRAY);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        buttonMasVibraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estadoV == 2){
                    estadoV = 3;
                    Vibracion3.setBackgroundColor(Color.BLUE);
                }
                else if(estadoV == 1){
                    estadoV = 2;
                    Vibracion2.setBackgroundColor(Color.BLUE);
                }
                else if(estadoV == 0){
                    estadoV = 1;
                    Vibracion1.setBackgroundColor(Color.BLUE);
                }
            }
        });

        buttonMenosVibraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoV == 2) {
                    estadoV = 1;
                    Vibracion2.setBackgroundColor(Color.GRAY);
                } else if (estadoV == 1) {
                    estadoV = 0;
                    Vibracion1.setBackgroundColor(Color.GRAY);
                } else if (estadoV == 3) {
                    estadoV = 2;
                    Vibracion3.setBackgroundColor(Color.GRAY);
                }
            }
        });

        buttonMasSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estadoS == 2){
                    estadoS = 3;
                    SonidoView3.setBackgroundColor(Color.BLUE);
                }
                else if(estadoS == 1){
                    estadoS = 2;
                    SonidoView2.setBackgroundColor(Color.BLUE);
                }
                else if(estadoS == 0){
                    estadoS = 1;
                    SonidoView1.setBackgroundColor(Color.BLUE);
                }
            }
        });


        buttonMenosSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoS == 2) {
                    estadoS = 1;
                    SonidoView2.setBackgroundColor(Color.GRAY);
                } else if (estadoS == 1) {
                    estadoS = 0;
                    SonidoView1.setBackgroundColor(Color.GRAY);
                } else if (estadoS == 3) {
                    estadoS = 2;
                    SonidoView3.setBackgroundColor(Color.GRAY);
                }
            }
        });

        buttonMasBrillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estadoB == 2){
                    estadoB = 3;
                    BrilloView3.setBackgroundColor(Color.BLUE);
                }
                else if(estadoB == 1){
                    estadoB = 2;
                    BrilloView2.setBackgroundColor(Color.BLUE);
                }
                else if(estadoB == 0){
                    estadoB = 1;
                    BrilloView1.setBackgroundColor(Color.BLUE);
                }
            }
        });


        buttonMenosBrillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoB == 2) {
                    estadoB = 1;
                    BrilloView2.setBackgroundColor(Color.GRAY);
                } else if (estadoB == 1) {
                    estadoB = 0;
                    BrilloView1.setBackgroundColor(Color.GRAY);
                } else if (estadoB == 3) {
                    estadoB = 2;
                    BrilloView3.setBackgroundColor(Color.GRAY);
                }
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

            Intent regist = new Intent(ConfiguracionActivity.this, MenuActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }

    }

}
