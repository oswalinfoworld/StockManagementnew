package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.LoginModule.ForgetPassword;
import com.oswal.stockmangmentnew.LoginModule.LoginPage;
import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.CablesProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cables_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat;
    //String[] brandList = {"Select","HP","DEll" };
    RadioGroup radioGroup1;

    DatabaseHelper db =null;
 CablesProfile cablesProfile= new   CablesProfile ();
    ArrayList<String> brandListArray = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cables_activity);

        getSupportActionBar().setTitle("Cabels Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.cabels_spinner);

        db = new DatabaseHelper(this);
        if(db.getCablesProfileCount()>0){
            cablesProfile=db.getAllCablesProfileDetails();
            Toast.makeText(getApplicationContext()," Cables brand List "+cablesProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data Cables Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+cablesProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(cablesProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("CablesProfile_brandList");

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
                        Toast.makeText(getApplicationContext(),"HP Selected", Toast.LENGTH_SHORT).show();
                       /* intent = new Intent(Cables_activity.this, Cables_activity.class);
                        startActivity(intent);*/
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"DEll Selected", Toast.LENGTH_SHORT).show();
                       /* intent = new Intent(Cables_activity.this, Cables_activity.class);
                        startActivity(intent);*/
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"DEll Selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"DEll Selected", Toast.LENGTH_SHORT).show();

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.cabel_brandList));
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);


        submit=(Button)findViewById(R.id.cabels_subbtn1);
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
