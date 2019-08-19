package com.example.stockmangmentnew.Services.StockOut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stockmangmentnew.R;
import com.example.stockmangmentnew.Services.StockIn.Stock_IN_View;

import java.util.ArrayList;

public class Stock_Out_View extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock__out__view);
        getSupportActionBar().setTitle("Stock Out View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            listView = (ListView) findViewById(R.id.stockIn_listview);
            final ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Januery");
            arrayList.add("February");
            arrayList.add("March");
            arrayList.add("April");
            arrayList.add("May");
            arrayList.add("June");
            arrayList.add("July");
            arrayList.add("August");
            arrayList.add("Saptembar");
            arrayList.add("Actomber");
            arrayList.add("Novmber");
            arrayList.add("December");
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(Stock_Out_View.this, "Click item" + i + " " + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

