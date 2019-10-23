package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.LaptopProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Laptop_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat, Typecat, genrationcat, ramcat, inchescat, HDDcat, SHDDcat, oscat, graphiccardcat, dvdcat;
    DatabaseHelper db = null;
    String brandCatS,typeCatS,generationCatS,ramCatS,inchesCatS,HDDCatS,SHDDcatS,oscatS,graphiccardCatS,DVDCatS;
    LaptopProfile laptopProfile = new LaptopProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();
    ArrayList<String> genListArray = new ArrayList<String>();
    ArrayList<String> ramListArray = new ArrayList<String>();
    ArrayList<String> inchesListArray = new ArrayList<String>();
    ArrayList<String> hddListArray = new ArrayList<String>();
    ArrayList<String> shddListArray = new ArrayList<String>();
    ArrayList<String> osListArray = new ArrayList<String>();
    ArrayList<String> graphicsListArray = new ArrayList<String>();
    ArrayList<String> dvdListArray = new ArrayList<String>();


    String model_number,model_category,model_serial_number,model_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_activity);
        getSupportActionBar().setTitle("Laptop Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //step1
        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");

        Brandcat = (Spinner) findViewById(R.id.lap_spinner1);
        Typecat = (Spinner) findViewById(R.id.lap_spinner2);
        genrationcat = (Spinner) findViewById(R.id.lap_spinner3);
        ramcat = (Spinner) findViewById(R.id.lap_spinner4);
        inchescat = (Spinner) findViewById(R.id.lap_spinner5);
        HDDcat = (Spinner) findViewById(R.id.lap_spinner6);
        SHDDcat = (Spinner) findViewById(R.id.lap_spinner7);
        oscat = (Spinner) findViewById(R.id.lap_spinner8);
        graphiccardcat = (Spinner) findViewById(R.id.lap_spinner9);
        dvdcat = (Spinner) findViewById(R.id.lap_spinner11);


        db = new DatabaseHelper(this);
        if (db.getLaptopProfileCount() > 0) {
            laptopProfile = db.getAllLaptopProfileDetails();
            Toast.makeText(getApplicationContext(), " Laptop brand List " + laptopProfile.getBrandName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + laptopProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(laptopProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandListLaptopProfile");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsontypeList = new JSONObject(laptopProfile.getProtypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("processortypeLaptopProfile");

            if (jArraytypeList != null) {
                for (int i = 0; i < jArraytypeList.length(); i++) {
                    typeListArray.add(jArraytypeList.getString(i));
                }
            }

            JSONObject jsongenList = new JSONObject(laptopProfile.getGen().toString());
            JSONArray jArraygenList = jsongenList.optJSONArray("genrationListLaptopProfile");

            if (jArraygenList != null) {
                for (int i = 0; i < jArraygenList.length(); i++) {
                    genListArray.add(jArraygenList.getString(i));
                }
            }


            JSONObject jsonramList = new JSONObject(laptopProfile.getRam().toString());
            JSONArray jArrayramList = jsonramList.optJSONArray("RamListLaptopProfile");

            if (jArrayramList != null) {
                for (int i = 0; i < jArrayramList.length(); i++) {
                    ramListArray.add(jArrayramList.getString(i));
                }
            }


            JSONObject jsoninchesList = new JSONObject(laptopProfile.getInches().toString());
            JSONArray jArrayinchesList = jsoninchesList.optJSONArray("InchesListLaptopProfile");

            if (jArrayinchesList != null) {
                for (int i = 0; i < jArrayinchesList.length(); i++) {
                    inchesListArray.add(jArrayinchesList.getString(i));
                }
            }


            JSONObject jsonHDDList = new JSONObject(laptopProfile.getHdd().toString());
            JSONArray jArrayHDDList = jsonHDDList.optJSONArray("HDDListLaptopProfile");

            if (jArrayHDDList != null) {
                for (int i = 0; i < jArrayHDDList.length(); i++) {
                    hddListArray.add(jArrayHDDList.getString(i));
                }
            }


            JSONObject jsonSHDDList = new JSONObject(laptopProfile.getShdd().toString());
            JSONArray jArraySHDDList = jsonSHDDList.optJSONArray("SHDDListLaptopProfile");

            if (jArraySHDDList != null) {
                for (int i = 0; i < jArraySHDDList.length(); i++) {
                    shddListArray.add(jArraySHDDList.getString(i));
                }
            }


            JSONObject jsonosList = new JSONObject(laptopProfile.getOs().toString());
            JSONArray jArrayosList = jsonosList.optJSONArray("OsListLaptopProfile");

            if (jArrayosList != null) {
                for (int i = 0; i < jArrayosList.length(); i++) {
                    osListArray.add(jArrayosList.getString(i));
                }
            }


            JSONObject jsongraphicList = new JSONObject(laptopProfile.getGrapcard().toString());
            JSONArray jArraygraphicList = jsongraphicList.optJSONArray("GraphiccardListLaptopProfile");

            if (jArraygraphicList != null) {
                for (int i = 0; i < jArraygraphicList.length(); i++) {
                    graphicsListArray.add(jArraygraphicList.getString(i));
                }
            }


            JSONObject jsonDVDList = new JSONObject(laptopProfile.getDvd().toString());
            JSONArray jArrayDVDList = jsonDVDList.optJSONArray("DVDwriterListLaptopProfile");

            if (jArrayDVDList != null) {
                for (int i = 0; i < jArrayDVDList.length(); i++) {
                    dvdListArray.add(jArrayDVDList.getString(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        submit = (Button) findViewById(R.id.laptop_submitbutton);
        //step2
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(Laptop_activity.this, Add_Item.class);
                i.putExtra("Laptop_activity_brandCat",brandCatS);
                i.putExtra("Laptop_activity_typeCat",typeCatS);
                i.putExtra("Laptop_activity_generationCat",generationCatS);
                i.putExtra("Laptop_activity_ramCat",ramCatS);
                i.putExtra("Laptop_activity_inchesCat",inchesCatS);
                i.putExtra("Laptop_activity_HDDCat",HDDCatS);
                i.putExtra("Laptop_activity_SHDDCat",SHDDcatS);
                i.putExtra("Laptop_activity_OSCat",oscatS);
                i.putExtra("Laptop_activity_graphiccardCat",graphiccardCatS);
                i.putExtra("Laptop_acDDtivity_DVDCat",DVDCatS);
                startActivity(i);*/

                if (isInternetOn()) {
                    new  Laptop_activity. insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(Laptop_activity.this, Add_Item.class);
                    startActivity(i1);
                }

            }
        });
        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:

                        break;
                    case 1:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 4:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


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
                switch (i) {
                    case 0:
                        typeCatS = adapterView.getItemAtPosition(i).toString();
                        break;
                    case 1:
                        typeCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 2:
                        typeCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 3:
                        typeCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 4:
                        typeCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 5:
                        typeCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        generationCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 2:
                        generationCatS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 3:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 6:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 9:
                        generationCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 2:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        ramCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inchescat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        inchesCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 2:
                        inchesCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 3:
                        inchesCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        inchesCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 5:
                        inchesCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        HDDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 7:
                        SHDDcatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        oscatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        oscatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        oscatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        oscatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        graphiccardCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        DVDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        DVDCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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

        ArrayAdapter aa5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, inchesListArray);
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        inchescat.setAdapter(aa5);

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


    }

    public boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(getApplicationContext(), "Internet Down Data not Reflect on server", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }


    private class insertItemToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");

            Item item= new Item();
            item.setCategory(model_category);
            item.setModel_number(model_number);
            item.setSerial_number(model_serial_number);
            item.setDate(model_date);

            ItemSpecification itemSpecification = new ItemSpecification();

            itemSpecification.setBrand(brandCatS);
            itemSpecification.setType(typeCatS);
            itemSpecification.setGeneration(generationCatS);
            itemSpecification.setRam(ramCatS);
            itemSpecification.setInches(inchesCatS);
            itemSpecification.setHdd(HDDCatS);
            itemSpecification.setShdd(SHDDcatS);
            itemSpecification.setOs(oscatS);
            itemSpecification.setGraphic_card(graphiccardCatS);
            itemSpecification.setDvd_writer(DVDCatS);
            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }
}



