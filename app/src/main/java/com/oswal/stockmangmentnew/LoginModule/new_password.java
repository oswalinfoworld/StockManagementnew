package com.oswal.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oswal.stockmangmentnew.R;

public class new_password extends AppCompatActivity {
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        getSupportActionBar().setTitle("New Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Submit=findViewById(R.id.newPass_submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(new_password.this,LoginPage.class);
                startActivity(intent);

            }
        });
    }
}