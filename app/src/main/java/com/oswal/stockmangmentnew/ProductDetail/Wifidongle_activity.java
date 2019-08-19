package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oswal.stockmangmentnew.R;

public class Wifidongle_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifidongle_activity);
        getSupportActionBar().setTitle("Dongle Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
