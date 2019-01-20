package com.dipa.sylhettourismsquare;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMainActivity();
            }
        },3000);


    }

    private void goToMainActivity()
    {
        Intent intent = new Intent(Splashscreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
