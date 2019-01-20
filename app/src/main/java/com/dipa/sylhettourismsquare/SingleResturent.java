package com.dipa.sylhettourismsquare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingleResturent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resturent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        casting(); // cast all reference


    }

    private void casting() {

        ImageView rImage;
        TextView tvLocation,tvAddress,tvOpentime,tvCusine,tvParking,tvEmail,tvFb;

        rImage = (ImageView) findViewById(R.id.rimage);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvOpentime = (TextView) findViewById(R.id.tvOpenTime);
        tvCusine = (TextView) findViewById(R.id.tvCusine);
        tvParking = (TextView) findViewById(R.id.tvParking);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvFb = (TextView) findViewById(R.id.tvFb);
    }

}
