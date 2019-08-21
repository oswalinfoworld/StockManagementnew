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

public class Switches_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2,port1,port2,port3,port4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches_activity);
        getSupportActionBar().setTitle("Switch Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.switch_compyname1);
        companyname2=(CheckBox)findViewById(R.id.switch_compyname2);
        companyname3=(CheckBox)findViewById(R.id.switch_compyname3);
        companyname4=(CheckBox)findViewById(R.id.switch_compyname4);
        type1=(CheckBox)findViewById(R.id.switch_mang);
        type2=(CheckBox)findViewById(R.id.switch_unmang);
        port1=(CheckBox)findViewById(R.id.switch_port1);
        port2=(CheckBox)findViewById(R.id.switch_port2);
        port3=(CheckBox)findViewById(R.id.switch_port3);
        port4=(CheckBox)findViewById(R.id.switch_port4);
        submit=(Button)findViewById(R.id.switch_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Switches_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
