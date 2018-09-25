package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView botonllamada,botonuber,botonconfiguracion,botoncancelar;
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        botonllamada = (ImageView) findViewById(R.id.boton_llamada);
        botonuber = (ImageView)findViewById(R.id.boton_uber);
        botonconfiguracion = (ImageView)findViewById(R.id.boton_opciones);
        botoncancelar = (ImageView)findViewById(R.id.boton_cancelar);

        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);


        botonconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AnimacionR = new Intent(MenuActivity.this, ConfiguracionActivity.class);
                startActivity(AnimacionR);
                finish();
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


    public void AccionDet(String Accion)
    {

        if (Accion == "abajo"){

            Intent regist = new Intent(MenuActivity.this, RelojMainActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
            finish();


        }


    }


}
