package com.oswal.stockmangmentnew.Services.StockIn;

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
import android.widget.Toast;

import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.ProductDetail.Laptop_activity;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.StockIn;
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
import java.util.List;

public class Stock_in extends AppCompatActivity {
    EditText supplierID, date, billno, sname, contact, add, companyname, availableq, openpg, storageloc, model_no;
    Spinner category;
    String categoryS, supplierIDString, dateString, billnoString, snameString, contactString, addString, itemnameString, availableqString, model_noString, storagelocString;
    Button submit, open, scan;
    String[] categoryList = {"Select", "Laptop", "Monitor", "Keyboard", "Mouse", "Printer", "Scanner", "UPS", "Processor", "Router", "Wifi-Dongle", "RAM", "Cables", "GPS tracking Machine", "Xerox-machin", "Switch"};

    List<StockIn> stockInList = new ArrayList<>();
    StockIn stockIn = new StockIn();
    boolean addMultipleStock = false;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_in);
        getSupportActionBar().setTitle("Stock IN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname = (EditText) findViewById(R.id.additem_nameET);
        model_no = (EditText) findViewById(R.id.additem_modelnoET);
        storageloc = (EditText) findViewById(R.id.additem_storageLocaET);
        date = (EditText) findViewById(R.id.additem_dateET);
        billno = (EditText) findViewById(R.id.additem_billnoET);
        supplierID = (EditText) findViewById(R.id.additem_suppID);
        sname = (EditText) findViewById(R.id.additem_snameET);
        contact = (EditText) findViewById(R.id.additem_conoET);
        add = (EditText) findViewById(R.id.additem_addET);
        availableq = (EditText) findViewById(R.id.additem_availbleET);
        openpg = (EditText) findViewById(R.id.additem_opnpgET);

        submit = (Button) findViewById(R.id.add_item_Submitbtn);
        open = (Button) findViewById(R.id.additem_opnbtn);
        scan = (Button) findViewById(R.id.add_item_scanbtn);
        category = (Spinner) findViewById(R.id.stockin_spinner);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Stock_in.this, Laptop_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Stock_in.this, Monitor_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Stock_in.this, Keyboard_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Stock_in.this, Mouse_activity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Stock_in.this, Printer_activity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Stock_in.this, Scanner_activity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(Stock_in.this, UPS_activity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(Stock_in.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(Stock_in.this, Router_activity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(Stock_in.this, Wifidongle_activity.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(Stock_in.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(Stock_in.this, Cables_activity.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(Stock_in.this, GPS_activity.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(Stock_in.this, com.oswal.stockmangmentnew.ProductDetail.xerox_activity.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(Stock_in.this, Switches_activity.class);
                        startActivity(intent);
                        break;


                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addMultipleStock) {
                    stockIn = getStockInFormData();
                    if (emptyvalidate(stockIn)) {
                        //insert value to Online DB
                        new insertStockInToOnlineDB().execute(new ApiConnector());
                        goToMainActivity();
                    }
                } else {
                    new insertStockInToOnlineDB().execute(new ApiConnector());
                    goToMainActivity();
                }
                //Intent intent = new Intent(Stock_in.this, MainActivity.class);
                // startActivity(intent);
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(Stock_in.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(aa);

    }

    private void goToMainActivity() {
        Intent mainActivity = new Intent(Stock_in.this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        categoryS = categoryList[position];
        Toast.makeText(getApplicationContext(), categoryList[position], Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean emptyvalidate(StockIn passData) {
        if (passData.getItemName().length() == 0) {
            companyname.setError("Enter  name");
            companyname.requestFocus();
            return false;

        }


        if (passData.getSupplierID().length() == 0) {
            supplierID.setError("Enter Supplier ID");
            supplierID.requestFocus();
            return false;

        }
        if (passData.getDate().length() == 0) {
            date.setError("Enter valid Date");
            date.requestFocus();
            return false;

        }
        if (passData.getBillNumber().length() == 0) {
            billno.setError("Enter Bill no");
            billno.requestFocus();
            return false;

        }
        if (storagelocString.length() == 0) {
            storageloc.setError("Enter storage location");
            storageloc.requestFocus();
            return false;

        }
        if (passData.getSupplierName().length() == 0) {
            sname.setError("Enter Supplier name");
            sname.requestFocus();
            return false;

        }
        if (passData.getContactNumber().length() != 10) {
            contact.setError("Enter vaild Contact no");
            contact.requestFocus();
            return false;

        }
        if (passData.getAddress().length() == 0) {
            add.setError("Enter Address");
            add.requestFocus();
            return false;
        }
        return true;
    }

    public void addStockIn(View v) {
        addMultipleStock = true;
        //add StockIn Page
        this.stockIn = getStockInFormData();
        if (emptyvalidate(this.stockIn)) {
            this.stockIn = getStockInFormData();
            String openPage = openpg.getText().toString().trim();
            if (openPage.length() != 0) {
                int insertDataAt = Integer.parseInt(openpg.getText().toString().trim());
                stockInList.add(insertDataAt - 1, stockIn);
            } else {
                stockInList.add(stockIn);
            }
            resetStockInFormData();
        }
    }

    public void openStockInPage(View v) {
        //Load value on form as per number
        int openPage = Integer.parseInt(openpg.getText().toString().trim());
        Toast.makeText(getApplicationContext(), "Open Page " + openPage, Toast.LENGTH_SHORT).show();
        setStockInFormData(openPage);
    }

    private StockIn getStockInFormData() {
        StockIn stockIn = new StockIn();
        supplierIDString = supplierID.getText().toString().trim();
        model_noString = model_no.getText().toString().trim();
        dateString = date.getText().toString().trim();
        billnoString = billno.getText().toString().trim();
        snameString = sname.getText().toString().trim();
        contactString = contact.getText().toString().trim();
        addString = add.getText().toString().trim();
        itemnameString = companyname.getText().toString().trim();
        availableqString = availableq.getText().toString().trim();
        storagelocString = storageloc.getText().toString().trim();

        stockIn.setSupplierID(supplierIDString);
        stockIn.setDate(dateString);
        stockIn.setBillNumber(billnoString);
        stockIn.setSupplierName(snameString);
        stockIn.setContactNumber(contactString);
        stockIn.setAddress(addString);
        stockIn.setModelNumber(model_noString);
        stockIn.setStorageLocation(storagelocString);
        stockIn.setItemName(itemnameString);
        stockIn.setAvailableQuantity(availableqString);

        return stockIn;
    }

    private void setStockInFormData(int listNumber) {
        StockIn stockIn = stockInList.get(listNumber - 1);
        supplierID.setText(stockIn.getSupplierID());
        date.setText(stockIn.getDate());

        billno.setText(stockIn.getBillNumber());
        sname.setText(stockIn.getSupplierName());
        contact.setText(stockIn.getContactNumber());
        add.setText(stockIn.getAddress());
        companyname.setText(stockIn.getItemName());
        availableq.setText(stockIn.getAvailableQuantity());
        model_no.setText(stockIn.getModelNumber());
        storageloc.setText(stockIn.getStorageLocation());
    }

    private void resetStockInFormData() {
        companyname.setText("");
        model_no.setText("");
        storageloc.setText("");
        supplierID.setText("");
        date.setText("");
        billno.setText("");
        sname.setText("");
        contact.setText("");
        add.setText("");
        availableq.setText("");
        openpg.setText("");


    }

    private class insertStockInToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            if (addMultipleStock) {
                return params[0].insert_stockIn_Record_list(stockInList);
            } else {
                return params[0].insert_stockIn_Record(stockIn);
            }
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {


        }

    }

    //QR CODE
    public void scanQR(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(Stock_in.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
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

                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
