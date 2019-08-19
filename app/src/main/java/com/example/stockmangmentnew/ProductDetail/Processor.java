package com.example.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.stockmangmentnew.R;

public class Processor extends AppCompatActivity {

    CheckBox type1,type2,type3,type4,type5,gen1,gen2,gen3,gen4,gen5;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor);
        getSupportActionBar().setTitle("Processor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        type1=(CheckBox)findViewById(R.id.processor_type1);
        type2=(CheckBox)findViewById(R.id.processor_type2);
        type3=(CheckBox)findViewById(R.id.processor_type3);
        type4=(CheckBox)findViewById(R.id.processor_type4);
        gen1=(CheckBox)findViewById(R.id.processor_gen1);
        gen2=(CheckBox)findViewById(R.id.processor_gen2);
        gen3=(CheckBox)findViewById(R.id.processor_gen3);
        gen4=(CheckBox)findViewById(R.id.processor_gen4);

        submit=(Button)findViewById(R.id.processor_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
