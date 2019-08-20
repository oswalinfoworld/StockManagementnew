package com.oswal.stockmangmentnew.Services.Return;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;

public class Reject extends AppCompatActivity {
    EditText reason;
    Button scan,addto_stockin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);
        getSupportActionBar().setTitle("Reject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason=(EditText)findViewById(R.id.reject_resonET);
        scan=(Button)findViewById(R.id.reject_scan);
        addto_stockin=(Button)findViewById(R.id.reject_subtn);
        addto_stockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"data submited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
