package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stockmangmentnew.R;

public class otp_page extends AppCompatActivity {
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        Submit=findViewById(R.id.otp_submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(otp_page.this,new_password.class);
                startActivity(intent);

            }
        });
    }
}
