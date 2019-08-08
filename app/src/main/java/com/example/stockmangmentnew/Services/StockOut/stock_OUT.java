package com.example.stockmangmentnew.Services.StockOut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.stockmangmentnew.POJO.StockIn;
import com.example.stockmangmentnew.POJO.StockOut;
import com.example.stockmangmentnew.R;
import com.example.stockmangmentnew.Services.StockIn.stock_in;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class stock_OUT extends AppCompatActivity {
    EditText CustomerID, date, billno, Cname, contact, add, itemname, availableq, openpg;
    String CustomerIDString, dateString, billnoString, CnameString, contactString, addString, itemnameString, availableqString, openpgString;
    Button submit, scan,open;
    List<StockOut> stockOutList = new ArrayList<>();
    StockOut stockOut = new StockOut();
    private Object View;

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
        availableq = (EditText) findViewById(R.id.stockout_avilQET);
        openpg = (EditText) findViewById(R.id.stockout_opnET);
        submit = (Button) findViewById(R.id.stockout_submitbtn);
        scan = (Button) findViewById(R.id.stockout_barcoadbtn);
        open = (Button) findViewById(R.id.stockout_opnbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerIDString = CustomerID.getText().toString().trim();
                dateString = date.getText().toString().trim();
                billnoString = billno.getText().toString().trim();
                CnameString = Cname.getText().toString().trim();
                contactString = contact.getText().toString().trim();
                addString = add.getText().toString().trim();
                itemnameString = itemname.getText().toString().trim();
                availableqString = availableq.getText().toString().trim();
                openpgString = openpg.getText().toString().trim();
                validate();

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



    private boolean validate() {
        if (CustomerIDString.length() == 0) {
            CustomerID.setError("Enter Customer ID");
            CustomerID.requestFocus();
            return false;

        }
        if (dateString.length() == 0) {
            date.setError("Enter Date");
            date.requestFocus();
            return false;

        }
        if (billnoString.length() == 0) {
            billno.setError("Enter bill no");
            billno.requestFocus();
            return false;

        }
       if (CnameString.length() == 0) {
           Cname.setError("Enter Customer name");
           Cname.requestFocus();
            return false;

        }

        if (contactString.length() != 10) {
            contact.setError("Enter valid Contact no");
            contact.requestFocus();
            return false;

        }
        if (addString.length() == 0) {
            add.setError("Enter Address");
            add.requestFocus();
            return false;

        }
        if (itemnameString.length() == 0) {
            itemname.setError("Enter Item name");
            itemname.requestFocus();
            return false;

        }
        return true;

    }
    public void addstockOut(View v)
    {
        resetStockOutFormData();
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
}
