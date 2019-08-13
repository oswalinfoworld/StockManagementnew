package com.example.stockmangmentnew.Services.StockOut;

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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockmangmentnew.MainActivity;
import com.example.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.example.stockmangmentnew.POJO.StockOut;
import com.example.stockmangmentnew.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class stock_OUT extends AppCompatActivity {
    EditText CustomerID, date, billno, Cname, contact, add, itemname,quantity, availableq, openpg;
    String CustomerIDString, dateString, billnoString, CnameString, contactString, addString, itemnameString,quantityString, availableqString, openpgString;
    Button submit, open;
    List<StockOut> stockOutList = new ArrayList<>();
    StockOut stockOut = new StockOut();
    private Object View;
    boolean addMultipleStock = false;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock__out);
        CustomerID = (EditText) findViewById(R.id.stockout_uniqIdET);
        date = (EditText) findViewById(R.id.stockout_dateET);
        billno = (EditText) findViewById(R.id.stockout_billnoET);
        Cname = (EditText) findViewById(R.id.stockout_CnameET);
        contact = (EditText) findViewById(R.id.stockout_conoET);
        add = (EditText) findViewById(R.id.stockout_addessET);
        itemname = (EditText) findViewById(R.id.stockout_itemnameET);
        quantity = (EditText) findViewById(R.id.stockout_qaunET);
        availableq = (EditText) findViewById(R.id.stockout_avilQET);
        openpg = (EditText) findViewById(R.id.stockout_opnET);
        submit = (Button) findViewById(R.id.stockout_submitbtn);
        open = (Button) findViewById(R.id.stockout_opnbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addMultipleStock) {
                    stockOut = getStockOutFormData();
                    if (emptyvalidate(stockOut)) {
                        //insert value to Online DB
                        new insertStockOutToOnlineDB().execute(new ApiConnector());
                    }
                } else {
                    new insertStockOutToOnlineDB().execute(new ApiConnector());
                }
                Intent intent = new Intent(stock_OUT.this, MainActivity.class);
                startActivity(intent);
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
    public void openStockInPage(View v) {
        //Load value on form as per number
        int openPage = Integer.parseInt(openpg.getText().toString().trim());
        Toast.makeText(getApplicationContext(), "Open Page " + openPage, Toast.LENGTH_SHORT).show();
        setStockOutFormData(openPage);
    }

    private void setStockOutFormData(int listNumber) {
        StockOut stockOut = stockOutList.get(listNumber - 1);
        CustomerID.setText(stockOut.getSupplierID());
        date.setText(stockOut.getDate());
        billno.setText(stockOut.getBillNumber());
        Cname.setText(stockOut.getSupplierName());
        contact.setText(stockOut.getContactNumber());
        add.setText(stockOut.getAddress());
        itemname.setText(stockOut.getItemName());

        availableq.setText(stockOut.getAvailableQuantity());
    }

    private boolean emptyvalidate(StockOut passData) {
        if (passData.getItemName().length() == 0) {
            itemname.setError("Enter item name");
            itemname.requestFocus();
            return false;

        }
        if (passData.getSupplierID().length() == 0) {
            CustomerID.setError("Enter Customer ID");
            CustomerID.requestFocus();
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
        if (passData.getSupplierName().length() == 0) {
            Cname.setError("Enter Customer name");
            Cname.requestFocus();
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

        }if (quantityString.length() == 0) {
            quantity.setError("Enter quantity out");
            quantity.requestFocus();
            return false;

        }

        return true;
    }


    public void addstockOut(View v) {
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
    private StockOut getStockOutFormData() {
        StockOut stockOut = new StockOut();
        CustomerIDString = CustomerID.getText().toString().trim();
        dateString = date.getText().toString().trim();
        billnoString = billno.getText().toString().trim();
        CnameString = Cname.getText().toString().trim();
        contactString = contact.getText().toString().trim();
        addString = add.getText().toString().trim();
        itemnameString = itemname.getText().toString().trim();
        quantityString=quantity.getText().toString().trim();
        availableqString = availableq.getText().toString().trim();
        openpgString = openpg.getText().toString().trim();
        stockOut.setSupplierID(CustomerIDString);
        stockOut.setDate(dateString);
        stockOut.setBillNumber(billnoString);
        stockOut.setSupplierName(CnameString);
        stockOut.setContactNumber(contactString);
        stockOut.setAddress(addString);
        stockOut.setItemName(itemnameString);
        stockOut.setAvailableQuantity(availableqString);
        return stockOut;
    }
    public void resetStockOutFormData() {

        CustomerID.setText("");
        date.setText("");
        billno.setText("");
        Cname.setText("");
        contact.setText("");
        add.setText("");
        itemname.setText("");
        availableq.setText("");
        openpg.setText("");

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

    //QR CODE
    public void scanQR(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
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

                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
