package com.example.stockmangmentnew.Services.StockIn;

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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stockmangmentnew.LoginModule.LoginPage;
import com.example.stockmangmentnew.LoginModule.sign_UP;
import com.example.stockmangmentnew.MainActivity;
import com.example.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.example.stockmangmentnew.POJO.StockIn;
import com.example.stockmangmentnew.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class stock_in extends AppCompatActivity {
    EditText supplierID, date, billno, sname, contact, add, itemname, quantity,availableq, openpg,model_no,serial_no,storageloc,proadd;
    Spinner spinner;
    String supplierIDString, dateString, billnoString, snameString, contactString, addString, itemnameString,quantityString, availableqString, openpgString,model_noString,serial_noString,storagelocString;
    Button submit, open,scan;
    List<StockIn> stockInList = new ArrayList<>();
    StockIn stockIn = new StockIn();
    boolean addMultipleStock = false;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_in);
        supplierID = (EditText) findViewById(R.id.additem_suppIDET);
        date = (EditText) findViewById(R.id.additem_dateET);
        billno = (EditText) findViewById(R.id.additem_billnoET);
        sname = (EditText) findViewById(R.id.additem_snameET);
        contact = (EditText) findViewById(R.id.additem_conoET);
        add = (EditText) findViewById(R.id.additem_addET);
        itemname = (EditText) findViewById(R.id.additem_nameET);
        quantity = (EditText) findViewById(R.id.additem_nameET);
        availableq = (EditText) findViewById(R.id.additem_availbleET);

        storageloc = (EditText) findViewById(R.id.additem_storageLocaET);
        openpg = (EditText) findViewById(R.id.additem_opnpgET);
        proadd = (EditText) findViewById(R.id.additem_quantityET);
        submit = (Button) findViewById(R.id.add_item_Submitbtn);
        open = (Button) findViewById(R.id.additem_opnbtn);
        scan = (Button) findViewById(R.id.add_item_scanbtn);
        spinner = (Spinner) findViewById(R.id.add_item_spinner);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addMultipleStock) {
                    stockIn = getStockInFormData();
                    if (emptyvalidate(stockIn)) {
                        //insert value to Online DB
                        new insertStockInToOnlineDB().execute(new ApiConnector());
                    }
                } else {
                    new insertStockInToOnlineDB().execute(new ApiConnector());
                }
                //Intent intent = new Intent(stock_in.this, MainActivity.class);
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(stock_in.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
    }

    private boolean emptyvalidate(StockIn passData) {
        if (passData.getItemName().length() == 0) {
            itemname.setError("Enter item name");
            itemname.requestFocus();
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
        if (quantityString.length() == 0) {
            quantity.setError("Enter quantity");
            quantity.requestFocus();
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
        dateString = date.getText().toString().trim();
        billnoString = billno.getText().toString().trim();
        snameString = sname.getText().toString().trim();
        contactString = contact.getText().toString().trim();
        addString = add.getText().toString().trim();
        itemnameString = itemname.getText().toString().trim();
        quantityString=quantity.getText().toString().trim();
        availableqString = availableq.getText().toString().trim();

        storagelocString = storageloc.getText().toString().trim();
        stockIn.setSupplierID(supplierIDString);
        stockIn.setDate(dateString);
        stockIn.setBillNumber(billnoString);
        stockIn.setSupplierName(snameString);
        stockIn.setContactNumber(contactString);
        stockIn.setAddress(addString);

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
        itemname.setText(stockIn.getItemName());
        availableq.setText(stockIn.getAvailableQuantity());
    }

    private void resetStockInFormData() {
        supplierID.setText("");
        date.setText("");
        billno.setText("");
        sname.setText("");
        contact.setText("");
        add.setText("");
        itemname.setText("");
        quantity.setText("");
        availableq.setText("");
        openpg.setText("");

        storageloc.setText("");
    }

    private class insertStockInToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            if(addMultipleStock){
                return params[0].insert_stockIn_Record_list(stockInList);
            }else {
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
            showDialog(stock_in.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
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
