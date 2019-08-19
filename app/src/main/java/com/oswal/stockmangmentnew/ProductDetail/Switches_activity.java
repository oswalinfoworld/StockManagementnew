package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oswal.stockmangmentnew.R;

public class Switches_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches_activity);
        getSupportActionBar().setTitle("Switch Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
