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
import com.oswal.stockmangmentnew.Services.StockOut.stock_OUT;

import org.json.JSONArray;

public class Damage extends AppCompatActivity {
    Button scan, submit;
    EditText reason, item_name, model_no, bill_no, date, customer_name, store_loc;
    String reasonS, item_nameS, model_noS, bill_noS, dateS, customer_nameS, store_locS;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    String itemUniqueID = "itemUniqueID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage);
        getSupportActionBar().setTitle("Damage");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason = (EditText) findViewById(R.id.damage_resonET);
        item_name = (EditText) findViewById(R.id.damage_itmnameET);
        model_no = (EditText) findViewById(R.id.damage_modelnoET);
        bill_no = (EditText) findViewById(R.id.damage_billnoET);
        date = (EditText) findViewById(R.id.damage_dateET);
        customer_name = (EditText) findViewById(R.id.damage_cusnameET);
        store_loc = (EditText) findViewById(R.id.damage_storeLocET);
        scan = (Button) findViewById(R.id.damage_scan);
        submit = (Button) findViewById(R.id.damage_subtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "data submited", Toast.LENGTH_SHORT).show();
                reasonS = reason.getText().toString().trim();
                item_nameS = item_name.getText().toString().trim();
                model_noS = model_no.getText().toString().trim();
                bill_noS = bill_no.getText().toString().trim();
                dateS = date.getText().toString().trim();
                customer_nameS = customer_name.getText().toString().trim();
                store_locS = store_loc.getText().toString().trim();
                if (validateForm()) {
                    //insert value to Online DB
                    new insertDamageItemToOnlineDB().execute(new ApiConnector());
                    Intent gotoHome = new Intent(Damage.this, MainActivity.class);
                    startActivity(gotoHome);
                }
            }

            private boolean validateForm() {
                if (reasonS.isEmpty()) {
                    reason.setError("Enter Reason");
                    reason.requestFocus();
                    return false;
                }
                if (item_nameS.isEmpty()) {
                    reason.setError("Enter item_name");
                    reason.requestFocus();
                    return false;
                }
                if (model_noS.isEmpty()) {
                    reason.setError("Enter model_no");
                    reason.requestFocus();
                    return false;
                }
                if (bill_noS.isEmpty()) {
                    reason.setError("Enter bill_no");
                    reason.requestFocus();
                    return false;
                }
                if (dateS.isEmpty()) {
                    reason.setError("Enter date");
                    reason.requestFocus();
                    return false;
                }
                if (customer_nameS.isEmpty()) {
                    reason.setError("Enter customer_name");
                    reason.requestFocus();
                    return false;
                }
                if (store_locS.isEmpty()) {
                    reason.setError("Enter store_loc");
                    reason.requestFocus();
                    return false;
                }
                return true;
            }
        });
    }

    public void scanBar(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(Damage.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
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

    private class insertDamageItemToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
            return params[0].insert_damage_item(itemUniqueID, reasonS, item_nameS, model_noS, bill_noS, dateS, customer_nameS, store_locS);
        }
        @Override
        protected void onPostExecute(JSONArray jsonArray) {

        }
    }
}
