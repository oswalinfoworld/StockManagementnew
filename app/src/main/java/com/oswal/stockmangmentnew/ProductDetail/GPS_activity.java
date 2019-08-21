package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.LoginModule.ForgetPassword;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class GPS_activity extends AppCompatActivity {
    EditText companyname,simname,simrecharge,simvalidity;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_activity);
        getSupportActionBar().setTitle("GPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname=(EditText)findViewById(R.id.gps_compyame);
        simname=(EditText)findViewById(R.id.gps_compyame);
        simrecharge=(EditText)findViewById(R.id.gps_simname);
        simvalidity=(EditText)findViewById(R.id.gps_validity);
        submit=(Button)findViewById(R.id.gps_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data send", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(GPS_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
