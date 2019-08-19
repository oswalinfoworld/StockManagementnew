package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;

public class Printer_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2,type3,type4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_activity);
        getSupportActionBar().setTitle("Printer Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.printer_compyname1);
        companyname2=(CheckBox)findViewById(R.id.printer_compyname2);
        companyname3=(CheckBox)findViewById(R.id.printer_compyname3);
        companyname4=(CheckBox)findViewById(R.id.printer_compyname4);
        type1=(CheckBox)findViewById(R.id.printer_type1);
        type2=(CheckBox)findViewById(R.id.printer_type2);
        type3=(CheckBox)findViewById(R.id.printer_type3);
        type4=(CheckBox)findViewById(R.id.printer_type4);

        submit=(Button)findViewById(R.id.printer_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
