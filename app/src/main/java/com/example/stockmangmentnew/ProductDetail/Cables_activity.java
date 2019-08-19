package com.example.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.stockmangmentnew.R;

public class Cables_activity extends AppCompatActivity {
    CheckBox chk1,chk2,chk3,chk4;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cables_activity);

        getSupportActionBar().setTitle("Cabels Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        chk1=(CheckBox)findViewById(R.id.cable_type1);
        chk2=(CheckBox)findViewById(R.id.cable_type2);
        chk3=(CheckBox)findViewById(R.id.cable_type3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
