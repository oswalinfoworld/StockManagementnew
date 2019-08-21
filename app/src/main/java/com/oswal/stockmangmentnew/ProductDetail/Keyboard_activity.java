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

public class Keyboard_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,keyboardtype1,keyboardtype2;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_activity);
        getSupportActionBar().setTitle("Keyboard Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname1=(CheckBox)findViewById(R.id.keyboard_compyname1);
        companyname2=(CheckBox)findViewById(R.id.keyboard_compyname2);
        companyname3=(CheckBox)findViewById(R.id.keyboard_compyname3);
        companyname4=(CheckBox)findViewById(R.id.keyboard_compyname4);

        keyboardtype1=(CheckBox)findViewById(R.id.keyboard_wire);
        keyboardtype2=(CheckBox)findViewById(R.id.keyboard_wireless);
        submit=(Button)findViewById(R.id.keyboard_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Keyboard_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
