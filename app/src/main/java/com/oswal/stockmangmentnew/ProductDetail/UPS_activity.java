package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oswal.stockmangmentnew.R;

public class UPS_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ups_activity);
        getSupportActionBar().setTitle("UPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
