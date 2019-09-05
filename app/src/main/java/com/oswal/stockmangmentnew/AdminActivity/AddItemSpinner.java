package com.oswal.stockmangmentnew.AdminActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.R;

public class AddItemSpinner extends AppCompatActivity {
    EditText keyboard_brandname;
    Button submit;
    DatabaseHelper db = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_item_add);
        keyboard_brandname=(EditText)findViewById(R.id.spinner_keybrand);
        submit=(Button)findViewById(R.id.spinner_subbtn1);

        db = new DatabaseHelper(this);
        if(db.getKeyboardProfileCount()>0){
            KeyboardProfile keyboardProfile=db.getAllKeyboardProfileDetails();
            Toast.makeText(getApplicationContext()," keyBoard brand List "+keyboardProfile.getBrandList(),Toast.LENGTH_LONG).show();
        }
    }
}
