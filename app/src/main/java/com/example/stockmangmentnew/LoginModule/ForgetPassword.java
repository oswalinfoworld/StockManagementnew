package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stockmangmentnew.R;

public class ForgetPassword extends AppCompatActivity {
    EditText username;
    Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        Submit=findViewById(R.id.forget_submit);
        username=(EditText)findViewById(R.id.usernameET);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetPassword.this,otp_page.class);
                startActivity(intent);

            }
        });
    }
}
