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
import com.oswal.stockmangmentnew.Services.StockIn.Stock_in;

import org.json.JSONArray;

public class Reject extends AppCompatActivity {
    EditText reason;
        String reason_String,itemUniqueID="itemUniqueID";
    Button scan, addto_stockin;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);
        getSupportActionBar().setTitle("Reject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reason = (EditText) findViewById(R.id.reject_resonET);
        scan = (Button) findViewById(R.id.reject_scan);

        addto_stockin = (Button) findViewById(R.id.reject_subtn);
        addto_stockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "data submited", Toast.LENGTH_SHORT).show();
                reason_String = reason.getText().toString().trim();
                if(validateForm()){
                    //insert value to Online DB
                    new insertRejectItemToOnlineDB().execute(new ApiConnector());
                    Intent gotoHome = new Intent(Reject.this, MainActivity.class);
                    startActivity(gotoHome);
                }

            }

            private boolean validateForm() {
                if (reason_String.length() == 0) {
                    reason.setError("Enter Reason");
                    reason.requestFocus();
                    return false;
                }
                return true;
            }
        });
    }


    //scanBar CODE
    public void scanBar(View v) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(Reject.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
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

    private class insertRejectItemToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");
                return params[0].insert_reject_item(itemUniqueID,reason_String);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {


        }

    }
}
