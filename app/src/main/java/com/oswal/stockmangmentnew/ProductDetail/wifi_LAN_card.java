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
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TVProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_LanProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class wifi_LAN_card extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,companynamecat,MBPScat;
    String brandCatS,mbpsCatS;
   /* String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[] MBPSList = {"Select","150","300" };
*/

    DatabaseHelper db =null;
wifi_LanProfile wifiLanProfile= new wifi_LanProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> mbpsListArray = new ArrayList<String>();

    String model_number,model_category,model_serial_number,model_date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__lan_card);
        getSupportActionBar().setTitle("Wifi_LAN Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");

        Brandcat=(Spinner)findViewById(R.id.wifilan_spinner1);
        MBPScat=(Spinner)findViewById(R.id.wifilan_spinner3) ;


        db = new DatabaseHelper(this);
        if (db.getwifi_LanProfileCount() > 0) {
            wifiLanProfile = db.getAllwifi_LanProfileDetails();
            Toast.makeText(getApplicationContext(), "Wifi_Lan brand List " + wifiLanProfile.getBrandName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data Laptop Details", Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + wifiLanProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(wifiLanProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("WifiLanProfile_brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }

            JSONObject jsonmbpsList = new JSONObject(wifiLanProfile.getMbps().toString());
            JSONArray jArraymbpsList = jsonmbpsList.optJSONArray("WifiLanProfile_MbpsList");

            if (jArraymbpsList != null) {
                for (int i = 0; i < jArraymbpsList.length(); i++) {
           mbpsListArray.add(jArraymbpsList.getString(i));
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
                    case 3:   brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:   brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        MBPScat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1: mbpsCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2: mbpsCatS = adapterView.getItemAtPosition(i).toString();
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


        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mbpsListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        MBPScat.setAdapter(aa2);


        submit=(Button)findViewById(R.id.wifilan_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(wifi_LAN_card.this, Add_Item.class);
                i.putExtra("wifi_LAN_card_brandCat",brandCatS);
                i.putExtra("wifi_LAN_card_mbpsCat",mbpsCatS);
                startActivity(i);*/
                if (isInternetOn()) {
                    new wifi_LAN_card.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(wifi_LAN_card.this, Add_Item.class);
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
            itemSpecification.setMbps(mbpsCatS);



            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }
}
