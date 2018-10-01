package com.example.gilby.shadeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LlamadaCancelada2Activity extends AppCompatActivity {

    private MediaPlayer llamando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_cancelada2);
        llamando = MediaPlayer.create(LlamadaCancelada2Activity.this,R.raw.telephone_ring);

        //Timer para el cambio de Activity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LlamadaCancelada2Activity.this,LlamadaActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }


}
