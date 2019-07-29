package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockmangmentnew.MainActivity;
import com.example.stockmangmentnew.R;

public class LoginPage extends AppCompatActivity {

    EditText userName,password;
    Button login,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);
        userName=(EditText)findViewById(R.id.usernameET);
        password=(EditText)findViewById(R.id.passwordET);
        login=findViewById(R.id.loginBtn);
        reset=findViewById(R.id.resetBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Login Pressed",Toast.LENGTH_LONG).show();
                Intent i = new Intent(LoginPage.this, MainActivity.class);
                startActivity(i);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Reset Pressed",Toast.LENGTH_LONG).show();
                userName.getText().clear();
                password.getText().clear();
            }
        });


    }

}
