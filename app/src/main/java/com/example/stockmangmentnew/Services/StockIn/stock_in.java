package com.example.stockmangmentnew.Services.StockIn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockmangmentnew.LoginModule.sign_UP;
import com.example.stockmangmentnew.POJO.StockIn;
import com.example.stockmangmentnew.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class stock_in extends AppCompatActivity {
    EditText supplierID, date, billno, sname, contact, add, itemname, availableq, openpg;
    String supplierIDString, dateString, billnoString, snameString, contactString, addString, itemnameString, availableqString, openpgString;
    Button submit, scan,open;
    List<StockIn> stockInList = new ArrayList<>();
    StockIn stockIn = new StockIn();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_in);
        supplierID = (EditText) findViewById(R.id.uniqidEditText);
        date = (EditText) findViewById(R.id.stockINdateEditText);
        billno = (EditText) findViewById(R.id.stockInBillNumber);
        sname = (EditText) findViewById(R.id.StockINsupplierrnameEditText);
        contact = (EditText) findViewById(R.id.StockInContactNumber);
        add = (EditText) findViewById(R.id.stockINAddress);
        itemname = (EditText) findViewById(R.id.stockInItemname);
        availableq = (EditText) findViewById(R.id.StockInavailableQuantity);
        openpg = (EditText) findViewById(R.id.StockInloadPage);
        submit = (Button) findViewById(R.id.stockInSubmitbtn);
        scan = (Button) findViewById(R.id.stockInBarcodebtn);
        open = (Button) findViewById(R.id.stockIn_opnbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stockIn = getStockInFormData();
                if (emptyvalidate(stockIn)) {
                    //insert value to Online DB
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
        if (passData.getItemName().length() == 0) {
            itemname.setError("Enter item name");
            itemname.requestFocus();
            return false;

        }
        return true;
    }

    public void addStockIn(View v) {
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
        availableqString = availableq.getText().toString().trim();
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
        availableq.setText("");
        openpg.setText("");
    }
}
