package com.oswal.stockmangmentnew.Services.Items;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.ProductDetail.Laptop_activity;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.ProductDetail.Cables_activity;
import com.oswal.stockmangmentnew.ProductDetail.GPS_activity;
import com.oswal.stockmangmentnew.ProductDetail.Keyboard_activity;
import com.oswal.stockmangmentnew.ProductDetail.Monitor_activity;
import com.oswal.stockmangmentnew.ProductDetail.Mouse_activity;
import com.oswal.stockmangmentnew.ProductDetail.Printer_activity;
import com.oswal.stockmangmentnew.ProductDetail.Processor;
import com.oswal.stockmangmentnew.ProductDetail.RAM_activity;
import com.oswal.stockmangmentnew.ProductDetail.Router_activity;
import com.oswal.stockmangmentnew.ProductDetail.Scanner_activity;
import com.oswal.stockmangmentnew.ProductDetail.Switches_activity;
import com.oswal.stockmangmentnew.ProductDetail.UPS_activity;
import com.oswal.stockmangmentnew.ProductDetail.Wifidongle_activity;
import com.oswal.stockmangmentnew.R;

import org.json.JSONArray;

public class Add_Item extends AppCompatActivity implements OnItemSelectedListener {

    EditText name, model_number, serial_number, supplier_name, mobile_number,quantity,date,dom;
    Spinner category;
    private String quantitys,dateS,domS,nameS, model_numberS, serial_numberS, specificationS, supplier_nameS, mobile_numberS, storage_locationS, categoryS;
    Button submit,generator;
    private Item oneItem = new Item();
    String[] categoryList = { "Select","Laptop","Monitor","Keyboard","Mouse", "Printer", "Scanner", "UPS","Processor","Router","Wifi-Dongle","RAM","Cables","GPS tracking Machine","Xerox-machin","Switch"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.itemnameEditText);
        model_number = (EditText) findViewById(R.id.modelnoEditText);
        serial_number = (EditText) findViewById(R.id.serialnoEditText);
        dom = (EditText) findViewById(R.id.additem_DOM);
        supplier_name = (EditText) findViewById(R.id.suppliernameEditText);
        mobile_number = (EditText) findViewById(R.id.mobilenoEditText);
        quantity = (EditText) findViewById(R.id.additem_quanET);
        date = (EditText) findViewById(R.id.additem_dateET);
        generator = (Button) findViewById(R.id.additem_genbtn);
        category = (Spinner) findViewById(R.id.category_spinner);
        category.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 Intent intent;
              switch (i)
              {
                  case 0:
                      break;
                  case 1:
                  intent = new Intent(Add_Item.this, Laptop_activity.class);
                      startActivity(intent);
                  break;
                  case 2:
                      intent = new Intent(Add_Item.this, Monitor_activity.class);
                      startActivity(intent);
                      break;
                  case 3:
                      intent = new Intent(Add_Item.this, Keyboard_activity.class);
                      startActivity(intent);
                      break;
                  case 4:
                      intent = new Intent(Add_Item.this, Mouse_activity.class);
                      startActivity(intent);
                      break;
                  case 5:
                      intent = new Intent(Add_Item.this, Printer_activity.class);
                      startActivity(intent);
                      break;
                  case 6:
                      intent = new Intent(Add_Item.this, Scanner_activity.class);
                      startActivity(intent);
                      break;
                  case 7:
                      intent = new Intent(Add_Item.this, UPS_activity.class);
                      startActivity(intent);
                      break;
                  case 8:
                      intent = new Intent(Add_Item.this, Processor.class);
                      startActivity(intent);
                      break;
                  case 9:
                      intent = new Intent(Add_Item.this, Router_activity.class);
                      startActivity(intent);
                      break;
                  case 10:
                      intent = new Intent(Add_Item.this, Wifidongle_activity.class);
                      startActivity(intent);
                      break;
                  case 11:
                      intent = new Intent(Add_Item.this, RAM_activity.class);
                      startActivity(intent);
                      break;
                  case 12:
                      intent = new Intent(Add_Item.this, Cables_activity.class);
                      startActivity(intent);
                      break;
                  case 13:
                      intent = new Intent(Add_Item.this, GPS_activity.class);
                      startActivity(intent);
                      break;
                  case 14:
                      intent = new Intent(Add_Item.this,com.oswal.stockmangmentnew.ProductDetail.xerox_activity.class);
                      startActivity(intent);
                      break;
                  case 15:
                      intent = new Intent(Add_Item.this, Switches_activity.class);
                      startActivity(intent);
                      break;
              }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submit = (Button) findViewById(R.id.submit_item);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneItem.setName(name.getText().toString().trim());
                oneItem.setModel_number(model_number.getText().toString().trim());

                oneItem.setCategory(categoryS);
                oneItem.setMobile_number(mobile_number.getText().toString().trim());
                oneItem.setSerial_number(serial_number.getText().toString().trim());
                oneItem.setDOM(dom.getText().toString().trim());
                oneItem.setQuantity(quantity.getText().toString().trim());

                oneItem.setSupplier_name(supplier_name.getText().toString().trim());
                if (validateForm(oneItem) && isInternetOn()) {
                    new insertItemToOnlineDB().execute(new ApiConnector());
                    Intent mainPage = new Intent(Add_Item.this, MainActivity.class);
                    startActivity(mainPage);
                }
            }


            private boolean validateForm(Item oneItem) {
                supplier_nameS=supplier_name.getText().toString().trim();
                mobile_numberS=mobile_number.getText().toString().trim();
                quantitys=quantity.getText().toString().trim();
                dateS=date.getText().toString().trim();
                if (supplier_nameS.length() == 0) {
                    supplier_name.setError("Username is not enter");
                    supplier_name.requestFocus();
                    return false;
                }
                if(mobile_numberS.length()!=10)
                {
                    mobile_number.setError("Enter valid mobile no.");
                    mobile_number.requestFocus();
                    return false;
                }
                if(quantitys.length()==0)
                {
                    quantity.setError("Enter quantity");
                    quantity.requestFocus();
                    return false;
                }
                if(dateS.length()==0)
                {
                    date.setError("Enter date");
                    date.requestFocus();
                    return false;
                }
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
        Toast.makeText(getApplicationContext(), categoryList[position], Toast.LENGTH_SHORT).show();
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
            return params[0].insert_item_details(oneItem);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }
    }

}
