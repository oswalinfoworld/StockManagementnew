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
import com.oswal.stockmangmentnew.POJO.ItemSpecification;
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

    String mouse_activity_brandCat="NOT_SET";
    String mouse_activity_typeCat="NOT_SET";

    String Laptop_activity_breandCat="NOT_SET";
    String Laptop_activity_typeCat="NOT_SET";
    String  Laptop_activity_generationCat="NOT_SET";
    String  Laptop_activity_ramCat="NOT_SET";
    String Laptop_activity_inchesCat="NOT_SET";
    String  Laptop_activity_HDDCat="NOT_SET";
    String   Laptop_activity_SHDDCat="NOT_SET";
    String   Laptop_activity_OSCat="NOT_SET";
    String   Laptop_activity_graphiccardCat="NOT_SET";
    String  Laptop_acDDtivity_DVDCat="NOT_SET";

    String  Printer_acDDtivity_brandcat="NOT_SET";

    String Scanner_acDDtivity_brandcat="NOT_SET";
    String Scanner_acDDtivity_typecat="NOT_SET";

    String CPU_activity_brandCat="NOT_SET";
    String CPU_activity_typeCat="NOT_SET";
    String  CPU_activity_generationCat="NOT_SET";
    String  CPU_activity_ramCat="NOT_SET";
    String  CPU_activity_HDDCat="NOT_SET";
    String   CPU_activity_SHDDCat="NOT_SET";
    String  CPU_activity_OSCat="NOT_SET";
    String  CPU_activity_graphiccardCat="NOT_SET";
    String  CPU_activity_DVDCat="NOT_SET";

    String Router_activity_brandcat="NOT_SET";
    String Router_activity_typecat="NOT_SET";
    String Router_activity_portcat="NOT_SET";
    String Router_activity_mbpscat="NOT_SET";

    String wifidongle_activity_brandcat="NOT_SET";
    String wifidongle_activity_typecat="NOT_SET";


    String RAM_activity_brandcat="NOT_SET";
    String RAM_activity_typecat="NOT_SET";
    String RAM_activity_gbcat="NOT_SET";

    String Cables_activity_brandcat="NOT_SET";

    String GPS_activity_brandcat="NOT_SET";

    String xerox_activity_brandcat="NOT_SET";
    String xerox_activity_ppmcat="NOT_SET";


    String Switches_activity_brandcat="NOT_SET";
    String Switches_activity_typecat="NOT_SET";
    String Switches_activity_portcat="NOT_SET";

    String tablet_activity_brandcat="NOT_SET";
    String tablet_activity_inchescat="NOT_SET";

    String tv_activity_brandcat="NOT_SET";
    String tv_activity_inchescat="NOT_SET";

    String wifi_Lan_activity_brandcat="NOT_SET";
    String wifi_Lan_activity_mbpscat="NOT_SET";




    String categorySelected;
    /*ArrayList<String> ADD_itemList= new ArrayList<String>();*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //step1
        mouse_activity_brandCat=  getIntent().getStringExtra("Mouse_activity_brandCat");
        mouse_activity_typeCat=  getIntent().getStringExtra("Mouse_activity_typeCats");

        Laptop_activity_breandCat=  getIntent().getStringExtra("Laptop_activity_breandCat");
        Laptop_activity_typeCat=  getIntent().getStringExtra("Laptop_activity_typeCat");
        Laptop_activity_generationCat=  getIntent().getStringExtra("Laptop_activity_generationCat");
        Laptop_activity_ramCat=  getIntent().getStringExtra("Laptop_activity_ramCat");
        Laptop_activity_inchesCat=  getIntent().getStringExtra("Laptop_activity_inchesCat");
        Laptop_activity_HDDCat=  getIntent().getStringExtra("Laptop_activity_HDDCat");
        Laptop_activity_SHDDCat=  getIntent().getStringExtra("Laptop_activity_SHDDCat");
        Laptop_activity_OSCat=  getIntent().getStringExtra("Laptop_activity_OSCat");
        Laptop_activity_graphiccardCat=  getIntent().getStringExtra("Laptop_activity_graphiccardCat");
        Laptop_acDDtivity_DVDCat=  getIntent().getStringExtra("Laptop_acDDtivity_DVDCat");

        Printer_acDDtivity_brandcat=  getIntent().getStringExtra("Printer_activity_brandCat");

        Scanner_acDDtivity_brandcat=  getIntent().getStringExtra("Scanner_activity_brandCat");
        Scanner_acDDtivity_typecat=  getIntent().getStringExtra("Scanner_activity_typeCat");

        CPU_activity_brandCat=  getIntent().getStringExtra("CPU_activity_breandCat");
        CPU_activity_typeCat=  getIntent().getStringExtra("CPU_activity_typeCat");
        CPU_activity_generationCat=  getIntent().getStringExtra("CPU_activity_generationCat");
        CPU_activity_ramCat=  getIntent().getStringExtra("CPU_activity_ramCat");
        CPU_activity_HDDCat=  getIntent().getStringExtra("CPU_activity_HDDCat");
        CPU_activity_SHDDCat=  getIntent().getStringExtra("CPU_activity_SHDDCat");
        CPU_activity_OSCat=  getIntent().getStringExtra("CPU_activity_OSCat");
        CPU_activity_graphiccardCat=  getIntent().getStringExtra("CPU_activity_graphiccardCat");
        CPU_activity_DVDCat=  getIntent().getStringExtra("CPU_acDDtivity_DVDCat");

        Router_activity_brandcat=  getIntent().getStringExtra("Router_activity_brandCat");
       Router_activity_typecat=  getIntent().getStringExtra("Router_activity_typeCat");
       Router_activity_portcat=  getIntent().getStringExtra("Router_activity_typeCat");
       Router_activity_mbpscat=  getIntent().getStringExtra("Router_activity_typeCat");

        wifidongle_activity_brandcat=  getIntent().getStringExtra("wifidongle_activity_brandCat");
        wifidongle_activity_typecat=  getIntent().getStringExtra("wifidongle_activity_typeCats");

        RAM_activity_brandcat=  getIntent().getStringExtra("RAM_activity_breandCat");
        RAM_activity_typecat=  getIntent().getStringExtra("RAM_activity_typeCat");
        RAM_activity_gbcat=  getIntent().getStringExtra("RAM_activity_GB");

        Cables_activity_brandcat=  getIntent().getStringExtra("Cables_activity_GB");

       GPS_activity_brandcat=  getIntent().getStringExtra("GPS_activity_brandCat");

        xerox_activity_brandcat=  getIntent().getStringExtra("Xerox_activity_brandCat");
        xerox_activity_ppmcat=  getIntent().getStringExtra("Xerox_activity_ppmCats");

         Switches_activity_brandcat=  getIntent().getStringExtra("Switches_activity_brandCat");
        Switches_activity_typecat=  getIntent().getStringExtra("Switches_activity_typeCat");
       Switches_activity_portcat=  getIntent().getStringExtra("Switches_activity_portCat");

        tablet_activity_brandcat=  getIntent().getStringExtra("Tablet_activity_brandCat");
        tablet_activity_inchescat=  getIntent().getStringExtra("tablet_activity_inchesCat");

        tv_activity_brandcat=  getIntent().getStringExtra("Tv_activity_brandCat");
        tv_activity_inchescat=  getIntent().getStringExtra("Tv_activity_inchesCat");

        wifi_Lan_activity_brandcat=  getIntent().getStringExtra("wifi_activity_brandCat");
        wifi_Lan_activity_mbpscat=  getIntent().getStringExtra("wifi_activity_mbpsCat");




        Toast.makeText(getApplicationContext(),"from Mouse Activity "+mouse_activity_brandCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Mouse Activity "+mouse_activity_typeCat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_breandCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_typeCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_generationCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_ramCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_inchesCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_HDDCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_SHDDCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_OSCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_activity_graphiccardCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Laptop Activity "+Laptop_acDDtivity_DVDCat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Printer Activity "+Printer_acDDtivity_brandcat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Scanner Activity "+Scanner_acDDtivity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Scanner Activity "+Scanner_acDDtivity_typecat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_brandCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_typeCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_generationCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_ramCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_HDDCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_SHDDCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_OSCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_graphiccardCat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from CPU Activity "+CPU_activity_DVDCat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Router Activity "+Router_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Router Activity "+Router_activity_typecat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Router Activity "+Router_activity_portcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Router Activity "+Router_activity_mbpscat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from wifidongle Activity "+wifidongle_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from wifidongle Activity "+wifidongle_activity_typecat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from RAM Activity "+RAM_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from RAM Activity "+RAM_activity_typecat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from RAM Activity "+RAM_activity_gbcat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Cables Activity "+Cables_activity_brandcat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from GPS Activity "+GPS_activity_brandcat,Toast.LENGTH_LONG).show();


        Toast.makeText(getApplicationContext(),"from xerox Activity "+xerox_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from xerox Activity "+xerox_activity_ppmcat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Switches Activity "+Switches_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Switches Activity "+Switches_activity_typecat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Switches Activity "+Switches_activity_portcat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Tablet Activity "+tablet_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Tablet Activity "+tablet_activity_inchescat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from Tv Activity "+tv_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from Tv Activity "+tv_activity_inchescat,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),"from wifi_Lan Activity "+ wifi_Lan_activity_brandcat,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"from wifi_Lan Activity "+wifi_Lan_activity_mbpscat,Toast.LENGTH_LONG).show();





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
                categorySelected=categoryList[i];
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

       /* ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ADD_itemList);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa1);

*/

        submit = (Button) findViewById(R.id.submit_item);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oneItem.setModel_number(model_number.getText().toString().trim());
                oneItem.setCategory(categoryS);

                oneItem.setSerial_number(serial_number.getText().toString().trim());

                oneItem.setDate(date.getText().toString().trim());
                oneItem.setCategory(categoryS);
                ItemSpecification itemSpecification= new ItemSpecification();

                //step 2
                itemSpecification.setMouse_activity_brandCat(mouse_activity_brandCat);
                itemSpecification.setMouse_activity_typeCat(mouse_activity_typeCat);

                itemSpecification.setLaptop_activity_breandCat(Laptop_activity_breandCat);
                itemSpecification.setLaptop_activity_typeCat(Laptop_activity_typeCat);
                itemSpecification.setLaptop_activity_generationCat(Laptop_activity_generationCat);
                itemSpecification.setLaptop_activity_ramCat( Laptop_activity_ramCat);
                itemSpecification.setLaptop_activity_inchesCat(Laptop_activity_inchesCat);
                itemSpecification.setLaptop_activity_HDDCat(Laptop_activity_HDDCat);
                itemSpecification.setLaptop_activity_SHDDCat(Laptop_activity_SHDDCat);
                itemSpecification.setLaptop_activity_OSCat(Laptop_activity_OSCat);
                itemSpecification.setLaptop_activity_graphiccardCat(Laptop_activity_graphiccardCat);
                itemSpecification.setLaptop_acDDtivity_DVDCat(Laptop_acDDtivity_DVDCat);

                itemSpecification.setPrinter_activity_brandcat( Printer_acDDtivity_brandcat);
                itemSpecification.setRouter_activity_brandcat(Router_activity_brandcat);
                itemSpecification.setRouter_activity_mbpscat(Router_activity_mbpscat);
                itemSpecification.setRouter_activity_portcat(Router_activity_portcat);
                itemSpecification.setRouter_activity_typecat(Router_activity_typecat);

                itemSpecification.setScanner_acDDtivity_brandcat(Scanner_acDDtivity_brandcat);
                itemSpecification.setScanner_acDDtivity_typecat(Scanner_acDDtivity_typecat);

                itemSpecification.setCables_activity_brandcat( Cables_activity_brandcat);

                itemSpecification.setWifi_Lan_activity_brandcat(wifi_Lan_activity_brandcat);
                itemSpecification.setWifi_Lan_activity_mbpscat(wifi_Lan_activity_mbpscat);

                itemSpecification.setWifidongle_activity_brandcat(wifidongle_activity_brandcat);
                itemSpecification.setWifidongle_activity_typecat( wifidongle_activity_typecat);

                itemSpecification.setCPU_activity_breandCat(CPU_activity_brandCat);
                itemSpecification.setCPU_activity_typeCat(CPU_activity_typeCat);
                itemSpecification.setCPU_activity_generationCat(CPU_activity_generationCat);
                itemSpecification.setCPU_activity_ramCat( CPU_activity_ramCat);
                itemSpecification.setCPU_activity_HDDCat(CPU_activity_HDDCat);
                itemSpecification.setCPU_activity_SHDDCat(CPU_activity_SHDDCat);
                itemSpecification.setCPU_activity_OSCat(CPU_activity_OSCat);
                itemSpecification.setCPU_activity_graphiccardCat(CPU_activity_graphiccardCat);
                itemSpecification.setCPU_acDDtivity_DVDCat(CPU_activity_DVDCat);

                itemSpecification.setRAM_activity_brandcat(RAM_activity_brandcat);
                itemSpecification.setRAM_activity_typecat(RAM_activity_typecat);
                itemSpecification.setRAM_activity_gbcat( RAM_activity_gbcat);

                itemSpecification.setXerox_activity_brandcat(xerox_activity_brandcat);
                itemSpecification.setXerox_activity_ppmcat(xerox_activity_ppmcat);

                itemSpecification.setSwitches_activity_brandcat(Switches_activity_brandcat);
                itemSpecification.setSwitches_activity_typecat(Switches_activity_typecat);
                itemSpecification.setSwitches_activity_portcat(Switches_activity_portcat);

                itemSpecification.setGPS_activity_brandcat(GPS_activity_brandcat);

                itemSpecification.setTablet_activity_brandcat(tablet_activity_brandcat);
                itemSpecification.setTablet_activity_inchescat(tablet_activity_inchescat);

                itemSpecification.setTv_activity_brandcat(tv_activity_brandcat);
                itemSpecification.setTv_activity_inchescat(tv_activity_inchescat);


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
