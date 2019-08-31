package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;

public class Keyboard_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,Typecat;
    //String[] brandList = {"Select","Logitech","InfyTone","Razer","HP","Ducky" };
   // String[] companyList = {"Select","Microsoft","Logitech","Zebronics","HP" };
    //String[] typeList = {"Select","Wire","Wireless" };
    DatabaseHelper db =null;
    KeyboardProfile keyboardProfile= new KeyboardProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> companyListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_activity);
        getSupportActionBar().setTitle("Keyboard Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.keyboard_sipnner1);
        companynamecat=(Spinner)findViewById(R.id.keyboard_sipnner2) ;
        Typecat=(Spinner)findViewById(R.id.keyboard_sipnner3) ;
        db = new DatabaseHelper(this);
        if(db.getKeyboardProfileCount()>0){
            keyboardProfile=db.getAllKeyboardProfileDetails();
            Toast.makeText(getApplicationContext()," keyBoard brand List "+keyboardProfile.getBrandList(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data Keyboard Details",Toast.LENGTH_LONG).show();
           // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
           // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+keyboardProfile.getBrandList(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(keyboardProfile.getBrandList().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }
            JSONObject jsoncompanyList = new JSONObject(keyboardProfile.getCompanyList().toString());
            JSONArray jArraycompanyList = jsoncompanyList.optJSONArray("companyList");

            if (jArraycompanyList != null) {
                for (int i=0;i<jArraycompanyList.length();i++){
                    companyListArray.add(jArraycompanyList.getString(i));
                }
            }
            JSONObject jsontypeList = new JSONObject(keyboardProfile.getTypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("typeList");

            if (jArraytypeList != null) {
                for (int i=0;i<jArraytypeList.length();i++){
                    typeListArray.add(jArraytypeList.getString(i));
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



                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:


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

        Typecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, companyListArray);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        companynamecat.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);


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
