package com.oswal.stockmangmentnew.Services.Return;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oswal.stockmangmentnew.MainActivity;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.R;

import org.json.JSONArray;

public class Repaire extends AppCompatActivity {
    EditText reason,item_name,model_no,bill_no,date,customer_name,store_loc;
    String reasonS, item_nameS, model_noS, bill_noS, dateS, customer_nameS, store_locS;
    Button scan,submit, addto_stockin,goto_customer;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    String itemUniqueID = "itemUniqueID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repaire);
        getSupportActionBar().setTitle("Repair");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason=(EditText)findViewById(R.id.repaire_resonET);
        item_name=(EditText)findViewById(R.id.repaire_itmnameET);
        model_no=(EditText)findViewById(R.id.repaire_modelnoET);
        bill_no=(EditText)findViewById(R.id.repair_billnoET);
        date=(EditText)findViewById(R.id.repair_dateET);
        customer_name=(EditText)findViewById(R.id.repair_cusnameET);
        store_loc=(EditText)findViewById(R.id.repair_storeLocET);
        scan=(Button)findViewById(R.id.repair_scnbtn);
        addto_stockin=(Button)findViewById(R.id.repair_addto_stocinbtn);
        goto_customer=(Button)findViewById(R.id.repair_goto_custbtn);

        submit=(Button)findViewById(R.id.repaire_subtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reasonS = reason.getText().toString().trim();
                item_nameS = item_name.getText().toString().trim();
                model_noS = model_no.getText().toString().trim();
                bill_noS = bill_no.getText().toString().trim();
                dateS = date.getText().toString().trim();
                customer_nameS = customer_name.getText().toString().trim();
                store_locS = store_loc.getText().toString().trim();
                if (validateForm()) {
                    //insert value to Online DB
                    new insertRepairItemToOnlineDB().execute(new ApiConnector());
                    Intent gotoHome = new Intent(Repaire.this, MainActivity.class);
                    startActivity(gotoHome);
                }
            }
        });


        addto_stockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Add to Stock_IN Pressed", Toast.LENGTH_SHORT).show();

            }
        });
        goto_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"go to Customer Pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateForm() {
        if (reasonS.length() == 0) {
            reason.setError("Enter Reason");
            reason.requestFocus();
            return false;
        }
        if (item_nameS.length() == 0) {
            reason.setError("Enter item_name");
            reason.requestFocus();
            return false;
        }
        if (model_noS.length() == 0) {
            reason.setError("Enter model_no");
            reason.requestFocus();
            return false;
        }
        if (bill_noS.length() == 0) {
            reason.setError("Enter bill_no");
            reason.requestFocus();
            return false;
        }
        if (dateS.length() == 0) {
            reason.setError("Enter date");
            reason.requestFocus();
            return false;
        }
        if (customer_nameS.length() == 0) {
            reason.setError("Enter customer_name");
            reason.requestFocus();
            return false;
        }
        if (store_locS.length() == 0) {
            reason.setError("Enter store_loc");
            reason.requestFocus();
            return false;
        }
        return true;
    }
    //scanBar CODE
    public void scanBar(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(Repaire.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private class insertRepairItemToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            return params[0].insert_Repair_item(itemUniqueID, reasonS, item_nameS, model_noS, bill_noS, dateS, customer_nameS, store_locS);
        }
        @Override
        protected void onPostExecute(JSONArray jsonArray) {

        }
    }
}
