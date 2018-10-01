package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Relajacion4Activity extends AppCompatActivity {

    private ConstraintLayout pantalla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion4);

        pantalla2 = (ConstraintLayout) findViewById(R.id.pantalla_buen_trabajo);
        pantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Relajacion4Activity.this,RelojMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
