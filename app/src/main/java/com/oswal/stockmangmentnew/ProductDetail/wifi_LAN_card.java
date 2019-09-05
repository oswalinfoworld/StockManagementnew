package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TVProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_LanProfile;
import com.oswal.stockmangmentnew.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class wifi_LAN_card extends AppCompatActivity {
    Spinner Brandcat,companynamecat,MBPScat;
   /* String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[] MBPSList = {"Select","150","300" };
*/

    DatabaseHelper db =null;
wifi_LanProfile wifiLanProfile= new wifi_LanProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> mbpsListArray = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__lan_card);
        getSupportActionBar().setTitle("Wifi_LAN Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.wifilan_spinner1);
        companynamecat=(Spinner)findViewById(R.id.wifilan_spinner2) ;
        MBPScat=(Spinner)findViewById(R.id.wifilan_spinner3) ;


        db = new DatabaseHelper(this);
        if (db.getwifi_LanProfileCount() > 0) {
            wifiLanProfile = db.getAllwifi_LanProfileDetails();
            Toast.makeText(getApplicationContext(), "Wifi_Lan brand List " + wifiLanProfile.getBrandName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + wifiLanProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(wifiLanProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("WifiLanProfile_brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsonmbpsList = new JSONObject(wifiLanProfile.getMbps().toString());
            JSONArray jArraymbpsList = jsonmbpsList.optJSONArray("WifiLanProfile_MbpsList");

            if (jArraymbpsList != null) {
                for (int i = 0; i < jArraymbpsList.length(); i++) {
           mbpsListArray.add(jArraymbpsList.getString(i));
                }
            }








        } catch (Exception e) {
            e.printStackTrace();
        }











        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandListArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);


        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mbpsListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        MBPScat.setAdapter(aa2);

    }
}
