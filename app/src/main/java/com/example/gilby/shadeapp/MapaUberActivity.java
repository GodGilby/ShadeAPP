package com.example.gilby.shadeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapaUberActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_APP_REQUEST_LOCATION_PERMISSION = 0X1001;
    private GoogleMap mMap;
    private Location ubicacionActual;
    //private Marker marcador;
    double lat = 0.0;
    double lng = 0.0;
    private TextView seleccionar;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private LinearLayout lugar1,lugar2,lugar3;
    private int puntos = 0;
    private int datos;
    private int empezado = 0;
    //   FusedLocationProviderClient locationProviderClient;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                datos  = requestCode;

    }//onActivityResult

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_uber);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lugar1 = (LinearLayout)findViewById(R.id.vista1);
        lugar2 = (LinearLayout)findViewById(R.id.vista2);
        lugar3 = (LinearLayout)findViewById(R.id.vista3);

            if (datos == 2){
                lugar1.setVisibility(View.GONE);
                lugar2.setVisibility(View.VISIBLE);
            }
            else if (datos == 3){
                lugar1.setVisibility(View.GONE);
                lugar3.setVisibility(View.VISIBLE);
            }




        seleccionar = (TextView) findViewById(R.id.boton_seleccionar_posicion);

        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(puntos == 1) {
                    Intent regist = new Intent(MapaUberActivity.this, ConductorActivity.class);
                    startActivity(regist);
                    finish();
                }
                else{
                  //  Toast.makeText(getApplicationContext(), "Eliga su ubicacion", Toast.LENGTH_SHORT).show();
                    Snackbar snackbar = Snackbar.make(view, "Eliga su ubicacion", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }

        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                Localizar();
        }
    }


    public void Localizar() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
                        , Manifest.permission.INTERNET}, 10);
            }
            return;
        }
        //UbicacionActual(locationManager.getLastKnownLocation("gps"));
        locationManager.requestLocationUpdates("gps",0,0,locationListener);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *
     *
     */

    public void setlatlng(Location location) {

        lat = location.getLatitude();
        lng = location.getLongitude();

        if(lat ==0 || lng == 0) {

            empezado = 0;
        }
        else{
            empezado = 1;
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(empezado == 0){
//                lat = location.getLatitude();
//                lng = location.getLongitude();
                    setlatlng(location);
                    MiUbicacion();
                    UbicacionActual(location);
//                    lat = location.getLatitude();
//                    lng = location.getLongitude();
//                    LatLng Tu = new LatLng(lat, lng);
//                    float zoomLevel = 16;
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tu,zoomLevel));

                ;}

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        Localizar();
       // MiUbicacion();


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if(empezado == 1) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Partida"));
                    puntos = 1;
                }
            }
        });
    }

    public void MiUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
//        mMap.getUiSettings().setMyLocationButtonEnabled(false);
       // UbicacionActual(locationManager.getLastKnownLocation("gps"));
    }


    public void UbicacionActual(Location location){
        if(location != null){
            lat = location.getLatitude();
            lng = location.getLongitude();
            LatLng Tu = new LatLng(lat, lng);
            float zoomLevel = 16.0f;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tu,zoomLevel));
        }


    }
}
