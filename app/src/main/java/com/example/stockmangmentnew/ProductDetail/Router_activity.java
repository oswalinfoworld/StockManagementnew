package com.example.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.stockmangmentnew.R;

public class Router_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2,port1,port2,port3,port4,mbps1,mbps2,mbps3;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router_activity);
        getSupportActionBar().setTitle("Router Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.router_compyname1);
        companyname2=(CheckBox)findViewById(R.id.router_compyname2);
        companyname3=(CheckBox)findViewById(R.id.router_compyname3);
        companyname4=(CheckBox)findViewById(R.id.router_compyname4);
        type1=(CheckBox)findViewById(R.id.router_type1);
        type2=(CheckBox)findViewById(R.id.router_type2);
        port1=(CheckBox)findViewById(R.id.router_port1);
        port2=(CheckBox)findViewById(R.id.router_port2);
        port3=(CheckBox)findViewById(R.id.router_port3);
        port4=(CheckBox)findViewById(R.id.router_port4);
        mbps1=(CheckBox)findViewById(R.id.router_mbps1);
        mbps2=(CheckBox)findViewById(R.id.router_mbps2);
        mbps3=(CheckBox)findViewById(R.id.router_mbps3);
        submit=(Button)findViewById(R.id.router_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
