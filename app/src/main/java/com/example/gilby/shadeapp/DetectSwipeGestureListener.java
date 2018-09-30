package com.example.gilby.shadeapp;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Jerry on 4/18/2018.
 */

public class DetectSwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

    // Minimal x and y axis swipe distance.
    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static int MIN_SWIPE_DISTANCE_Y = 100;

    // Maximal x and y axis swipe distance.
    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;

    // Source activity that display message in text view.
        private RelojMainActivity activity = null;
        private MenuActivity activity2 = null;
        private PedirUberActivity activity3 = null;
        private LlamadaActivity activity4 = null;
        private Llamada2Activity activity10 = null;
        private LlamadaCancelada2Activity activity11 = null;
        private CancelarActivity activity5 = null;
        private ConfiguracionActivity activity6 = null;
        private ConductorActivity activity7 = null;
        private CancelarActivity2 activity8 = null;
        private CancelarActivity3 activity9 = null;
        private CancelarActivity4 activity12 = null;


    // public DetectSwipeDirectionActivity getActivity() { return activity; }

    public void setActivity(RelojMainActivity activity) { this.activity = activity; }
    public void setActivity(MenuActivity activity) { this.activity2 = activity; }
    public void setActivity(PedirUberActivity activity) { this.activity3 = activity; }
    public void setActivity(LlamadaActivity activity) { this.activity4 = activity; }
    public void setActivity(CancelarActivity activity) { this.activity5 = activity; }
    public void setActivity(ConfiguracionActivity activity){this.activity6 = activity;}
    public void setActivity(ConductorActivity activity){this.activity7 = activity;}
    public void setActivity(CancelarActivity2 activity){this.activity8 = activity;}
    public void setActivity(CancelarActivity3 activity){this.activity9 = activity;}
    public void setActivity(Llamada2Activity activity){this.activity10 = activity;}
    public void setActivity(LlamadaCancelada2Activity activity){this.activity11 = activity;}
    public void setActivity(CancelarActivity4 activity){this.activity12 = activity;}

    /* This method is invoked when a swipe gesture happened. */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        // Get swipe delta value in x axis.
        float deltaX = e1.getX() - e2.getX();

        // Get swipe delta value in y axis.
        float deltaY = e1.getY() - e2.getY();

        // Get absolute value.
        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        if((deltaXAbs >= MIN_SWIPE_DISTANCE_X) && (deltaXAbs <= MAX_SWIPE_DISTANCE_X))
        {
            if(deltaX > 0)
            {
                if(this.activity != null) {
                    this.activity.AccionDet("izquierda");
                }
            }else
                {
                if(this.activity != null) {
                    this.activity.AccionDet("derecha");
                }
                else if(this.activity3 != null) {
                    this.activity3.AccionDet("derecha");
                }
                else if(this.activity4 != null) {
                    this.activity4.AccionDet("derecha");
                }
                else if(this.activity5 != null) {
                    this.activity5.AccionDet("derecha");
                }
                else if(this.activity6 != null){
                    this.activity6.AccionDet("derecha");
                }
                else if(this.activity7 != null){
                    this.activity7.AccionDet("derecha");
                }
                else if(this.activity8 != null){
                    this.activity8.AccionDet("derecha");
                }
                else if(this.activity9 != null){
                    this.activity9.AccionDet("derecha");
                }
                else if(this.activity10 != null){
                    this.activity10.AccionDet("derecha");
                }
                else if(this.activity11 != null){
                    this.activity11.AccionDet("derecha");
                }
                else if(this.activity12 != null){
                    this.activity12.AccionDet("derecha");
                }
            }
        }

        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
        {
            if(deltaY > 0)
            {
                if(this.activity != null){
                    this.activity.AccionDet("abajo");
                }
                else if(this.activity2 != null) {
                    this.activity2.AccionDet("abajo");
                }
            }else
            {
                if(this.activity != null) {
                    this.activity.AccionDet("arriba");
                }
            }
        }


        return true;
    }

    // Invoked when single tap screen.
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        if(this.activity != null) {
            this.activity.AccionDet("toque");
        }
        return true;
    }

    // Invoked when double tap screen.
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if(this.activity != null) {
            this.activity.AccionDet("Doble");
        }
        return true;
    }
}