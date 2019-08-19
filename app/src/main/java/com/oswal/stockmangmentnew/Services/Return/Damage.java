package com.oswal.stockmangmentnew.Services.Return;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;

public class Damage extends AppCompatActivity {
    Button scan,submit;
    EditText reason,item_name,model_no,bill_no,date,customer_name,store_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage);
        getSupportActionBar().setTitle("Damage");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason=(EditText)findViewById(R.id.damage_resonET);
        item_name=(EditText)findViewById(R.id.damage_itmnameET);
        model_no=(EditText)findViewById(R.id.damage_modelnoET);
        bill_no=(EditText)findViewById(R.id.damage_billnoET);
        date=(EditText)findViewById(R.id.damage_dateET);
        customer_name=(EditText)findViewById(R.id.damage_cusnameET);
        store_loc=(EditText)findViewById(R.id.damage_storeLocET);
        scan=(Button)findViewById(R.id.damage_scan);
        submit=(Button)findViewById(R.id.damage_subtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"damage Pressed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
