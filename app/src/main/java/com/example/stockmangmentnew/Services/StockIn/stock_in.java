package com.example.stockmangmentnew.Services.StockIn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stockmangmentnew.R;

public class stock_in extends AppCompatActivity {
    EditText supplierID,date,billno,sname,contact,add,itemname,availableq,openpg;
    String supplierIDString,dateString,billnoString,snameString,contactString,addString,itemnameString,availableqString,openpgString;
    Button submit,scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_in);
        supplierID = (EditText) findViewById(R.id.uniqidEditText);
       date = (EditText) findViewById(R.id.dateEditText);
        billno = (EditText) findViewById(R.id.billnoEditText);
        sname = (EditText) findViewById(R.id.supplierrnameEditText);
        contact = (EditText) findViewById(R.id.coNoEditText);
        add = (EditText) findViewById(R.id.addessEditText);
        itemname = (EditText) findViewById(R.id.itemnameEditText);
        availableq = (EditText) findViewById(R.id.availableQuantityEditText);
        openpg = (EditText) findViewById(R.id.loadEditText);
        submit=(Button)findViewById(R.id.barcoadbtn);
        scan=(Button)findViewById(R.id.scanbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                supplierIDString = supplierID.getText().toString().trim();
                dateString = date.getText().toString().trim();
                billnoString = billno.getText().toString().trim();
                snameString = sname.getText().toString().trim();
                contactString = contact.getText().toString().trim();
                addString = add.getText().toString().trim();
                itemnameString = itemname.getText().toString().trim();
                availableqString = availableq.getText().toString().trim();
                emptyvalidate();
            }


        });
    }
    private void emptyvalidate() {
        if (supplierIDString.length() == 0) {
            supplierID.setError("Username is not entered");
            supplierID.requestFocus();

        }
    }
}
