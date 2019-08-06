package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.example.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.example.stockmangmentnew.POJO.StockUser;
import com.example.stockmangmentnew.R;

import org.json.JSONArray;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sign_UP extends AppCompatActivity {
    EditText name, phone,dob, email,password,confmpass;

    Button Submit, photobtn;
    String nameString, contactNumber, emailString, DOBString,passwordString,confirmPassString;
    private StockUser user = new StockUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        Submit = findViewById(R.id.signup_submit);
        name = findViewById(R.id.nameEditText);
        phone = (EditText) findViewById(R.id.coNoEditText);
        email = (EditText) findViewById(R.id.emailEditText);
        dob = (EditText) findViewById(R.id.dobEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        confmpass = (EditText) findViewById(R.id.confim_passEditText);
        photobtn = (Button) findViewById(R.id.photobtn);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = name.getText().toString().trim();
                contactNumber = phone.getText().toString().trim();
                emailString = email.getText().toString().trim();
                DOBString = dob.getText().toString().trim();
                passwordString = password.getText().toString().trim();
                confirmPassString = confmpass.getText().toString().trim();

                if (validateForm()) {
                    user.setName(nameString);
                    user.setUserName(emailString);
                    user.setContactNumber(contactNumber);
                    user.setDOB(DOBString);
                    user.setPassword(passwordString);
                    user.setPassword(confirmPassString);
                    if (isInternetOn()) {
                        new insertUserToOnlineDB().execute(new ApiConnector());
                    }
                    Intent intent = new Intent(sign_UP.this, LoginPage.class);
                    startActivity(intent);
                }
            }
        });


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear, mMonth, mDay;
                DatePicker datePicker;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(sign_UP.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
    }





        public static boolean isValidPassword( final String passwordString){

            Pattern pattern;
            Matcher matcher;
            final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
            pattern = Pattern.compile(PASSWORD_PATTERN);
            matcher = pattern.matcher(passwordString);

           return matcher.matches();


        }

    public boolean validateForm() {


        String validEmailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                "\\@" +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                "(" +

                "\\." +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                ")+";

        Matcher matcher = Pattern.compile(validEmailPattern).matcher(emailString);
        if (matcher.matches()) {
            //Toast.makeText(getApplicationContext(), "valid", Toast.LENGTH_SHORT).show();

        } else {

            email.setError("Enter Valid Email-Id");
            email.requestFocus();
            return false;
        }
        if(!passwordString.equals(confirmPassString)) {

            Toast.makeText(sign_UP.this, "Password Not matching", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(isValidPassword(passwordString)&&passwordString.length()>7) {
            Toast.makeText(getApplicationContext(),"Go Ahead",Toast.LENGTH_SHORT).show();
            //return false;
        }
        else{
            Toast.makeText(getApplicationContext(),"Password must contain mix of upper and lower case letters as well as digits and one special charecter)",Toast.LENGTH_LONG).show();
            return false;

        }
        if (passwordString.length() == 0) {
            password.setError("Enter Password");
            password.requestFocus();
            return false;
        }

        if (confirmPassString.length() == 0) {
            confmpass.setError("Enter confirm Password");
            confmpass.requestFocus();
            return false;
        }




        if (nameString.length() < 3) {
            name.setError("Enter Valid name");
            name.requestFocus();
            return false;
        }
        if (contactNumber.length() != 10) {
            phone.setError("Enter valid Phone Number");
            phone.requestFocus();
            return false;
        }


        if (emailString.length() == 0) {
            email.setError("Enter email id");
            email.requestFocus();
            return false;
        }

        if (DOBString.length() == 0) {
            dob.setError("Enter date of birth");
            dob.requestFocus();
            return false;
        }

        return true;
    }



    private class insertUserToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            return params[0].insert_stock_user(user);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {


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

            Toast.makeText(getApplicationContext(), "Internet Down Data not Reflect on server", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

}
