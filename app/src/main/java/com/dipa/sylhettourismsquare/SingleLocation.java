package com.dipa.sylhettourismsquare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.Manifest;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dipa.utils.ImageUtils;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SingleLocation extends AppCompatActivity implements OnMapReadyCallback{

    private ImageView image;
    private TextView information;
    private String locationInformationEn;
    private String Lat,Long;
    public double longitude;
    public double latitude;
    private String locationInformationBn;
    public String locationName;

    private GoogleMap mMap;

    public  String cLat,cLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) actionBar.setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        int locId = getIntent().getIntExtra("loc_id",0);
        locationName = getIntent().getStringExtra("locationName");
        locationInformationEn = getIntent().getStringExtra("locationInformationEn");
        locationInformationBn = getIntent().getStringExtra("locationInformationBn");
        Lat = getIntent().getStringExtra("locationLatitude");
        Long = getIntent().getStringExtra("locationLongitude");
        int distance = getIntent().getIntExtra("distance",0);
        if(actionBar!=null){
            actionBar.setTitle(locationName);
        }

        image = (ImageView) findViewById(R.id.image);
        information = (TextView) findViewById(R.id.information);

        try{
            Glide.with(this).load(ImageUtils.getImageDrawable(locId)).into(image);
        }catch (Exception e){

        }

        information.setText(locationInformationEn);

        latitude = Double.parseDouble(Lat);
        longitude = Double.parseDouble(Long);
        cLat = "24.897316";
        cLong = "91.86804";

        Button gotoMaps= (Button) findViewById(R.id.gotomaps);
        gotoMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleLocation.this,MapActivity.class);
                intent.putExtra("latitude",Lat);
                intent.putExtra("longitude",Long);
                intent.putExtra("location",locationName);
                startActivity(intent);

            }
        });

        Button getDirect = (Button) findViewById(R.id.getDirection);
        getDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr="+cLat+","+cLong+"&"+"daddr="+Lat+","+Long));
                startActivity(intent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_single_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_bengali) {
            information.setText(locationInformationBn);
            return true;
        }

        if(id == R.id.action_english){
            information.setText(locationInformationEn);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap = googleMap;
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng place = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(place).title(locationName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }
}
