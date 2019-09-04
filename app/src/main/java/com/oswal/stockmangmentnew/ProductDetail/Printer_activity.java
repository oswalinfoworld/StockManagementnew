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
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.PrinterProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Printer_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2,type3,type4;
    Button submit;
    Spinner Brandcat,companynamecat;
    DatabaseHelper db =null;
    PrinterProfile printerProfile= new   PrinterProfile ();
    ArrayList<String> brandListArray = new ArrayList<String>();




    /*  String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","Canon","Samsung","HP","Brother" };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_activity);
        getSupportActionBar().setTitle("Printer Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.printer_spinner1);
        companynamecat=(Spinner)findViewById(R.id.printer_spinner2) ;

        type1=(CheckBox)findViewById(R.id.printer_type1);
        type2=(CheckBox)findViewById(R.id.printer_type2);
        type3=(CheckBox)findViewById(R.id.printer_type3);
        type4=(CheckBox)findViewById(R.id.printer_type4);
        submit=(Button)findViewById(R.id.printer_subbtn1);

        db = new DatabaseHelper(this);
        if(db.getprinterProfileCount()>0){
            printerProfile=db.getAllPrinterProfileDetails();
            Toast.makeText(getApplicationContext(),"Printer brand List "+printerProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data GPS Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+printerProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonprinterList = new JSONObject(printerProfile.getBrandName().toString());
            JSONArray jArrayprinterList = jsonprinterList.optJSONArray("brandList");

            if (jArrayprinterList != null) {
                for (int i=0;i<jArrayprinterList.length();i++){
                    brandListArray.add(jArrayprinterList.getString(i));
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


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandListArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
               Intent i = new Intent(Printer_activity.this, Add_Item.class);
                startActivity(i);
            }
        });

    }
}
