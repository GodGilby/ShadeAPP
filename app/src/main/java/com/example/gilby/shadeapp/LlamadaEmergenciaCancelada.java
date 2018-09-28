package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LlamadaEmergenciaCancelada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_emergencia_cancelada);

        //Timer para el cambio de Activity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LlamadaEmergenciaCancelada.this,RelojMainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
