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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion3Activity extends AppCompatActivity {

    CountDownTimer timer,timer2;
    private GestureDetectorCompat gestureDetectorCompat = null;
    private int estado = 0;
    private int lock = 0;
    private TextView boton;
    private ImageView mas, menos,play,pause,decoracion;
    private int pausa = 0;
    private int minutos,segundos;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion3);
        boton = (TextView) findViewById(R.id.boton_relajacion);
        mas = (ImageView)findViewById(R.id.button_mas);
        menos = (ImageView)findViewById(R.id.button_menos);
        decoracion = (ImageView)findViewById(R.id.decoracion_circular);
        play = (ImageView)findViewById(R.id.button_play);
        pause = (ImageView)findViewById(R.id.button_pause);
        segundos = 60;
        minutos = 0;
        texto = "Respira \n";
        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);


        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lock == 0){

                    if (segundos < 300 ) {
                        segundos = segundos + 10;
                        Convertir();

                    }

                }
            }
        });

        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lock == 0){

                    if (segundos > 60 ) {
                        segundos = segundos - 10;
                        Convertir();

                    }

                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pausa == 0){
                    pausa = 1;
                    pause.setVisibility(View.GONE);
                    play.setVisibility(View.VISIBLE);
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timer2 !=null){
                        timer2.cancel();
                        timer2 = null;
                    }
                    boton.clearAnimation();
                    if(estado == 0){
                        estado = 1;
                    }
                    else if(estado == 1){
                        estado = 0;
                    }
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pausa == 1){
                    pausa = 0;
                    play.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);
                    Contador();
                }
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (lock == 0) {
                        mas.setVisibility(View.GONE);
                        decoracion.setVisibility(View.VISIBLE);
                        menos.setVisibility(View.GONE);
                        pause.setVisibility(View.VISIBLE);

                        lock = 1;

                        Contador();
                    }
                }
        });



    }


    public void Convertir(){
            minutos = segundos / 60;
            if(segundos%60 < 10) {
                boton.setText(texto + minutos + ":0"+ (segundos % 60));
            }
        else {
            boton.setText(texto + minutos + ":" + (segundos % 60));
        }
    }




    public void didTapButton() {
        @SuppressLint("ResourceType") final Animation myAnim = AnimationUtils.loadAnimation(this, R.transition.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        boton.startAnimation(myAnim);
    }

    public void Contador(){

        timer = new CountDownTimer(segundos * 1000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                didTapButton();
                if (estado == 0) {
                    estado = 1;
                    texto = "Inhala \n";

                } else if (estado == 1) {
                    estado = 0;
                    texto = "Exhala \n";
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Relajacion3Activity.this, Relajacion4Activity.class);
                startActivity(intent);
                finish();

            }
        }.start();


        timer2 = new CountDownTimer(segundos * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                segundos = segundos - 1 ;
                Convertir();

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }


    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event list
        // eners.
        return true;
    }

    public void AccionDet(String Accion) {


        if (Accion == "derecha") {
            if(pausa == 1) {

                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                if (timer2 !=null){
                    timer2.cancel();
                    timer2 = null;
                }
                Intent intent = new Intent(Relajacion3Activity.this, Relajacion4Activity.class);
                startActivity(intent);
                finish();
            }


        }

    }

}
