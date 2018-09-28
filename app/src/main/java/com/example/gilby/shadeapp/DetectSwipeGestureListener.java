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
        private CancelarActivity activity5 = null;
        private ConfiguracionActivity activity6 = null;

    // public DetectSwipeDirectionActivity getActivity() { return activity; }

    public void setActivity(RelojMainActivity activity) { this.activity = activity; }
    public void setActivity(MenuActivity activity) { this.activity2 = activity; }
    public void setActivity(PedirUberActivity activity) { this.activity3 = activity; }
    public void setActivity(LlamadaActivity activity) { this.activity4 = activity; }
    public void setActivity(CancelarActivity activity) { this.activity5 = activity; }
    public void setActivity(ConfiguracionActivity activity){this.activity6 = activity;}

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