package com.oswal.stockmangmentnew.AdminActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OflineDBActivity.model.CPUProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.R;

public class AddItemSpinner extends AppCompatActivity {
    EditText keyboard_brandname,keyboard_type,mouse_brandname,mouse_type,Laptop_brandname,Laptop_type,Laptop_gen,Laptop_ram,Laptop_inches,Laptop_hdd,Laptop_shdd,Laptop_os,Laptop_graphic,Laptop_dvd,
            monitor_brand,monitor_inches,monitor_port,printer_brandname,scanner_brandname,scanner_type,ups_brandname,ups_type,ups_capacity,cpu_brandname,cpu_type,cpu_gen,cpu_ram,cpu_hdd,cpu_shdd,cpu_os,cpu_graphics,cpu_dvd,
            router_brandname,router_type,router_port,router_mbps,ram_brandname,ram_type,ram_gb,cables_brandname,gps_brandname,xerox_brandname,xerox_ppm,switch_brandname,switch_type,switch_port,tv_brandname,
            tv_inches,wifiLan_brandname,wifiLan_mbps,wifidongle_brandname,wifidongle_type,tablet_brandname,tablet_inches;
    Button submit;

    String keyboard_brandnameS,keyboard_typeS,mouse_brandnameS,mouse_typeS,Laptop_brandnameS,Laptop_typeS,Laptop_genS,Laptop_ramS,Laptop_inchesS,Laptop_hddS,Laptop_shddS,Laptop_osS,Laptop_graphicS,Laptop_dvdS,
            monitor_brandS,monitor_inchesS,monitor_porSt,printer_brandnameS,scanner_brandnameS,scanner_typeS,ups_brandnameS,ups_typeS,ups_capacityS,cpu_brandnamSe,cpu_typeS,cpu_genS,cpu_ramS,cpu_hddS,cpu_shdds,cpu_osS,cpu_graphicsS,cpu_dvdS,
            router_brandnameS,router_typeS,router_portS,router_mbpsS,ram_brandnameS,ram_typS,ram_gbS,cables_brandnameS,gps_brandnameS,xerox_brandnameS,xerox_ppmS,switch_brandnameS,switch_typeS,switch_ports,tv_brandnameS,
            tv_inchesS,wifiLan_brandnameS,wifiLan_mbpsS,wifidongle_brandnameS,wifidongle_typeS,tablet_brandnameS,tablet_inchesS;


    DatabaseHelper db = null;
    private Object Context;

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


                //AddItemSpinner addItemSpinner=new AddItemSpinner();
               // KeyboardProfile temp =new KeyboardProfile();
                keyboard_brandnameS = keyboard_brandname.getText().toString();

                if (!keyboard_brandnameS.isEmpty()) {
                     String keyboard_brandnameS = KeyboardProfile.getCOLUMN_Brand_Name();
                    // keyboard_brandnameS  = KeyboardProfile.getCOLUMN_TypeList();
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertKeyboardDetails(keyboard_brandnameS);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();
                    return;
                }








                keyboard_typeS = keyboard_type.getText().toString();
                if(keyboard_typeS.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }


