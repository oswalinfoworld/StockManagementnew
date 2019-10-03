package com.oswal.stockmangmentnew.Services.Items;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
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

import java.util.ArrayList;
import java.util.Calendar;

public class Add_Item extends AppCompatActivity implements OnItemSelectedListener {

    EditText model_number, serial_number,  quantity;
    Spinner category;

    private String quantitys, dateS, nameS, model_numberS, serial_numberS, categoryS;
    Button submit, date;
    private Item oneItem = new Item();
    String[] categoryList = {"Select", "Laptop", "Monitor", "Keyboard", "Mouse", "Printer", "Scanner",
            "UPS", "CPU", "Router", "Wifi_Dongle", "RAM", "Cables", "GPS_trackingMachine", "Xerox-_machin",
            "Switch","Tablet","TV","Wifi_LAN_card"};
    /*ArrayList<String> categoryList= new ArrayList<String>();
    /*ArrayList<String> categoryList= new ArrayList<String>();
    ArrayList<String> MonitorArray = new ArrayList<String>();
    ArrayList<String> KeyboardArray = new ArrayList<String>();
    ArrayList<String> MouseArray = new ArrayList<String>();
    ArrayList<String> PrinterArray = new ArrayList<String>();
    ArrayList<String> ScannerArray = new ArrayList<String>();
    ArrayList<String> UPSArray = new ArrayList<String>();
    ArrayList<String> CPUArray = new ArrayList<String>();
    ArrayList<String> RouterArray = new ArrayList<String>();
    ArrayList<String> Wifi_DongleArray = new ArrayList<String>();
    ArrayList<String> RAMArray = new ArrayList<String>();
    ArrayList<String> CablesArray = new ArrayList<String>();
    ArrayList<String> GPS_trackingMachineArray = new ArrayList<String>();
    ArrayList<String> Xerox_machinArray = new ArrayList<String>();
    ArrayList<String>SwitchArray = new ArrayList<String>();
    ArrayList<String>TabletArray = new ArrayList<String>();
    ArrayList<String>TVArray = new ArrayList<String>();
    ArrayList<String>Wifi_LAN_cardArray = new ArrayList<String>();*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        model_number = (EditText) findViewById(R.id.modelnoEditText);
        serial_number = (EditText) findViewById(R.id.serialnoEditText);

      /*  quantity = (EditText) findViewById(R.id.additem_quanET);*/
        date = (Button) findViewById(R.id.additem_dateET);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear, mMonth, mDay;
                DatePicker datePicker;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Add_Item.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        category = (Spinner) findViewById(R.id.category_spinner);
        category.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;
                switch (i) {
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
                        intent = new Intent(Add_Item.this, com.oswal.stockmangmentnew.ProductDetail.xerox_activity.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(Add_Item.this, Switches_activity.class);
                        startActivity(intent);
                        break;

                    case 16:
                        intent = new Intent(Add_Item.this, com.oswal.stockmangmentnew.ProductDetail.tablet_activity.class);
                        startActivity(intent);
                        break;

                    case 17:
                        intent = new Intent(Add_Item.this, com.oswal.stockmangmentnew.ProductDetail.tv_activity.class);
                        startActivity(intent);
                        break;

                    case 18:
                        intent = new Intent(Add_Item.this, com.oswal.stockmangmentnew.ProductDetail.wifi_LAN_card.class);
                        startActivity(intent);
                        break;
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa);

       /* ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, MonitorArray);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, KeyboardArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, MouseArray);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa3);

        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,PrinterArray );
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa4);

        ArrayAdapter aa5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ScannerArray );
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa5);

        ArrayAdapter aa6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,UPSArray );
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa6);

        ArrayAdapter aa7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,CPUArray );
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa);

        ArrayAdapter aa8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, RouterArray );
        aa8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa8);

        ArrayAdapter aa9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Wifi_DongleArray );
        aa9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa9);

        ArrayAdapter aa10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, RAMArray);
        aa10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa10);

        ArrayAdapter aa11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,CablesArray)  ;
        aa11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa11);

        ArrayAdapter aa12 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,GPS_trackingMachineArray );
        aa12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa12);

        ArrayAdapter aa13 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Xerox_machinArray );
        aa13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa13);

        ArrayAdapter aa14 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,TVArray );
        aa14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa14);

        ArrayAdapter aa15 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,SwitchArray );
        aa15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa15);

        ArrayAdapter aa16 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,TabletArray );
        aa16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa16);

        ArrayAdapter aa17 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Wifi_LAN_cardArray);
        aa17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa17);
*/

        submit = (Button) findViewById(R.id.submit_item);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oneItem.setModel_number(model_number.getText().toString().trim());
                oneItem.setCategory(categoryS);

                oneItem.setSerial_number(serial_number.getText().toString().trim());
              /*  oneItem.setDOM(dom.getText().toString().trim());
                oneItem.setQuantity(quantity.getText().toString().trim());*/
                oneItem.setDate(date.getText().toString().trim());

                if (validateForm(oneItem) && isInternetOn()) {
                    new insertItemToOnlineDB().execute(new ApiConnector());
                    Intent mainPage = new Intent(Add_Item.this, MainActivity.class);
                    startActivity(mainPage);
                }
                resetData();
            }

            private void resetData() {

                model_number.setText("");
                serial_number.setText("");
                //dom.setText("");
                date.setText("");
//                quantity.setText("");

            }


            private boolean validateForm(Item oneItem) {
                model_numberS = oneItem.getModel_number().toString().trim();
                serial_numberS = oneItem.getSerial_number().toString().trim();
                dateS = oneItem.getDate().toString().trim();
              /*  domS = dom.getText().toString().trim();

                quantitys = quantity.getText().toString().trim();*/

                if (model_numberS.length() == 0) {
                    model_number.setError("Enter model no");
                    model_number.requestFocus();
                    return false;
                }
                if (serial_numberS.length() == 0) {
                    serial_number.setError("Enter serial no");
                    serial_number.requestFocus();
                    return false;
                }
                /*if (domS.length() == 0) {
                    dom.setError("Enter DOM no");
                    dom.requestFocus();
                    return false;
                }


                if (quantitys.length() == 0) {
                    quantity.setError("Enter quantity");
                    quantity.requestFocus();
                    return false;
                }*/
                if (dateS.length() == 0) {
                    date.setError("Enter date");
                    date.requestFocus();
                    return false;
                }
                //Validation Code
                return true;

            }
        });



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
            return params[0].insert_item_details(oneItem);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }
    }


}
