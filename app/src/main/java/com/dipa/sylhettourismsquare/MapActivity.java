package com.dipa.sylhettourismsquare;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    // Google Map
    private GoogleMap mMap;
    UiSettings mapSettings;
    private static final int LOCATION_REQUEST_CODE = 101;

    public double latitude, longitude;
    public String Lat, Long, LocationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION,
                LOCATION_REQUEST_CODE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Lat = getIntent().getStringExtra("latitude");
        Long = getIntent().getStringExtra("longitude");
        LocationName = getIntent().getStringExtra("location");

        latitude = Double.parseDouble(Lat);
        longitude = Double.parseDouble(Long);
    }

    protected void requestPermission(String permissionType, int requestCode) {
        int permission = ContextCompat.checkSelfPermission(this,
                permissionType);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{permissionType}, requestCode
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST_CODE: {

                if (grantResults.length == 0
                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Unable to show location - permission required", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
            return true;
        }
        if (id == R.id.action_normal) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        }

        if(id == R.id.action_sat){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }

        if (id == R.id.action_hybrid) {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            return true;
        }

        if(id == R.id.action_terrain){
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap = googleMap;

        if (mMap != null) {
            mMap.setMyLocationEnabled(true);

            mapSettings = mMap.getUiSettings();
            mapSettings.setCompassEnabled(true);
        }

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng place = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(place).title(LocationName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));

        //Animating the camera
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(place)
                .zoom(15)
                .bearing(50)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }
}
