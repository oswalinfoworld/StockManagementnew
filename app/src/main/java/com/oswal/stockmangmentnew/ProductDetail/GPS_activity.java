package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.LoginModule.ForgetPassword;
import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GPS_activity extends AppCompatActivity {
    EditText companyname,simname,simrecharge,simvalidity;
    Button submit;
    Spinner Brandcat,companynamecat;
   // String[] brandList = {"Select","HP","DEll" };
    //String[] companyList = {"Select","HP","DELL" };

    DatabaseHelper db =null;
    GPSProfile gpsProfile= new   GPSProfile ();
    ArrayList<String> brandListArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_activity);
        getSupportActionBar().setTitle("GPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.gps_spinner1) ;
        companynamecat=(Spinner)findViewById(R.id.gps_spinner2) ;


        db = new DatabaseHelper(this);
        if(db.getGPSProfileCount()>0){
            gpsProfile=db.getAllGPSProfileDetails();
            Toast.makeText(getApplicationContext()," Gps brand List "+gpsProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data GPS Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+gpsProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(gpsProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
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
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
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
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.gps_activity_brandList));
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.gps_company));
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        companynamecat.setAdapter(aa1);

        simname=(EditText)findViewById(R.id.gps_simname);
        simrecharge=(EditText)findViewById(R.id.gps_recharge);
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
