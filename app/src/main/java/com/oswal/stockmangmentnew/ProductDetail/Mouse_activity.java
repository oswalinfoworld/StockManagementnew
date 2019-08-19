package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;

public class Mouse_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,keyboardtype1,keyboardtype2;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse_activity);
        getSupportActionBar().setTitle("Mouse Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.mouse_compyname1);
        companyname2=(CheckBox)findViewById(R.id.mouse_compyname2);
        companyname3=(CheckBox)findViewById(R.id.mouse_compyname3);
        companyname4=(CheckBox)findViewById(R.id.mouse_compyname4);

        keyboardtype1=(CheckBox)findViewById(R.id.mouse_wire);
        keyboardtype2=(CheckBox)findViewById(R.id.mouse_wireless);
        submit=(Button)findViewById(R.id.mouse_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
