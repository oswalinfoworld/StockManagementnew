package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;

public class Wifidongle_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2;
    EditText simname,simrecharge,simvalidity;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifidongle_activity);
        getSupportActionBar().setTitle("Dongle Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.dongle_compyname1);
        companyname2=(CheckBox)findViewById(R.id.dongle_compyname2);
        companyname3=(CheckBox)findViewById(R.id.dongle_compyname3);
        companyname4=(CheckBox)findViewById(R.id.dongle_compyname4);
        type1=(CheckBox)findViewById(R.id.dongle_type1);
        type2=(CheckBox)findViewById(R.id.dongle_type2);
        simname=(EditText)findViewById(R.id.dongle_simname);
        simrecharge=(EditText)findViewById(R.id.dongle_simrecharge);
        simvalidity=(EditText)findViewById(R.id.dongle_simvalidity);
        submit=(Button)findViewById(R.id.dongle_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
