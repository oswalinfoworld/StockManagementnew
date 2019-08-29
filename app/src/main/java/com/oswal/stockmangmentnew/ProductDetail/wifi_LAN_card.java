package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.oswal.stockmangmentnew.R;

public class wifi_LAN_card extends AppCompatActivity {
    Spinner Brandcat,companynamecat,MBPScat;
    String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[] MBPSList = {"Select","150","300" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__lan_card);
        getSupportActionBar().setTitle("Wifi_LAN Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.wifilan_spinner1);
        companynamecat=(Spinner)findViewById(R.id.wifilan_spinner2) ;
        MBPScat=(Spinner)findViewById(R.id.wifilan_spinner3) ;

        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
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
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        MBPScat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(wifi_LAN_card.this, wifi_LAN_card.class);
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

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, MBPSList);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        MBPScat.setAdapter(aa2);

    }
}
