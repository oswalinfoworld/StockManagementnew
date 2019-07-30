package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockmangmentnew.MainActivity;
import com.example.stockmangmentnew.R;
import com.example.stockmangmentnew.Services.Items.Add_Item;
import com.example.stockmangmentnew.Services.StockIn.IN_View;
import com.example.stockmangmentnew.Services.StockOut.Damage;
import com.example.stockmangmentnew.Services.StockOut.Return;
import com.example.stockmangmentnew.Services.StockOut.Stock_Out_View;

public class LoginPage extends AppCompatActivity {

    EditText userName,password;
   private TextView forgetPassword,register;
    Button login,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);
        userName=(EditText)findViewById(R.id.usernameET);
        password=(EditText)findViewById(R.id.passwordET);
        login=findViewById(R.id.loginBtn);
        reset=findViewById(R.id.resetBtn);

        forgetPassword=(TextView) findViewById(R.id.TVforgetPass);
        register=(TextView) findViewById(R.id.TVregistration);
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

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginPage.this, ForgetPassword.class);
                startActivity(i);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginPage.this, sign_UP.class);
                startActivity(i);


            }
        });

    }

}