                mouse_brandnameS = mouse_brandname.getText().toString().trim();
                if( mouse_brandnameS.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                mouse_typeS = mouse_type.getText().toString().trim();
                if(  mouse_typeS .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                Laptop_brandnameS = Laptop_brandname.getText().toString().trim();

                if(  Laptop_brandnameS.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                Laptop_typeS = Laptop_type.getText().toString().trim();
                if(      Laptop_typeS.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                Laptop_genS = Laptop_gen.getText().toString().trim();
                if(           Laptop_genS .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                Laptop_ramS = Laptop_ram.getText().toString().trim();
                if(                Laptop_ramS.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                Laptop_inchesS =Laptop_inches.getText().toString().trim();
                if(          Laptop_inchesS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                Laptop_hddS = Laptop_hdd.getText().toString().trim();
                if(            Laptop_hddS .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                Laptop_shddS = Laptop_shdd.getText().toString().trim();
                if(             Laptop_shddS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                Laptop_osS = Laptop_os.getText().toString().trim();
                if(             Laptop_osS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }


                Laptop_graphicS= Laptop_graphic.getText().toString().trim();
                if(            Laptop_graphicS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }


                Laptop_dvdS = Laptop_dvd.getText().toString().trim();
                if(  Laptop_dvdS .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }



                monitor_brandS= monitor_brand.getText().toString().trim();
                if(monitor_brandS .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                monitor_inchesS = monitor_inches.getText().toString().trim();
                if(           monitor_inchesS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                monitor_porSt = monitor_port.getText().toString().trim();
                if(           monitor_porSt  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                printer_brandnameS = printer_brandname.getText().toString().trim();
                if(           printer_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                scanner_brandnameS = scanner_brandname.getText().toString().trim();
                if(           scanner_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                scanner_typeS = scanner_type.getText().toString().trim();
                if(           scanner_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                ups_brandnameS = ups_brandname.getText().toString().trim();
                if(           ups_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                ups_typeS = ups_type.getText().toString().trim();
                if(           ups_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                ups_capacityS = ups_capacity.getText().toString().trim();
                if(           ups_capacityS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_brandnamSe = cpu_brandname.getText().toString().trim();
                if(           cpu_brandnamSe  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_typeS = cpu_type.getText().toString().trim();
                if(           cpu_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_genS = cpu_gen.getText().toString().trim();
                if(           cpu_genS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_ramS = cpu_ram.getText().toString().trim();
                if(           cpu_ramS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_hddS = cpu_hdd.getText().toString().trim();
                if(           cpu_hddS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_shdds = cpu_shdd.getText().toString().trim();
                if(           cpu_shdds  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_graphicsS = cpu_graphics.getText().toString().trim();
                if(           cpu_graphicsS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_osS = cpu_os.getText().toString().trim();
                if(           cpu_osS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cpu_dvdS = cpu_dvd.getText().toString().trim();
                if(           cpu_dvdS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                router_brandnameS = router_brandname.getText().toString().trim();
                if(           router_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                router_typeS = router_type.getText().toString().trim();
                if(           router_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                router_portS = router_port.getText().toString().trim();
                if(           router_portS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                router_mbpsS = router_mbps.getText().toString().trim();
                if(           router_mbpsS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                ram_brandnameS = ram_brandname.getText().toString().trim();
                if(           ram_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                ram_typS = ram_type.getText().toString().trim();
                if(           ram_typS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                ram_gbS = ram_gb.getText().toString().trim();
                if(           ram_gbS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                cables_brandnameS = cables_brandname.getText().toString().trim();
                if(           cables_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                gps_brandnameS = gps_brandname.getText().toString().trim();
                if(           gps_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                xerox_brandnameS = xerox_brandname.getText().toString().trim();
                if(           xerox_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                xerox_ppmS = xerox_ppm.getText().toString().trim();
                if(           xerox_ppmS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                switch_brandnameS = switch_brandname.getText().toString().trim();
                if(           switch_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                switch_ports = switch_port.getText().toString().trim();
                if(           switch_ports  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                switch_typeS = switch_type.getText().toString().trim();
                if(           switch_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                tv_brandnameS = tv_brandname.getText().toString().trim();
                if(           tv_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                tv_inchesS = tv_inches.getText().toString().trim();
                if(           tv_inchesS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                wifiLan_brandnameS = wifiLan_brandname.getText().toString().trim();
                if(           wifiLan_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                wifiLan_mbpsS = wifiLan_mbps.getText().toString().trim();
                if(           wifiLan_mbpsS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                wifidongle_brandnameS = wifidongle_brandname.getText().toString().trim();
                if(           wifidongle_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                wifidongle_typeS = wifidongle_type.getText().toString().trim();
                if(           wifidongle_typeS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }
                tablet_brandnameS = tablet_brandname.getText().toString().trim();
                if(           tablet_brandnameS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }

                tablet_inchesS = tablet_inches.getText().toString().trim();
                if(           tablet_inchesS  .isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You did not enter a data", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();

                }













            }
        });


    }

}
