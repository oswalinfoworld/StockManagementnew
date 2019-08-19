package com.example.stockmangmentnew.Services.Return;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockmangmentnew.R;

public class Repaire extends AppCompatActivity {
    EditText reason,item_name,model_no,bill_no,date,customer_name,store_loc;
    Button scan,submit, addto_stockin,goto_customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repaire);
        getSupportActionBar().setTitle("Repaire");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason=(EditText)findViewById(R.id.repaire_resonET);
        item_name=(EditText)findViewById(R.id.repaire_itmnameET);
        model_no=(EditText)findViewById(R.id.repaire_modelnoET);
        bill_no=(EditText)findViewById(R.id.repair_billnoET);
        date=(EditText)findViewById(R.id.repair_dateET);
        customer_name=(EditText)findViewById(R.id.repair_cusnameET);
        store_loc=(EditText)findViewById(R.id.repair_storeLocET);
        scan=(Button)findViewById(R.id.repair_scnbtn);
        addto_stockin=(Button)findViewById(R.id.repair_addto_stocinbtn);
        goto_customer=(Button)findViewById(R.id.repair_goto_custbtn);

        submit=(Button)findViewById(R.id.repaire_subtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Repaire Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        addto_stockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Add to Stock_IN Pressed", Toast.LENGTH_SHORT).show();

            }
        });
        goto_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"go to Customer Pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
