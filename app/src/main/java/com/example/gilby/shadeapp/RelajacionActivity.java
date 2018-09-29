package com.example.gilby.shadeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RelajacionActivity extends AppCompatActivity {

    private Button botonAbajo,botonArriba;
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relajacion);

        botonAbajo = (Button)findViewById(R.id.buttonSuccess1);
        botonArriba = (Button)findViewById(R.id.buttonFail1);

       // EsconderNavegacion();

//        botonAbajo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent AnimacionR = new Intent(RelajacionActivity.this, Relajacion2Activity.class);
//                startActivity(AnimacionR);
//                finish();
//            }
//
//        });
//
//        botonArriba.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent AnimacionR = new Intent(RelajacionActivity.this, Relajacion2Activity.class);
//                startActivity(AnimacionR);
//                finish();
//            }
//        });

        // Create a common gesture listener object.
        DetectSwipeRelajacion gestureListener = new DetectSwipeRelajacion();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
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



        if (Accion == "arriba"){

            Intent regist = new Intent(RelajacionActivity.this, RelajacionAsustadaActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bot);
            finish();

        }

        if (Accion == "abajo"){

            Intent regist = new Intent(RelajacionActivity.this, Relajacion2Activity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
            finish();

        }


    }
}
