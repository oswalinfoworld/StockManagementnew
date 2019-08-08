package com.example.stockmangmentnew.Services.Items;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.stockmangmentnew.LoginModule.sign_UP;
import com.example.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.example.stockmangmentnew.POJO.Item;
import com.example.stockmangmentnew.R;

import org.json.JSONArray;

public class Add_Item extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, model_number, serial_number, specification, supplier_name, mobile_number, storage_location;
    Spinner category;
    private String nameS, model_numberS, serial_numberS, specificationS, supplier_nameS, mobile_numberS, storage_locationS, categoryS;
    Button submit;
    private Item oneItem = new Item();
    String[] categoryList = {"Computer", "Laptop", "Printer", "Scanner", "UPS","Processor","Router","Wifi-Dongle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);
        name = (EditText) findViewById(R.id.itemnameEditText);
        model_number = (EditText) findViewById(R.id.modelnoEditText);
        serial_number = (EditText) findViewById(R.id.serialnoEditText);
        specification = (EditText) findViewById(R.id.specificationEditText);
        supplier_name = (EditText) findViewById(R.id.suppliernameEditText);
        mobile_number = (EditText) findViewById(R.id.mobilenoEditText);
        storage_location = (EditText) findViewById(R.id.storagelocationEditText);
        category = (Spinner) findViewById(R.id.category_spinner);
        category.setOnItemSelectedListener(this);
        submit = (Button) findViewById(R.id.submit_item);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneItem.setName(name.getText().toString().trim());
                oneItem.setModel_number(model_number.getText().toString().trim());
                oneItem.setCategory(categoryS);
                oneItem.setMobile_number(mobile_number.getText().toString().trim());
                oneItem.setSerial_number(serial_number.getText().toString().trim());
                oneItem.setSpecification(specification.getText().toString().trim());
                oneItem.setStorage_location(storage_location.getText().toString().trim());
                oneItem.setSupplier_name(supplier_name.getText().toString().trim());
                if (validateForm(oneItem) && isInternetOn()) {
                    new insertItemToOnlineDB().execute(new ApiConnector());
                }
            }


            private boolean validateForm(Item oneItem) {
                //Validation Code

                return true;

            }
        });

        //Creating the ArrayAdapter instance having the categoryList
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        categoryS = categoryList[position];
        Toast.makeText(getApplicationContext(), categoryList[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
            return params[0].insert_item_user(oneItem);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }
    }
}
