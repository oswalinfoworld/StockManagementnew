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
import com.oswal.stockmangmentnew.OflineDBActivity.model.CablesProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.LaptopProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MonitorProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MouseProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.PrinterProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.RAMProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.RouterProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.ScannerProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.SwitchProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TVProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TabletProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.UPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.XeroxProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_LanProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_dongleProfile;
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



               keyboard_brandnameS = keyboard_brandname.getText().toString();


               if (!keyboard_brandnameS.isEmpty()) {
                    KeyboardProfile obj=new KeyboardProfile();
                    obj.setBrandList(keyboard_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertKeyboardDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }



                keyboard_typeS = keyboard_type.getText().toString();
                if(!keyboard_typeS.isEmpty())
                {
                    KeyboardProfile obj=new KeyboardProfile();
                    obj.setTypeList(keyboard_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertKeyboardDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }



                mouse_brandnameS = mouse_brandname.getText().toString();
                if( !mouse_brandnameS.isEmpty())
                {
                    MouseProfile obj=new MouseProfile();
                        obj.setBrandName(mouse_brandnameS);
                        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                        databaseHelper.insertMouseDetails(obj);
                        Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();



                }

                mouse_typeS = mouse_type.getText().toString().trim();
                if(  !mouse_typeS .isEmpty())
                {
                    MouseProfile obj=new MouseProfile();
                    obj.setTypeList(mouse_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertMouseDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                Laptop_brandnameS = Laptop_brandname.getText().toString().trim();

                if(  !Laptop_brandnameS.isEmpty())
                {
                 LaptopProfile obj=new LaptopProfile();
                    obj.setBrandName(Laptop_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                Laptop_typeS = Laptop_type.getText().toString().trim();
                if(!Laptop_typeS.isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setProtypeList(Laptop_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                Laptop_genS = Laptop_gen.getText().toString().trim();
                if(           !Laptop_genS .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setGen(Laptop_genS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }


                Laptop_ramS = Laptop_ram.getText().toString().trim();
                if(!Laptop_ramS.isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setRam(Laptop_ramS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                Laptop_inchesS =Laptop_inches.getText().toString().trim();
                if( !Laptop_inchesS  .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setInches(Laptop_inchesS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }


                Laptop_hddS = Laptop_hdd.getText().toString().trim();
                if(           ! Laptop_hddS .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setHdd(Laptop_hddS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }


                Laptop_shddS = Laptop_shdd.getText().toString().trim();
                if(             !Laptop_shddS  .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setShdd(Laptop_shddS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                Laptop_osS = Laptop_os.getText().toString().trim();
                if(             !Laptop_osS  .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setOs(Laptop_osS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }



                Laptop_graphicS= Laptop_graphic.getText().toString().trim();
                if(           ! Laptop_graphicS  .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setGrapcard(Laptop_graphicS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }



                Laptop_dvdS = Laptop_dvd.getText().toString().trim();
                if(  !Laptop_dvdS .isEmpty())
                {
                    LaptopProfile obj=new LaptopProfile();
                    obj.setDvd(Laptop_dvdS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertLaptopetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }




                monitor_brandS= monitor_brand.getText().toString().trim();
                if(!monitor_brandS .isEmpty())
                {
                    MonitorProfile obj=new  MonitorProfile ();
                    obj.setBrandName(monitor_brandS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertMonitorDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                monitor_inchesS = monitor_inches.getText().toString().trim();
                if(   !monitor_inchesS  .isEmpty())
                {
                    MonitorProfile obj=new  MonitorProfile ();
                    obj.setInches(monitor_inchesS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertMonitorDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();


                }


                monitor_porSt = monitor_port.getText().toString().trim();
                if(           !monitor_porSt  .isEmpty())
                {
                    MonitorProfile obj=new  MonitorProfile ();
                    obj.setPort(monitor_porSt);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertMonitorDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                printer_brandnameS = printer_brandname.getText().toString().trim();
                if(          ! printer_brandnameS  .isEmpty())
                {
                  PrinterProfile obj=new  PrinterProfile  ();
                    obj.setBrandName(printer_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertPrinterDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                scanner_brandnameS = scanner_brandname.getText().toString().trim();
                if(          ! scanner_brandnameS  .isEmpty())
                {
                    ScannerProfile obj=new  ScannerProfile();
                    obj.setBrandList(scanner_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertScannerProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                scanner_typeS = scanner_type.getText().toString().trim();
                if(          ! scanner_typeS  .isEmpty())
                {
                    ScannerProfile obj=new  ScannerProfile();
                    obj.setTypeList(scanner_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertScannerProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }


                ups_brandnameS = ups_brandname.getText().toString().trim();
                if(          ! ups_brandnameS  .isEmpty())
                {
                   UPSProfile obj=new    UPSProfile();
                    obj.setBrandName(ups_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertUPSProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                ups_typeS = ups_type.getText().toString().trim();
                if(          ! ups_typeS  .isEmpty())
                {
                    UPSProfile obj=new    UPSProfile();
                    obj.setUpstype(ups_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertUPSProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                ups_capacityS = ups_capacity.getText().toString().trim();
                if(           !ups_capacityS  .isEmpty())
                {
                    UPSProfile obj=new    UPSProfile();
                    obj.setCapacityList(ups_capacityS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertUPSProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submiteda", Toast.LENGTH_LONG).show();

                }

                cpu_brandnamSe = cpu_brandname.getText().toString().trim();
                if(           !cpu_brandnamSe  .isEmpty())
                {
                   CPUProfile obj=new     CPUProfile();
                    obj.setBrandName(cpu_brandnamSe);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_typeS = cpu_type.getText().toString().trim();
                if(          ! cpu_typeS  .isEmpty())
                {
                    CPUProfile obj=new     CPUProfile();
                    obj.setProtypeList(cpu_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_genS = cpu_gen.getText().toString().trim();
                if(         !  cpu_genS  .isEmpty())
                {
                    CPUProfile obj=new     CPUProfile();
                    obj.setGen(cpu_genS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_ramS = cpu_ram.getText().toString().trim();
                if(         !  cpu_ramS  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setRam(cpu_ramS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_hddS = cpu_hdd.getText().toString().trim();
                if(         !  cpu_hddS  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setHdd(cpu_hddS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_shdds = cpu_shdd.getText().toString().trim();
                if(          !cpu_shdds  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setShdd( cpu_shdds);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_graphicsS = cpu_graphics.getText().toString().trim();
                if(          !cpu_graphicsS  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setGrapcard( cpu_graphicsS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_osS = cpu_os.getText().toString().trim();
                if(           !cpu_osS  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setOs(     cpu_osS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cpu_dvdS = cpu_dvd.getText().toString().trim();
                if(           !cpu_dvdS  .isEmpty())
                {
                    CPUProfile obj=new  CPUProfile();
                    obj.setDvd(       cpu_dvdS  );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCPUDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                router_brandnameS = router_brandname.getText().toString().trim();
                if(          !router_brandnameS  .isEmpty())
                {
                   RouterProfile obj=new  RouterProfile();
                    obj.setBrandName(  router_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRouterProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                router_typeS = router_type.getText().toString().trim();
                if(         !  router_typeS  .isEmpty())
                {
                    RouterProfile obj=new  RouterProfile();
                    obj.setType( router_typeS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRouterProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                router_portS = router_port.getText().toString().trim();
                if(           !router_portS  .isEmpty())
                {
                    RouterProfile obj=new  RouterProfile();
                    obj.setPort( router_portS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRouterProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                router_mbpsS = router_mbps.getText().toString().trim();
                if(          ! router_mbpsS  .isEmpty())
                {
                    RouterProfile obj=new  RouterProfile();
                    obj.setMbps( router_mbpsS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRouterProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                ram_brandnameS = ram_brandname.getText().toString().trim();
                if(           !ram_brandnameS  .isEmpty())
                {
                    RAMProfile obj=new RAMProfile();
                    obj.setBrandName( ram_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRamDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                ram_typS = ram_type.getText().toString().trim();
                if(         !  ram_typS  .isEmpty())
                {
                    RAMProfile obj=new RAMProfile();
                    obj.setTypeList( ram_typS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRamDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                ram_gbS = ram_gb.getText().toString().trim();
                if(          ! ram_gbS  .isEmpty())
                {
                    RAMProfile obj=new RAMProfile();
                    obj.setGb( ram_gbS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRamDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                cables_brandnameS = cables_brandname.getText().toString().trim();
                if(           !cables_brandnameS  .isEmpty())
                {
                    CablesProfile obj=new CablesProfile ();
                    obj.setBrandName( cables_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertCablesProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                gps_brandnameS = gps_brandname.getText().toString().trim();
                if(         !  gps_brandnameS  .isEmpty())
                {
                  GPSProfile obj=new GPSProfile  ();
                    obj.setBrandName( gps_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertGPSDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                xerox_brandnameS = xerox_brandname.getText().toString().trim();
                if(         !  xerox_brandnameS  .isEmpty())
                {
                    XeroxProfile obj=new  XeroxProfile  ();
                    obj.setBrandName( xerox_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertXeroxProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                xerox_ppmS = xerox_ppm.getText().toString().trim();
                if(          ! xerox_ppmS  .isEmpty())
                {
                    XeroxProfile obj=new  XeroxProfile  ();
                    obj.setPPMList(  xerox_ppmS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertXeroxProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                switch_brandnameS = switch_brandname.getText().toString().trim();
                if(           !switch_brandnameS  .isEmpty())
                {
                    SwitchProfile obj=new  SwitchProfile   ();
                    obj.setBrandName( switch_brandnameS  );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertSwitchProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                switch_ports = switch_port.getText().toString().trim();
                if(          ! switch_ports  .isEmpty())
                {
                    SwitchProfile obj=new  SwitchProfile   ();
                    obj.setPort( switch_ports );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertSwitchProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                switch_typeS = switch_type.getText().toString().trim();
                if(          ! switch_typeS  .isEmpty())
                {
                    SwitchProfile obj=new  SwitchProfile   ();
                    obj.setType(  switch_typeS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertSwitchProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                tv_brandnameS = tv_brandname.getText().toString().trim();
                if(        !   tv_brandnameS  .isEmpty())
                {
                   TVProfile obj=new   TVProfile   ();
                    obj.setBrandName(  tv_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertTVProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                tv_inchesS = tv_inches.getText().toString().trim();
                if(  ! tv_inchesS  .isEmpty())
                {
                    TVProfile obj=new   TVProfile   ();
                    obj.setInchesList(  tv_inchesS  );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertTVProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                wifiLan_brandnameS = wifiLan_brandname.getText().toString().trim();
                if(        !   wifiLan_brandnameS  .isEmpty())
                {
                    wifi_LanProfile obj=new  wifi_LanProfile ();
                    obj.setBrandName( wifiLan_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertwifi_LanProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                wifiLan_mbpsS = wifiLan_mbps.getText().toString().trim();
                if(           !wifiLan_mbpsS  .isEmpty())
                {
                    wifi_LanProfile obj=new  wifi_LanProfile ();
                    obj.setMbps(   wifiLan_mbpsS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertwifi_LanProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                wifidongle_brandnameS = wifidongle_brandname.getText().toString().trim();
                if(          ! wifidongle_brandnameS  .isEmpty())
                {    wifi_dongleProfile obj=new  wifi_dongleProfile();
                     obj.setBrandName(wifidongle_brandnameS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertwifi_dongleProfileDetails(obj);

                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                wifidongle_typeS = wifidongle_type.getText().toString().trim();
                if( !  wifidongle_typeS  .isEmpty())
                {
                    wifi_dongleProfile obj=new  wifi_dongleProfile();
                    obj.setTypeList(wifidongle_typeS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertwifi_dongleProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }

                tablet_brandnameS = tablet_brandname.getText().toString().trim();
                if( !  tablet_brandnameS  .isEmpty())
                {
                    TabletProfile obj=new   TabletProfile  ();
                    obj.setBrandName( tablet_brandnameS );
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertTabletProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }


                tablet_inchesS = tablet_inches.getText().toString().trim();
                if( !tablet_inchesS  .isEmpty())
                {
                    TabletProfile obj=new   TabletProfile  ();
                    obj.setInchesList(  tablet_inchesS);
                    DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertTabletProfileDetails(obj);
                    Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_LONG).show();

                }













            }
        });


    }

}
