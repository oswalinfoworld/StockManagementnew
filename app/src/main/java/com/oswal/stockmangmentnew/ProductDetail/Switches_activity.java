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

public class Switches_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,Typecat,portcat;
    String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","DGSOL","Dlink" };
    String[] typeList = {"Select","Wire","Wireless" };
    String[ ]PortsList = {"Select","4", "8","16","24","48"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches_activity);
        getSupportActionBar().setTitle("Switch Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.switch_spinner1) ;
        companynamecat=(Spinner)findViewById(R.id.switch_spinner2) ;
        Typecat=(Spinner)findViewById(R.id.switch_spinner3) ;
        portcat=(Spinner)findViewById(R.id.switch_spinner4) ;


        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
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
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Typecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        portcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Switches_activity.this, Switches_activity.class);
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

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeList);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, PortsList);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        portcat.setAdapter(aa3);


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
