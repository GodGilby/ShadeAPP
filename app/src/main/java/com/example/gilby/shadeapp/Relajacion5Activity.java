package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion5Activity extends AppCompatActivity {

    Timer timer;
    private LinearLayout pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion5);

        pantalla = (LinearLayout)findViewById(R.id.pantalla_estarasbien);
        pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Relajacion5Activity.this,RelojMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Relajacion5Activity.this,RelojMainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },5000);
    }
}
