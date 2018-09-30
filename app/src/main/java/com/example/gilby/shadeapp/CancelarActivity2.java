package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CancelarActivity2 extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat = null;
    private Button cancelar;
    private TextView AhorroClickeado;
    private TextView CuentaClickeado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelar2);
        cancelar = (Button)findViewById(R.id.cancelarTarjeta);
        AhorroClickeado = (TextView)findViewById(R.id.AhorroClickeado);
        CuentaClickeado = (TextView)findViewById(R.id.TarjetaCredito);

        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        cancelar.setVisibility(View.GONE);

        AhorroClickeado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CuentaClickeado.setVisibility(View.GONE);
                cancelar.setVisibility(View.GONE);
                cancelar.setVisibility(View.VISIBLE);
            }
        });

        CuentaClickeado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AhorroClickeado.setVisibility(View.GONE);
                cancelar.setVisibility(View.GONE);
                cancelar.setVisibility(View.VISIBLE);
            }
        });



        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CancelarActivity2.this,CancelarActivity3.class);
                startActivity(intent);
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

    public void AccionDet(String Accion) {

        if (Accion == "derecha"){

            Intent regist = new Intent(CancelarActivity2.this, CancelarActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }

    }

}
