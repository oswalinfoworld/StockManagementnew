package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.oswal.stockmangmentnew.LoginModule.ForgetPassword;
import com.oswal.stockmangmentnew.LoginModule.LoginPage;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

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
        submit=(Button)findViewById(R.id.cables_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
/*

                Intent i = new Intent(Cables_activity.this, Add_Item.class);
                startActivity(i);
*/

            }
        });
    }
}