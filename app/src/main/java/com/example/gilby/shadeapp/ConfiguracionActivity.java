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
    private boolean iscolor = true;
    private boolean iscolorno = false;
    private View Vibracion1,Vibracion2,Vibracion3,SonidoView1,BrilloView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        buttonMasVibraciones = (Button)findViewById(R.id.buttonMasVibraciones);
        buttonMenosVibraciones = (Button)findViewById(R.id.buttonMenosVibraciones);
        Vibracion1 = (View)findViewById(R.id.VibracionView1);
        Vibracion2 = (View)findViewById(R.id.VibracionView2);
        Vibracion3 = (View)findViewById(R.id.VibracionView3);
        buttonMenosSonido = (Button)findViewById(R.id.buttonMenosSonido);
        buttonMasSonido = (Button)findViewById(R.id.buttonMasSonido);
        SonidoView1 = (View)findViewById(R.id.SonidoView1);
        BrilloView1 = (View)findViewById(R.id.BrilloView1);
        buttonMenosBrillo = (Button)findViewById(R.id.buttonMenosBrillo);
        buttonMasBrillo = (Button)findViewById(R.id.buttonMasBrillo);

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
                if(iscolor){
                    Vibracion1.setBackgroundColor(Color.BLUE);
                    iscolor = false;
                }
            }
        });

        buttonMenosVibraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!iscolor){
                    Vibracion1.setBackgroundColor(Color.GRAY);
                    iscolor = true;
                }
            }
        });

        buttonMasSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iscolor){
                    SonidoView1.setBackgroundColor(Color.BLUE);
                    iscolor = false;
                }
            }
        });


        buttonMenosSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!iscolor){
                    SonidoView1.setBackgroundColor(Color.GRAY);
                    iscolor = true;
                }
            }
        });

        buttonMasBrillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iscolor){
                    BrilloView1.setBackgroundColor(Color.BLUE);
                    iscolor = false;
                }
            }
        });


        buttonMenosBrillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!iscolor){
                    BrilloView1.setBackgroundColor(Color.GRAY);
                    iscolor = true;
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
