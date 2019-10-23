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
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.PrinterProfile;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Printer_activity extends AppCompatActivity {
    CheckBox companyname1,companyname2,companyname3,companyname4,type1,type2,type3,type4;
    Button submit;
    Spinner Brandcat,companynamecat;
    String brandCatS;
    DatabaseHelper db =null;
    PrinterProfile printerProfile= new   PrinterProfile ();
    ArrayList<String> brandListArray = new ArrayList<String>();



    String model_number,model_category,model_serial_number,model_date;

    /*  String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","Canon","Samsung","HP","Brother" };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_activity);
        getSupportActionBar().setTitle("Printer Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");




        Brandcat=(Spinner)findViewById(R.id.printer_spinner1);

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
            JSONArray jArrayprinterList = jsonprinterList.optJSONArray("PrinterProfile_brandList");

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
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();


                        break;
                    case 2:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();



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
                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(Printer_activity.this, Add_Item.class);
                i.putExtra("Printer_activity_brandCat",brandCatS);

                startActivity(i);*/



                if (isInternetOn()) {
                    new Printer_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(Printer_activity.this, Add_Item.class);
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


            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }


}
