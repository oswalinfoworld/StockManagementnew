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
import android.widget.Toast;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.SwitchProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.UPSProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class UPS_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,typecat,capacitycat;
    String brandCatS,typeCatS,capacityS;
    /*String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","Su-Kam","Genus Power","Microtek","Luminous","AmaraRaja"};
    String[] typeList = {"Select","Online","Offline" };
    String[] capacityList = {"Select","0.6KVA","0.650KVA" ,"1KVA","2KVA"};

*/
    String model_number,model_category,model_serial_number,model_date;

    DatabaseHelper db =null;
 UPSProfile upsProfile= new  UPSProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();
    ArrayList<String>capacityListArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ups_activity);
        getSupportActionBar().setTitle("UPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");

        Brandcat=(Spinner)findViewById(R.id.ups_spinner1);
        typecat=(Spinner)findViewById(R.id.ups_spinner3) ;
        capacitycat=(Spinner)findViewById(R.id.ups_spinner4) ;

        db = new DatabaseHelper(this);
        if (db.getUPSProfileCount() > 0) {
            upsProfile = db.getAllUPSProfileDetails();
            Toast.makeText(getApplicationContext(), "ups brand List " +  upsProfile.getBrandName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(), "Here" +  upsProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject( upsProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("UPSProfile_brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsontypeList = new JSONObject(upsProfile.getUpstype().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("UPSProfile_typeList");

            if (jArraytypeList != null) {
                for (int i = 0; i < jArraytypeList.length(); i++) {
                    typeListArray.add(jArraytypeList.getString(i));
                }
            }



            JSONObject jsoncapacityList = new JSONObject( upsProfile.getCapacityList().toString());
            JSONArray jArraycapacityList = jsoncapacityList.optJSONArray("UPSProfile_capacityList");

            if (jArraycapacityList != null) {
                for (int i = 0; i < jArraycapacityList.length(); i++) {
                capacityListArray.add(jArraycapacityList.getString(i));
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
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        typecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                       typeCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        typeCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
       capacitycat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                      capacityS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        capacityS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        capacityS = adapterView.getItemAtPosition(i).toString();

                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        capacityS = adapterView.getItemAtPosition(i).toString();

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



        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, capacityListArray);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        capacitycat.setAdapter(aa3);


        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeListArray);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        typecat.setAdapter(aa4);

        submit=(Button)findViewById(R.id.ups_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(UPS_activity.this, Add_Item.class);
                startActivity(i);*/

                if (isInternetOn()) {
                    new UPS_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(UPS_activity.this, Add_Item.class);
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

            itemSpecification.setBrand(brandCatS);
            itemSpecification.setType(typeCatS);
            itemSpecification.setCapacity(capacityS);


            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }
}
