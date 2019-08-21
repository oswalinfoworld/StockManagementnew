package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class Monitor_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,inches1,inches2,inches3,inches4,inches5,inches6;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_activity);
        getSupportActionBar().setTitle("Monitor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.monitor_compyname1);
        companyname2=(CheckBox)findViewById(R.id.monitor_compyname2);
        companyname3=(CheckBox)findViewById(R.id.monitor_compyname3);
        companyname4=(CheckBox)findViewById(R.id.monitor_compyname4);
        inches1=(CheckBox)findViewById(R.id.monitor_inches1);
        inches2=(CheckBox)findViewById(R.id.monitor_inches2);
        inches3=(CheckBox)findViewById(R.id.monitor_inches3);
        inches4=(CheckBox)findViewById(R.id.monitor_inches4);
        inches5=(CheckBox)findViewById(R.id.monitor_inches5);
        inches6=(CheckBox)findViewById(R.id.monitor_inches6);
        submit=(Button)findViewById(R.id.monitor_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Monitor_activity.this, Add_Item.class);
                startActivity(i);
            }
        });

    }
}
