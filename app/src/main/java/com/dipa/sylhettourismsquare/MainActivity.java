package com.dipa.sylhettourismsquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout locations;
    private LinearLayout packages;
    private LinearLayout hotels;

    private LinearLayout transports;
    private LinearLayout firstAid;
    private LinearLayout traditionalShops;
    private LinearLayout restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        locations = (LinearLayout) findViewById(R.id.ll0);
        locations.setOnClickListener(this);
        packages = (LinearLayout)findViewById(R.id.packages);
        packages.setOnClickListener(this);
        hotels = (LinearLayout)findViewById(R.id.hotels);
        hotels.setOnClickListener(this);

        transports = (LinearLayout)findViewById(R.id.transport);
        transports.setOnClickListener(this);
        firstAid = (LinearLayout)findViewById(R.id.firstaid);
        firstAid.setOnClickListener(this);
        traditionalShops = (LinearLayout)findViewById(R.id.shops);
        traditionalShops.setOnClickListener(this);
        restaurants = (LinearLayout) findViewById(R.id.resturents);
        restaurants.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.ll0:
                goToLocationActivity();
                break;
            case R.id.packages:
                goToPackagesActivity();
                break;
            case R.id.hotels:
               goToHotelsActivity();
                break;
            case R.id.transport:
                goToTransportActivity();
                break;
            case  R.id.firstaid:
                goToFirstAidActivity();
                break;
            case R.id.shops:
                goToShopsActivity();
                break;
            case R.id.resturents:
               goToRestuarentsAtivity();
                break;
            default:
                break;
        }
    }

    private void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private void goToLocationActivity(){
        Intent intent = new Intent(MainActivity.this,Locations.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToPackagesActivity(){
        Intent intent = new Intent(MainActivity.this,Packages.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToHotelsActivity(){
        Intent intent = new Intent(MainActivity.this,Hotels.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToTransportActivity(){
        Intent intent = new Intent(MainActivity.this,Transport.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToRestuarentsAtivity(){
        Intent intent = new Intent(MainActivity.this,Restuarents.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToShopsActivity(){
        Intent intent = new Intent(MainActivity.this,Shops.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void goToFirstAidActivity(){
        Intent intent = new Intent(MainActivity.this,FirstAid.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
