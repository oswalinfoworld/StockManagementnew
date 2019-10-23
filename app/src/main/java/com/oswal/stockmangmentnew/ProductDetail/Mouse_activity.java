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
import com.oswal.stockmangmentnew.OflineDBActivity.model.MonitorProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MouseProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;
import com.oswal.stockmangmentnew.Services.Return.Reject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mouse_activity extends AppCompatActivity {
    Button submit;
    Spinner Brandcat,Typecat;
    String itemUniqueID="itemUniqueID";
    String brandCatS,typeCatS;

    DatabaseHelper db =null;
    MouseProfile mouseProfile= new  MouseProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();

    String model_number,model_category,model_serial_number,model_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse_activity);
        getSupportActionBar().setTitle("Mouse Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");




        Brandcat=(Spinner)findViewById(R.id.mouse_spinner1);
        Typecat=(Spinner)findViewById(R.id.mouse_spinner2) ;

        db = new DatabaseHelper(this);
        if (db.getMouseProfileCount() > 0) {
            mouseProfile = db.getAllMouseProfileDetails();
            Toast.makeText(getApplicationContext(), " Mouse brand List " + mouseProfile.getBrandName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "I dont find any Data MOUSE Details", Toast.LENGTH_LONG).show();

        }


        try {
            Toast.makeText(getApplicationContext(), "Here" + mouseProfile.getBrandName(), Toast.LENGTH_LONG).show();
            JSONObject jsonbrandList = new JSONObject(mouseProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("MouseProfile_brandList");

            if (jArraybrandList != null) {
                for (int i = 0; i < jArraybrandList.length(); i++) {
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }
            Toast.makeText(getApplicationContext(), "Here" + mouseProfile.getTypeList(), Toast.LENGTH_LONG).show();

            JSONObject jsontypeList = new JSONObject(mouseProfile.getTypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("MouseProfile_typeList");

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
                switch(i){
                    case 0:

                        break;
                    case 1:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected"+brandCatS ,Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected"+brandCatS ,Toast.LENGTH_SHORT).show();

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
                switch(i){
                    case 0:
                        typeCatS = adapterView.getItemAtPosition(i).toString();
                        break;
                    case 1:
                        typeCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected"+typeCatS, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        typeCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected"+typeCatS, Toast.LENGTH_SHORT).show();
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


        submit=(Button)findViewById(R.id.mouse_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(Mouse_activity.this, Add_Item.class);
                i.putExtra("Mouse_activity_brandCat",brandCatS);
                i.putExtra("Mouse_activity_typeCat",typeCats);
                startActivity(i);*/

                if (isInternetOn()) {
                    new Mouse_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(Mouse_activity.this, Add_Item.class);
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

            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }






}
