package com.oswal.stockmangmentnew.Services.StockOut;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.oswal.stockmangmentnew.ProductDetail.Laptop_activity;
import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.StockOut;
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
import com.oswal.stockmangmentnew.Services.StockIn.Stock_in;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class stock_OUT extends AppCompatActivity {
    EditText CustomerID, billno, Cname, contact, add, companyname,availableq, openpg;
    public static String barCodeContentStockOut="";
    int counter=0;
    TextView pageNumber;
    Spinner category;
    String categoryS,CustomerIDString, dateString, billnoString, CnameString, contactString, addString,availableqString, openpgString,model_nostring;
    Button submit, open,date;
    String[] categoryList = {"Select", "Laptop", "Monitor", "Keyboard", "Mouse", "Printer", "Scanner", "UPS", "Processor", "Router", "Wifi-Dongle", "RAM", "Cables", "GPS tracking Machine", "Xerox-machin", "Switch"};


    List<StockOut> stockOutList = new ArrayList<>();
    StockOut stockOut = new StockOut();
    boolean addMultipleStock = false;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock__out);
        getSupportActionBar().setTitle("Stock Out");



        date = (Button) findViewById(R.id.stockout_dateET);
        billno = (EditText) findViewById(R.id.stockout_billnoET);
        CustomerID = (EditText) findViewById(R.id.stockout_uniqIdET);
        Cname = (EditText) findViewById(R.id.stockout_CnameET);
        contact = (EditText) findViewById(R.id.stockout_conoET);
        add = (EditText) findViewById(R.id.stockout_addessET);
        availableq = (EditText) findViewById(R.id.stockout_avilQET);
        openpg = (EditText) findViewById(R.id.stockout_opnET);
        pageNumber=(TextView)findViewById(R.id.stockout_pageNumber);

        submit = (Button) findViewById(R.id.stockout_submitbtn);
        open = (Button) findViewById(R.id.stockout_opnbtn);
       /* category = (Spinner) findViewById(R.id.stockout_spinner);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                Intent intent;
                switch (i)
                {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(stock_OUT.this, Laptop_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(stock_OUT.this, Monitor_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(stock_OUT.this, Keyboard_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(stock_OUT.this, Mouse_activity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(stock_OUT.this, Printer_activity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(stock_OUT.this, Scanner_activity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(stock_OUT.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(stock_OUT.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(stock_OUT.this, Router_activity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(stock_OUT.this, Wifidongle_activity.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(stock_OUT.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(stock_OUT.this, Cables_activity.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(stock_OUT.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(stock_OUT.this,com.oswal.stockmangmentnew.ProductDetail.xerox_activity.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(stock_OUT.this, Switches_activity.class);
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
        category.setAdapter(aa);*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addMultipleStock) {
                    stockOut = getStockOutFormData();
                    if (emptyvalidate(stockOut)) {
                        //insert value to Online DB
                        new insertStockOutToOnlineDB().execute(new ApiConnector());
                          Intent intent = new Intent(stock_OUT.this, MainActivity.class);
                         startActivity(intent);
                    }
                } else {
                    new insertStockOutToOnlineDB().execute(new ApiConnector());
                      Intent intent = new Intent(stock_OUT.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear, mMonth, mDay;
                DatePicker datePicker;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(stock_OUT.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    private boolean emptyvalidate(StockOut passData) {

        if (passData.getDate().length() == 0) {
            date.setError("Enter Date");
            date.requestFocus();
            return false;
        }
        if (passData.getBill_number().length() == 0) {
            billno.setError("Enter Bill no");
            billno.requestFocus();
            return false;
        }
        if (passData.getCustomer_id().length() == 0) {
            CustomerID.setError("Enter Customer ID");
            CustomerID.requestFocus();
            return false;
        }
        if (passData.getCustomer_name().length() == 0) {
            Cname.setError("Enter Customer name");
            Cname.requestFocus();
            return false;
        }
        if (passData.getContact_number().length() != 10) {
            contact.setError("Enter vaild Contact no");
            contact.requestFocus();
            return false;

        }

        if (passData.getAddress().length() == 0) {
            add.setError("Enter Address");
            add.requestFocus();
            return false;
        }

        if (barCodeContentStockOut.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Scan Barcode !!! ",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    public void addstockOut(View v) {
        pageCounter();
         addMultipleStock = true;
        //add StockIn Page
        this.stockOut = getStockOutFormData();
        if (emptyvalidate(this.stockOut)) {
            this.stockOut = getStockOutFormData();
            String openPage = openpg.getText().toString().trim();
            if (openPage.length() != 0) {
                int insertDataAt = Integer.parseInt(openpg.getText().toString().trim());
                stockOutList.add(insertDataAt - 1, stockOut);
            } else {
                stockOutList.add(stockOut);
            }
            resetStockOutFormData();
        }
    }
    public void openStockInPage(View v) {
        //Load value on form as per number
        int openPage = Integer.parseInt(openpg.getText().toString().trim());
        Toast.makeText(getApplicationContext(), "Open Page " + openPage, Toast.LENGTH_SHORT).show();
        setStockOutFormData(openPage);
    }


    private StockOut getStockOutFormData() {
        StockOut stockOut = new StockOut();
        CustomerIDString = CustomerID.getText().toString().trim();
        dateString = date.getText().toString().trim();
        billnoString = billno.getText().toString().trim();
        CnameString = Cname.getText().toString().trim();
        contactString = contact.getText().toString().trim();
        addString = add.getText().toString().trim();
        availableqString = availableq.getText().toString().trim();
        openpgString = openpg.getText().toString().trim();

        stockOut.setCustomer_id(CustomerIDString);
        stockOut.setDate(dateString);
        stockOut.setBill_number(billnoString);
        stockOut.setCustomer_name(CnameString);
        stockOut.setContact_number(contactString);
        stockOut.setAddress(addString);
        stockOut.setQuantity(availableqString);
        stockOut.setItemuniqid(barCodeContentStockOut);
        return stockOut;
    }
    private void setStockOutFormData(int listNumber) {
        StockOut stockOut = stockOutList.get(listNumber - 1);
        CustomerID.setText(stockOut.getCustomer_id());
        date.setText(stockOut.getDate());
        billno.setText(stockOut.getBill_number());
        Cname.setText(stockOut.getCustomer_name());
        contact.setText(stockOut.getContact_number());
        add.setText(stockOut.getAddress());
        availableq.setText(stockOut.getQuantity());

    }
    public void resetStockOutFormData() {

        CustomerID.setText("");
        date.setText("");
        billno.setText("");
        Cname.setText("");
        contact.setText("");
        add.setText("");

        availableq.setText("");
        openpg.setText("");
       Toast.makeText(getApplicationContext(), "Record submitted successfully" , Toast.LENGTH_SHORT).show();
    }

    private void pageCounter() {
        String pageNumberString=pageNumber.getText().toString().trim().split(":")[1];
        int pageno= Integer.parseInt(pageNumberString);
        pageNumber.setText("Page :"+(pageno+1));
    }


    private class insertStockOutToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            if(addMultipleStock){
                return params[0].insert_stockOut_Record_list(stockOutList);
            }else {
                return params[0].insert_stockOut_Record(stockOut);
            }
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {


        }

    }

    //scanBar CODE
    public void scanBar(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            intent.putExtra("SCAN_FORMATS", "CODE_128");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(stock_OUT.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                barCodeContentStockOut=contents;
                Toast toast = Toast.makeText(this, "Item Id : " + contents  , Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
