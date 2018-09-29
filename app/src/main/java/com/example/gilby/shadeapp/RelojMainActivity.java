package com.example.gilby.shadeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class RelojMainActivity extends AppCompatActivity {

    // This textview is used to display swipe or tap status info.
    private TextView Thora,Tminutos,Tformato,Desplegable;
    private ImageView logo;
    private Calendar HActual;
    // This is the gesture detector compat instance.
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reloj);

        Thora = (TextView) findViewById(R.id.visor_hora);
        Tminutos = (TextView) findViewById(R.id.visor_minutos);
        Tformato = (TextView) findViewById(R.id.visor_formato);

        logo = (ImageView)findViewById(R.id.logo1);
        Desplegable = (TextView) findViewById(R.id.boton_opciones);

        Calendar HActual = Calendar.getInstance();

        Thora.setText(Calendar.getInstance().getTime().toString());

        //TimePickerDialog tiempo = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener());

        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        updateTime();

        tiempo.start();

        Desplegable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(RelojMainActivity.this, MenuActivity.class);
                startActivity(regist);
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bot);
                finish();
            }

        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regist = new Intent(RelojMainActivity.this, Relajacion2Activity.class);
                startActivity(regist);
                finish();
            }

        });



    }

    Thread tiempo = new Thread() {
        public void run() {

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run(){
                    updateTime();
                }
            });

        }

    }
    };




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

            Intent regist = new Intent(RelojMainActivity.this, MenuActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bot);
            finish();

        }

        if (Accion == "abajo"){

            Intent regist = new Intent(RelojMainActivity.this, RelajacionActivity.class);
            startActivity(regist);
            overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
            finish();

        }


    }

    public void updateTime() {
        String am_pm = "Am";
        HActual = Calendar.getInstance();
        if (HActual.get(Calendar.AM_PM) == Calendar.AM)
            am_pm = "AM";
        else if (HActual.get(Calendar.AM_PM) == Calendar.PM)
            am_pm = "PM";
        if(HActual.get(Calendar.HOUR) > 9 ){//|| HActual.get(Calendar.HOUR) > 12 && HActual.get(Calendar.HOUR) < 22){
            Thora.setText(String.valueOf(HActual.get(Calendar.HOUR)) + ":");
        }
        else{
            Thora.setText("0"+ String.valueOf(HActual.get(Calendar.HOUR)) + ":");
        }
        if(HActual.get(Calendar.MINUTE)>9) {
            Tminutos.setText(String.valueOf(HActual.get(Calendar.MINUTE)));
        }else{
                Tminutos.setText("0" + String.valueOf(HActual.get(Calendar.MINUTE)));
            }
        Tformato.setText(am_pm);
    }
}

