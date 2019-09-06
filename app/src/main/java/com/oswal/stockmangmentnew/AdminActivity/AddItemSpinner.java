package com.oswal.stockmangmentnew.AdminActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.R;

public class AddItemSpinner extends AppCompatActivity {
    EditText keyboard_brandname,keyboard_type,mouse_brandname,mouse_type,Laptop_brandname,Laptop_type,Laptop_gen,Laptop_ram,Laptop_inches,Laptop_hdd,Laptop_shdd,Laptop_os,Laptop_graphic,Laptop_dvd,
            monitor_brand,monitor_inches,monitor_port,printer_brandname,scanner_brandname,scanner_type,ups_brandname,ups_type,ups_capacity,cpu_brandname,cpu_type,cpu_gen,cpu_ram,cpu_hdd,cpu_shdd,cpu_os,cpu_graphics,cpu_dvd,
            router_brandname,router_type,router_port,router_mbps,ram_brandname,ram_type,ram_gb,cables_brandname,gps_brandname,xerox_brandname,xerox_ppm,switch_brandname,switch_type,switch_port,tv_brandname,
            tv_inches,wifiLan_brandname,wifiLan_mbps,wifidongle_brandname,wifidongle_type,tablet_brandname,tablet_inches;
    Button submit;
    DatabaseHelper db = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_item_add);
        keyboard_brandname=(EditText)findViewById(R.id.spinner_keybrand);
        keyboard_type=(EditText)findViewById(R.id.spinner_keytype);
        mouse_brandname=(EditText)findViewById(R.id.spinner_mousebrand);
        mouse_type=(EditText)findViewById(R.id.spinner_mousetyp);
        Laptop_brandname=(EditText)findViewById(R.id.spinner_Lapbrand);
        Laptop_type=(EditText)findViewById(R.id.spinner_laptyp);
        Laptop_gen=(EditText)findViewById(R.id.spinner_lapgen);
        Laptop_ram=(EditText)findViewById(R.id.spinner_lapram);
        Laptop_inches=(EditText)findViewById(R.id.spinner_lapinches);
        Laptop_hdd=(EditText)findViewById(R.id.spinner_laphdd);
        Laptop_shdd=(EditText)findViewById(R.id.spinner_lapshdd);
        Laptop_os=(EditText)findViewById(R.id.spinner_lapos);
        Laptop_graphic=(EditText)findViewById(R.id.spinner_lapgraphic);
        Laptop_dvd=(EditText)findViewById(R.id.spinner_lapdvd);
        monitor_brand=(EditText)findViewById(R.id.spinner_monitorbrand);
        monitor_inches=(EditText)findViewById(R.id.spinner_monitorinches);
        monitor_port=(EditText)findViewById(R.id.spinner_monitorport);
        printer_brandname=(EditText)findViewById(R.id.spinner_printerbrand);
        scanner_brandname=(EditText)findViewById(R.id.spinner_scannerbrand);
        scanner_type=(EditText)findViewById(R.id.spinner_scannertype);
        ups_brandname=(EditText)findViewById(R.id.spinner_upsbrand);
        ups_type=(EditText)findViewById(R.id.spinner_upstyp);
        ups_capacity=(EditText)findViewById(R.id.spinner_upscapcity);
        cpu_brandname=(EditText)findViewById(R.id.spinner_cpubrand);
        cpu_type=(EditText)findViewById(R.id.spinner_cputyp);
        cpu_gen=(EditText)findViewById(R.id.spinner_cpugen);
        cpu_ram=(EditText)findViewById(R.id.spinner_cpuram);
        cpu_hdd=(EditText)findViewById(R.id.spinner_cpuhdd);
        cpu_shdd=(EditText)findViewById(R.id.spinner_cpushdd);
        cpu_os=(EditText)findViewById(R.id.spinner_cpuos);
        cpu_graphics=(EditText)findViewById(R.id.spinner_cpuGraphiccard);
        cpu_dvd=(EditText)findViewById(R.id.spinner_cpudvd);
        router_brandname=(EditText)findViewById(R.id.spinner_routerbrand);
        router_type=(EditText)findViewById(R.id.spinner_routertyp);
        router_port=(EditText)findViewById(R.id.spinner_routerport);
        router_mbps=(EditText)findViewById(R.id.spinner_routermbps);
        ram_brandname=(EditText)findViewById(R.id.spinner_rambrand);
        ram_type=(EditText)findViewById(R.id.spinner_ramtyp);
        ram_gb=(EditText)findViewById(R.id.spinner_ramgb);
        cables_brandname=(EditText)findViewById(R.id.spinner_cablesbrand);
        gps_brandname=(EditText)findViewById(R.id.spinner_gpsbrand);
        xerox_brandname=(EditText)findViewById(R.id.spinner_xeroxbrand);
        switch_brandname=(EditText)findViewById(R.id.spinner_switchbrand);
        xerox_ppm=(EditText)findViewById(R.id.spinner_xeroxppm);
        switch_type=(EditText)findViewById(R.id.spinner_switctyp);
        switch_port=(EditText)findViewById(R.id.spinner_swithport);
        tv_brandname=(EditText)findViewById(R.id.spinner_tvbrand);
        tv_inches=(EditText)findViewById(R.id.spinner_tvinches);
        wifiLan_brandname=(EditText)findViewById(R.id.spinner_wifilanbrand);
        wifiLan_mbps=(EditText)findViewById(R.id.spinner_wifilanmbps);
        wifidongle_brandname=(EditText)findViewById(R.id.spinner_wifidonglebrand);
        wifidongle_type=(EditText)findViewById(R.id.spinner_wifidongletyp);
        tablet_brandname=(EditText)findViewById(R.id.spinner_tabletbrand);
        tablet_inches=(EditText)findViewById(R.id.spinner_tabletinches);
        wifiLan_mbps=(EditText)findViewById(R.id.spinner_wifilanmbps);
        submit=(Button)findViewById(R.id.spinner_subbtn1);

        submit=(Button)findViewById(R.id.spinner_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();




            }
        });


    }
}
