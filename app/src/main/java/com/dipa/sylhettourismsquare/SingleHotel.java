package com.dipa.sylhettourismsquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.TextView;

import com.dipa.models.HotelItem;

import java.util.List;

public class SingleHotel extends AppCompatActivity {

    TextView tvName,tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hotel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAddress = (TextView) findViewById(R.id.tvRAddress);

        String  name = getIntent().getStringExtra("name");
        String  address = getIntent().getStringExtra("address");

        //Log.e("name", hotItem.getName());
        //Log.e("address", hotItem.getAddress());

        tvName.setText(name);
        tvAddress.setText(address);


    }

}
