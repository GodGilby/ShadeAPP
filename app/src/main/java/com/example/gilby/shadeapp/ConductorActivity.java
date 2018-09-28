package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConductorActivity extends AppCompatActivity {

    private TextView Bcancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);

        Bcancelar = (TextView)findViewById(R.id.boton_cancelar_uber);

        Bcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(ConductorActivity.this, MenuActivity.class);
                startActivity(regist);
                finish();
            }

        });
    }
}
