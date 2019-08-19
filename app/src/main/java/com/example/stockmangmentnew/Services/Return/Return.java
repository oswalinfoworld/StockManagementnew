package com.example.stockmangmentnew.Services.Return;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stockmangmentnew.R;

public class Return extends AppCompatActivity {
    Button reject,repair,damage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        reject = (Button) findViewById(R.id.return_rejbtn);
        repair = (Button) findViewById(R.id.return_repairbtn);
        damage = (Button) findViewById(R.id.return_damgbtn);
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent= new Intent(Return.this, Reject.class);
                startActivity(intent);
            }
        });
        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Return.this, Repaire.class);
                startActivity(intent);

            }
        });
        damage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Return.this, Damage.class);
                startActivity(intent);

            }
        });
    }
}
