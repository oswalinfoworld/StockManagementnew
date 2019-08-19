package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oswal.stockmangmentnew.R;

public class xerox_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xerox_activity);
        getSupportActionBar().setTitle("Xerox Machin Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
