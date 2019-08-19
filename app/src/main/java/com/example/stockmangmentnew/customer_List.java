package com.example.stockmangmentnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class customer_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__list);
        getSupportActionBar().setTitle("Customer List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
