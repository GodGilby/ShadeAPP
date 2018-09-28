package com.example.gilby.shadeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Timer;
import java.util.TimerTask;

public class LlamadaEmergencia extends AppCompatActivity {

    private LinearLayout CancelarLlamada;
    private GestureDetectorCompat gestureDetectorCompat = null;
    private Button telefonoverde;
    private MediaPlayer llamando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_emergencia);
        CancelarLlamada = (LinearLayout) findViewById(R.id.CancelarLlamada);
        telefonoverde = (Button) findViewById(R.id.telefonoverde);
        llamando = MediaPlayer.create(LlamadaEmergencia.this, R.raw.telephone_ring);

        SonidoLlamada();

        CountDownTimer timer2 = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                LlamadaAnimacion();

            }

            @Override
            public void onFinish() {


            }
        }.start();

        //Metodo de Animacion
        telefonoverde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Bounce).duration(2000).playOn(telefonoverde);
            }
        });

        //Metodo para cancelar llamada
        CancelarLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamando.stop();
                llamando.release();
                Intent intent = new Intent(LlamadaEmergencia.this, LlamadaEmergenciaCancelada.class);
                startActivity(intent);
                finish();

            }
        });

        // Create a common gesture listener object.
        DetectSwipeLlamada gestureListener = new DetectSwipeLlamada();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

//        Timer para el cambio de Activity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    if(llamando.isPlaying()){
                        llamando.stop();
                        llamando.release();
                    }
                }
                catch (IllegalStateException e){

                }
                Intent intent = new Intent(LlamadaEmergencia.this, LlamadaEmergenciaCancelada.class);
                startActivity(intent);
//                onPause();
                finish();
            }
        }, 10000);


    }

    public void SonidoLlamada() {
        llamando.start();
    }

//    @Override
//    protected void onPause(){
//        llamando = MediaPlayer.create(LlamadaEmergencia.this, R.raw.telephone_ring);
//        super.onPause();
//        llamando.release();
//    }

    public void LlamadaAnimacion() {
        YoYo.with(Techniques.Bounce).duration(1000).repeat(1).playOn(telefonoverde);
    }

    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event list
        // eners.
        return true;
    }

    public void AccionDet(String Accion) {


        if (Accion == "arriba") {

            Intent regist = new Intent(LlamadaEmergencia.this, LlamadaEmergenciaCancelada.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bot);
            finish();

        }


    }
}
