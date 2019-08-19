package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.ConnectivityManager;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
                userNameString = userName.getText().toString();
                passwordString = password.getText().toString();
                if(isInternetOn() && validateForm()) {
                    new checkCredential().execute(new ApiConnector());
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reset Pressed", Toast.LENGTH_SHORT).show();
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


    public boolean validateForm() {
        String validEmailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                "(" +

                "\\." +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                ")+";

        Matcher matcher = Pattern.compile(validEmailPattern).matcher(userNameString);
        if (matcher.matches()) {
            Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
            userName.setError("User Name must be in Email-id Formate");
            userName.requestFocus();
            return false;
        }

        if (userNameString.length() == 0) {
            userName.setError("Username is not entered");
            userName.requestFocus();
            return false;
        }
        if (passwordString.length() == 0) {
            password.setError("Password is not entered");
            password.requestFocus();
            return false;
        }
        return true;
    }

    public class checkCredential extends AsyncTask<ApiConnector, Long, String> {
        @Override
        protected String doInBackground(ApiConnector... params) {
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
                Toast.makeText(getApplicationContext(), "Welcome User"+userNameString+"", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(LoginPage.this, MainActivity.class);
                startActivity(i);
            }
        }
    }

    public boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(getApplicationContext(), "Internet Down Data not Reflect on server", Toast.LENGTH_SHORT).show();
            return false;
        }
        return false;
    }
}