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

public class UPS_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,companyname5,type1,type2,capacity1,capacity2,capacity3,capacity4;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ups_activity);
        getSupportActionBar().setTitle("UPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.ups_compyname1);
        companyname2=(CheckBox)findViewById(R.id.ups_compyname2);
        companyname3=(CheckBox)findViewById(R.id.ups_compyname3);
        companyname4=(CheckBox)findViewById(R.id.ups_compyname4);
        companyname5=(CheckBox)findViewById(R.id.ups_compyname5);
        type1=(CheckBox)findViewById(R.id.ups_type1);
        type2=(CheckBox)findViewById(R.id.ups_type2);
        capacity1=(CheckBox)findViewById(R.id.ups_capacity1);
        capacity2=(CheckBox)findViewById(R.id.ups_capacity2);
        capacity3=(CheckBox)findViewById(R.id.ups_capacity3);
        capacity4=(CheckBox)findViewById(R.id.ups_capacity4);
        submit=(Button)findViewById(R.id.ups_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UPS_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
