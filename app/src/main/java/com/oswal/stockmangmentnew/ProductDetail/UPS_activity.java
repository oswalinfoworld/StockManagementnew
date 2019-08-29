package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class UPS_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,typecat,capacitycat;
    String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","Su-Kam","Genus Power","Microtek","Luminous","AmaraRaja"};
    String[] typeList = {"Select","Online","Offline" };
    String[] capacityList = {"Select","0.6KVA","0.650KVA" ,"1KVA","2KVA"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ups_activity);
        getSupportActionBar().setTitle("UPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.ups_spinner1);
        companynamecat=(Spinner)findViewById(R.id.ups_spinner2) ;
        typecat=(Spinner)findViewById(R.id.ups_spinner3) ;
        capacitycat=(Spinner)findViewById(R.id.ups_spinner4) ;
        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        companynamecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        typecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
       capacitycat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(UPS_activity.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, companyList);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        companynamecat.setAdapter(aa1);


        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, capacityList);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        capacitycat.setAdapter(aa3);


        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeList);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        typecat.setAdapter(aa4);

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
