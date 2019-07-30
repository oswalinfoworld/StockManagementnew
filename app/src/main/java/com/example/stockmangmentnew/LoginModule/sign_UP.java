package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stockmangmentnew.R;

public class sign_UP extends AppCompatActivity {
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        Submit=findViewById(R.id.signup_submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_UP.this,LoginPage.class);
                startActivity(intent);

            }
        });
    }
}
