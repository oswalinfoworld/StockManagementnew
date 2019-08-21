package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class xerox_activity extends AppCompatActivity {
    EditText companyname,modelno;
    CheckBox ppm1,ppm2,ppm3,ppm4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xerox_activity);
        getSupportActionBar().setTitle("Xerox Machin Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ppm1=(CheckBox)findViewById(R.id.xerox_ppm1);
        ppm2=(CheckBox)findViewById(R.id.xerox_ppm2);
        ppm3=(CheckBox)findViewById(R.id.xerox_ppm3);
        ppm4=(CheckBox)findViewById(R.id.xerox_ppm4);
        companyname=(EditText)findViewById(R.id.xerox_compyame);
        modelno=(EditText)findViewById(R.id.xerox_modelno);
        submit=(Button)findViewById(R.id.xerox_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(xerox_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
