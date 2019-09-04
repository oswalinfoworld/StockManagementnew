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

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MouseProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.ScannerProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Scanner_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat,companynamecat,Typecat;
  /*  String[] brandList = {"Select","HP","Epson" };
    String[] companyList = {"Select","HP","DELL" };
    String[] typeList = {"Select","Flatbed","HighSpeed","Topcammera" };
*/

    DatabaseHelper db =null;
    ScannerProfile scannerProfile= new  ScannerProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_activity);
        getSupportActionBar().setTitle("Scanner Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.scanner_spinner1);
        companynamecat=(Spinner)findViewById(R.id.scanner_spinner2) ;
        Typecat=(Spinner)findViewById(R.id.scanner_spinner3) ;

        db = new DatabaseHelper(this);
        if (db.getScannerProfileCount() > 0) {
            scannerProfile = db.getAllScannerProfileDetails();
            Toast.makeText(getApplicationContext(), "Scanner brand List " + scannerProfile.getBrandList(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + scannerProfile.getBrandList(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(scannerProfile.getBrandList().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsontypeList = new JSONObject(scannerProfile.getTypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("TypeList");

            if (jArraytypeList != null) {
                for (int i = 0; i < jArraytypeList.length(); i++) {
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
                    case 3:
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



        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);



        submit=(Button)findViewById(R.id.scanner_subtbn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Scanner_activity.this, Add_Item.class);
                startActivity(i);
            }
        });
    }
}
