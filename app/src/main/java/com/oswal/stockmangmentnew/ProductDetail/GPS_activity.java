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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.LoginModule.ForgetPassword;
import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GPS_activity extends AppCompatActivity {
    EditText simname,simrecharge,simvalidity;
    Button submit;
    Spinner Brandcat,companynamecat;
    String brandCatS,simName="NOT_SET",simRecharge="NOT_SET",simValidity="NOT_SET";
   // String[] brandList = {"Select","HP","DEll" };
    //String[] companyList = {"Select","HP","DELL" };

    DatabaseHelper db =null;
    GPSProfile gpsProfile= new   GPSProfile ();
    ArrayList<String> brandListArray = new ArrayList<String>();

    String model_number,model_category,model_serial_number,model_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_activity);
        getSupportActionBar().setTitle("GPS Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        simname=(EditText)findViewById(R.id.gps_simname);
        simrecharge=(EditText)findViewById(R.id.gps_recharge);
        simvalidity=(EditText)findViewById(R.id.gps_validity);
        submit=(Button)findViewById(R.id.gps_subbtn1);
        Brandcat=(Spinner)findViewById(R.id.gps_spinner1) ;


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
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("GPSProfile_brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //step1
        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");

        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){

                    case 0:

                        break;
                    case 1:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(GPS_activity.this, GPS_activity.class);
                        startActivity(intent);
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



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(GPS_activity.this, Add_Item.class);
                i.putExtra("GPS_activity_brandCat",brandCatS);
                startActivity(i);*/
                if (isInternetOn()) {
                    new GPS_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(GPS_activity.this, Add_Item.class);
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
            itemSpecification.setSim_name(simName);
            itemSpecification.setSim_recharge(simRecharge);
            itemSpecification.setSim_validity(simValidity);
            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }
}
