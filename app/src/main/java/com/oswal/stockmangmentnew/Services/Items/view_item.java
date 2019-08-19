package com.oswal.stockmangmentnew.Services.Items;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oswal.stockmangmentnew.R;

public class view_item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        getSupportActionBar().setTitle("View Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
