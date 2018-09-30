package com.example.gilby.shadeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LlamadaCanceladaUberActivity extends AppCompatActivity {

    private MediaPlayer llamando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_emergencia_cancelada);
        llamando = MediaPlayer.create(LlamadaCanceladaUberActivity.this,R.raw.telephone_ring);

        //Timer para el cambio de Activity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LlamadaCanceladaUberActivity.this,ConductorActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }


}
