package com.example.stockmangmentnew.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.stockmangmentnew.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sign_UP extends AppCompatActivity {
    EditText name,phone,email,dob,photo;
    Button Submit;
    String MobilePattern = "[0-9]{10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        Submit=findViewById(R.id.signup_submit);
        name=findViewById(R.id.nameEditText);
        phone=(EditText)findViewById(R.id.coNoEditText);
        email=(EditText)findViewById(R.id.emailEditText);
        dob=(EditText)findViewById(R.id.dobEditText);
        photo=(EditText)findViewById(R.id.photEditText);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";
                String EmailID=email.getText().toString().trim();
                String phoneNumber=phone.getText().toString().trim();
                Matcher matcher= Pattern.compile(validemail).matcher(EmailID);
                if (matcher.matches()){
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
                }



                if (name.getText().toString().trim().length() == 0) {
                    name.setError("Enter vaild name");
                    name.requestFocus();

                }
                if (phone.getText().toString().length() == 0) {
                    phone.setError("Enter Phone no");
                    phone.requestFocus();

                }


                if (email.getText().toString().trim().length() == 0) {
                    email.setError("Enter email id");
                    email.requestFocus();
                }

                if (dob.getText().toString().trim().length() == 0) {
                    dob.setError("Enter date of birth");
                    dob.requestFocus();
                }
                if (photo.getText().toString().trim().length() == 0) {
                    photo.setError("Enter photo");
                    photo.requestFocus();
                }
                else {
                    Intent intent = new Intent(sign_UP.this, LoginPage.class);
                    startActivity(intent);
                }


            }
            private boolean isValidPhoneNumber(CharSequence phoneNumber) {

                if (!TextUtils.isEmpty(phoneNumber)) {
                    return Patterns.PHONE.matcher(phoneNumber).matches();
                }
                return false;
            }


        });


    }



}
