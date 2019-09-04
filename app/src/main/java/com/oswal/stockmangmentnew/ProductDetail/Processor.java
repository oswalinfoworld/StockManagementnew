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

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.CPUProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.LaptopProfile;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Processor extends AppCompatActivity {


    Button submit;
    Spinner Brandcat,companynamecat,Typecat,genrationcat,ramcat,HDDcat,SHDDcat,oscat,graphiccardcat,dvdcat;

    DatabaseHelper db =null;
  CPUProfile cpuProfile= new  CPUProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();
    ArrayList<String> genListArray = new ArrayList<String>();
    ArrayList<String> ramListArray = new ArrayList<String>();
    ArrayList<String> hddListArray = new ArrayList<String>();
    ArrayList<String> shddListArray = new ArrayList<String>();
    ArrayList<String> osListArray = new ArrayList<String>();
    ArrayList<String> graphicsListArray = new ArrayList<String>();
    ArrayList<String> dvdListArray = new ArrayList<String>();



    /* String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[ ]typeList = {"Select","C2D", "DC", "i3", "i5", "i7"};
    String[] genList = {"Select","1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] ramList = {"Select","2", "4", "8", "6", "16", "32", "64", "128"};
    String[] hddList = {"Select","0", "250GB", "320GB", "500GB", "1TB", "2TB", "4TB"};
    String[] shddList = {"Select","80GB", "250GB", "320GB", "500GB", "1TB", "2TB", "4TB"};
    String[] osList = {"Select","DOS", "window10home", "window10pro"};
    String[] graphicsList = {"Select", "0", "onboard", "2GB", "4GB", "8GB"};
    String[]dvdsList = {"Select", "Yes","No"};
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);
        getSupportActionBar().setTitle("Processor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Brandcat=(Spinner)findViewById(R.id.cpu_spinner1) ;
        companynamecat=(Spinner)findViewById(R.id.cpu_spinner2) ;
        Typecat=(Spinner)findViewById(R.id.cpu_spinner3) ;
        genrationcat=(Spinner)findViewById(R.id.cpu_spinner4) ;
        ramcat=(Spinner)findViewById(R.id.cpu_spinner5) ;
        HDDcat=(Spinner)findViewById(R.id.cpu_spinner6) ;
        SHDDcat=(Spinner)findViewById(R.id.cpu_spinner7) ;
        oscat=(Spinner)findViewById(R.id.cpu_spinner8) ;
        graphiccardcat=(Spinner)findViewById(R.id.cpu_spinner9) ;
        dvdcat=(Spinner)findViewById(R.id.cpu_spinner10) ;

        db = new DatabaseHelper(this);
        if(db.getCPUProfileCount()>0){
            cpuProfile=db.getAllCPUProfileDetails();
            Toast.makeText(getApplicationContext()," Cpu brand List "+cpuProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data Laptop Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+cpuProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(cpuProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsontypeList = new JSONObject(cpuProfile.getProtypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("typeList");

            if (jArraytypeList != null) {
                for (int i=0;i<jArraytypeList.length();i++){
                    typeListArray.add(jArraytypeList.getString(i));
                }
            }

            JSONObject jsongenList = new JSONObject(cpuProfile.getGen().toString());
            JSONArray jArraygenList = jsongenList.optJSONArray("GenList");

            if (jArraygenList != null) {
                for (int i=0;i<jArraygenList.length();i++){
                    genListArray.add(jArraygenList.getString(i));
                }
            }


            JSONObject jsonramList = new JSONObject(cpuProfile.getRam().toString());
            JSONArray jArrayramList = jsonramList.optJSONArray("RamList");

            if (jArrayramList != null) {
                for (int i=0;i<jArrayramList.length();i++){
                    ramListArray.add(jArrayramList.getString(i));
                }
            }





            JSONObject jsonHDDList = new JSONObject(cpuProfile.getHdd().toString());
            JSONArray jArrayHDDList = jsonHDDList.optJSONArray("HDDList");

            if (jArrayHDDList != null) {
                for (int i=0;i<jArrayHDDList.length();i++){
                    hddListArray.add(jArrayHDDList.getString(i));
                }
            }


            JSONObject jsonSHDDList = new JSONObject(cpuProfile.getShdd().toString());
            JSONArray jArraySHDDList = jsonSHDDList.optJSONArray("SHDDList");

            if (jArraySHDDList != null) {
                for (int i=0;i<jArraySHDDList.length();i++){
                    shddListArray.add(jArraySHDDList.getString(i));
                }
            }


            JSONObject jsonosList = new JSONObject(cpuProfile.getOs().toString());
            JSONArray jArrayosList = jsonosList.optJSONArray("OSList");

            if (jArrayosList != null) {
                for (int i=0;i<jArrayosList.length();i++){
                    osListArray.add(jArrayosList.getString(i));
                }
            }


            JSONObject jsongraphicList = new JSONObject(cpuProfile.getGrapcard().toString());
            JSONArray jArraygraphicList = jsongraphicList.optJSONArray("GraphiccardList");

            if (jArraygraphicList != null) {
                for (int i=0;i<jArraygraphicList.length();i++){
                    graphicsListArray.add(jArraygraphicList.getString(i));
                }
            }


            JSONObject jsonDVDList = new JSONObject(cpuProfile.getDvd().toString());
            JSONArray jArrayDVDList = jsonDVDList.optJSONArray("DVDList");

            if (jArrayDVDList != null) {
                for (int i=0;i<jArrayDVDList.length();i++){
                    dvdListArray.add(jArrayDVDList.getString(i));
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
                    case 4:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        genrationcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 9:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ramcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        HDDcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
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
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SHDDcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
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
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        oscat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        graphiccardcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
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
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dvdcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
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


        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genListArray);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        genrationcat.setAdapter(aa3);

        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ramListArray);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        ramcat.setAdapter(aa4);



        ArrayAdapter aa6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hddListArray);
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        HDDcat.setAdapter(aa6);


        ArrayAdapter aa7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shddListArray);
        aa7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        SHDDcat.setAdapter(aa7);

        ArrayAdapter aa8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, osListArray);
        aa8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        oscat.setAdapter(aa8);

        ArrayAdapter aa9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, graphicsListArray);
        aa9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        graphiccardcat.setAdapter(aa9);

        ArrayAdapter aa10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dvdListArray);
        aa10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dvdcat.setAdapter(aa10);





        submit=(Button)findViewById(R.id.processor_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Processor.this, Add_Item.class);
                startActivity(i);
            }
        });


    }
}
