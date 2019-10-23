package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.PointerIcon;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.LaptopProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MonitorProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Monitor_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,inchescat,portcat;
    DatabaseHelper db =null;
 MonitorProfile monitorProfile= new  MonitorProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> inchesListArray = new ArrayList<String>();
    ArrayList<String> portListArray = new ArrayList<String>();
   /* String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[] inchesList = {"Select","14", "16", "18.5", "19.5", "20", "21.5","23.8","28"};
    String[ ]PortsList = {"Select","HDMI", "VGA","DVI"};
*/
   String model_number,model_category,model_serial_number,model_date;
   String BrandS,PortS,InchesS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_activity);
        getSupportActionBar().setTitle("Monitor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model_number = getIntent().getStringExtra("model_number");
        model_category = getIntent().getStringExtra("model_Category");
        model_serial_number = getIntent().getStringExtra("model_serial_number");
        model_date = getIntent().getStringExtra("model_date");


        Brandcat = (Spinner) findViewById(R.id.monitor_spinner1);
        inchescat = (Spinner) findViewById(R.id.monitor_spinner3);
        portcat = (Spinner) findViewById(R.id.monitor_spinner4);
        submit = (Button) findViewById(R.id.monitor_subbtn1);


        db = new DatabaseHelper(this);
        if (db.getMonitorProfileCount() > 0) {
            monitorProfile = db.getAllmonitorProfileDetails();
            Toast.makeText(getApplicationContext(), " Monitor getInches List " + monitorProfile.getInches(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();

        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + monitorProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(monitorProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("Monitor_brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsoninchesList = new JSONObject(monitorProfile.getInches().toString());
            JSONArray jArrayinchesList = jsoninchesList.optJSONArray("Monitor_InchesList");

            if (jArrayinchesList != null) {
                for (int i = 0; i < jArrayinchesList.length(); i++) {
                    inchesListArray.add(jArrayinchesList.getString(i));
                }
            }

            JSONObject jsongportList = new JSONObject(monitorProfile.getPort().toString());
            JSONArray jArrayportList = jsongportList.optJSONArray("Monitor_PortList");

            if (jArrayportList != null) {
                for (int i = 0; i < jArrayportList.length(); i++) {
                    portListArray.add(jArrayportList.getString(i));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        BrandS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        BrandS = adapterView.getItemAtPosition(i).toString();
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
                       InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;

                    case 5:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;

                    case 7:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        InchesS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

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
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        PortS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        PortS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        PortS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        PortS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        PortS = adapterView.getItemAtPosition(i).toString();
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


        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, inchesListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        inchescat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, portListArray);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        portcat.setAdapter(aa3);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Monitor_activity.this, Add_Item.class);
                startActivity(i);*/

                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();

                if (isInternetOn()) {
                    new Monitor_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(Monitor_activity.this, Add_Item.class);
                    startActivity(i1);
                }

            }
        });


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

                itemSpecification.setBrand(BrandS);
                itemSpecification.setPort(PortS);
                itemSpecification.setInches(InchesS);
                item.setItemSpecification(itemSpecification);
                return params[0].insert_item_details(item);
            }

            @Override
            protected void onPostExecute(JSONArray jsonArray) {
            }


        }











}
