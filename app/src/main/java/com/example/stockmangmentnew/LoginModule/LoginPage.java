package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockmangmentnew.MainActivity;
import com.example.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.example.stockmangmentnew.R;


public class LoginPage extends AppCompatActivity {

    EditText userName, password;
    String userNameString, passwordString;
    private TextView forgetPassword, register;
    Button login, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);
        userName = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        login = findViewById(R.id.loginBtn);
        reset = findViewById(R.id.resetBtn);

        forgetPassword = (TextView) findViewById(R.id.TVforgetPass);
        register = (TextView) findViewById(R.id.TVregistration);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Login Pressed", Toast.LENGTH_LONG).show();
                userNameString = userName.getText().toString();
                passwordString = password.getText().toString();
                new checkCredential().execute(new ApiConnector());
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reset Pressed", Toast.LENGTH_LONG).show();

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

    private class checkCredential extends AsyncTask<ApiConnector, Long, String> {
        @Override
        protected String doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //  Toast.makeText(getApplicationContext(),"Image Capture "+imageData,Toast.LENGTH_LONG).show();

            return params[0].checkUserCredential(userNameString, passwordString);
        }

        @Override
        protected void onPostExecute(String jsonArray) {

            //Toast.makeText(getApplicationContext(),"Return "+jsonArray,Toast.LENGTH_LONG).show();
            if (jsonArray.equalsIgnoreCase("rows #00")) {

                AlertDialog alertDialog = new AlertDialog.Builder(
                        LoginPage.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Error!!");

                // Setting Dialog Message
                alertDialog.setMessage("You are not Authenticate to View Application");

                // Setting Icon to Dialog
                // alertDialog.setIcon(R.drawable.tick);

                // Setting OK Button
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        //Intent i = new Intent(FeedbackPage.this,MainActivity.class);
                        //startActivity(i);
                        userName.setText("");
                        password.setText("");

                    }
                });

                // Showing Alert Message
                alertDialog.show();

            } else {
                Toast.makeText(getApplicationContext(), "Welcome User", Toast.LENGTH_LONG).show();

                Intent i = new Intent(LoginPage.this, MainActivity.class);
                startActivity(i);
            }
        }

    }
}
