package com.oswal.stockmangmentnew;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.oswal.stockmangmentnew.AdminActivity.AddItemSpinner;
import com.oswal.stockmangmentnew.LoginModule.LoginPage;
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
import com.oswal.stockmangmentnew.OnlineDBSync.GetSupplierDetailsSync;
import com.oswal.stockmangmentnew.Services.Customer.CustomerMainActivity;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;
import com.oswal.stockmangmentnew.Services.Items.view_item;
import com.oswal.stockmangmentnew.Services.StockIn.Stock_IN_View;
import com.oswal.stockmangmentnew.Services.StockIn.Stock_in;
import com.oswal.stockmangmentnew.Services.Return.Damage;
import com.oswal.stockmangmentnew.Services.Return.Return;
import com.oswal.stockmangmentnew.Services.StockOut.Stock_Out_View;
import com.oswal.stockmangmentnew.Services.StockOut.stock_OUT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.oswal.stockmangmentnew.Services.Supplier.DistrictMainActivity;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    DatabaseHelper db = null;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    private Object MouseProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);


        insertCommonDataToDB(db);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //KeyboardProfile
    private void insertCommonDataToDB(DatabaseHelper db) {
        Toast.makeText(getApplicationContext(), "insertCommonDataToDB", Toast.LENGTH_LONG).show();
        JSONObject json = new JSONObject();
        String brandListarrayList = null,  typeListarrayList = null;
        try {
            json.put("brandList", new JSONArray(getResources().getStringArray(R.array.keyboard_brandList)));
            brandListarrayList = json.toString();

            json.put("typeList", new JSONArray(getResources().getStringArray(R.array.keyboard_typeList)));
            typeListarrayList = json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        KeyboardProfile keyboardProfile = new KeyboardProfile();
        keyboardProfile.setBrandList(brandListarrayList);
        keyboardProfile.setTypeList(typeListarrayList);

        if (db.getKeyboardProfileCount() > 0) {
            db.deleteKeyboardProfileList();
        }
        db.insertKeyboardDetails(keyboardProfile);

        //Keyboard end

        //CPU Profile
        JSONObject jsonCPUProfile = new JSONObject();
        String brandListCPUProfile = null, processortypeListCPUProfile = null, genrationListCPUProfile = null, RAMListCPUProfile = null, HDDListCPUProfile = null, SHDDListCPUProfile = null, osListCPUProfile = null, GraphiccardListCPUProfile = null, DVDwriterListtCPUProfile = null;
        try {
            jsonCPUProfile.put("brandListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_brandList)));
            brandListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("processortypeListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_typeList)));
            processortypeListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("genrationListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_genrationList)));
            genrationListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("RAMListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_ramList)));
            RAMListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("HDDListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_HDDList)));
            HDDListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("SHDDListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_SHDDList)));
            SHDDListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("OsListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_osList)));
            osListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("GraphiccardListCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_GraphiccardList)));
            GraphiccardListCPUProfile = jsonCPUProfile.toString();

            jsonCPUProfile.put("DVDwriterListtCPUProfile", new JSONArray(getResources().getStringArray(R.array.Cpu_DVDList)));
            DVDwriterListtCPUProfile = jsonCPUProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CPUProfile cpuProfile = new CPUProfile();
        cpuProfile.setBrandName(brandListCPUProfile);
        cpuProfile.setProtypeList(processortypeListCPUProfile);
        cpuProfile.setGen(genrationListCPUProfile);
        cpuProfile.setRam(RAMListCPUProfile);
        cpuProfile.setHdd(HDDListCPUProfile);
        cpuProfile.setShdd(SHDDListCPUProfile);
        cpuProfile.setOs(osListCPUProfile);
        cpuProfile.setGrapcard(GraphiccardListCPUProfile);
        cpuProfile.setDvd(DVDwriterListtCPUProfile);

        if (db.getCPUProfileCount() > 0) {
            db.deleteCPUProfileList();
        }
        db.insertCPUDetails(cpuProfile);
        //Cpu End



        //Mouse Profile
        JSONObject jsonMouseProfile= new JSONObject();
        String brandListMouseProfile = null,  typeListMouseProfile = null;
        try {
            jsonMouseProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.mouse_brandList)));
            brandListMouseProfile = jsonMouseProfile.toString();

            jsonMouseProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.mouse_typeList)));
            typeListMouseProfile = jsonMouseProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MouseProfile mouseProfile = new MouseProfile();
        mouseProfile.setBrandName(brandListMouseProfile);
        mouseProfile.setTypeList(typeListMouseProfile);

        if (db.getMouseProfileCount() > 0) {
            db.deleteMouseProfileList();
        }
        db.insertMouseDetails(mouseProfile);

        //Mouse end


        //Laptop Profile
        JSONObject jsonLaptopProfile = new JSONObject();
        String brandListLaptopProfile = null, processortypeListLaptopProfile = null, genrationListLaptopProfile = null, RAMListLaptopProfile = null,InchesLaptopProfile=null, HDDListLaptopProfile = null, SHDDListLaptopProfile = null, osListLaptopProfile = null, GraphiccardListLaptopProfile = null, DVDwriterListtLaptopProfile = null;
        try {
            jsonLaptopProfile.put("brandListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_brandList)));
            brandListLaptopProfile = jsonLaptopProfile.toString();


            jsonLaptopProfile.put("processortypeLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_typeList)));
            processortypeListLaptopProfile = jsonLaptopProfile.toString();


            jsonLaptopProfile.put("genrationListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_genrationList)));
            genrationListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("RamListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_ramList)));
            RAMListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("InchesListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_inchesList)));
            InchesLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("HDDListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_HDDList)));
            HDDListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("SHDDListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_SHDDList)));
            SHDDListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("OsListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_osList)));
            osListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("GraphiccardListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_GraphiccardList)));
            GraphiccardListLaptopProfile = jsonLaptopProfile.toString();

            jsonLaptopProfile.put("DVDwriterListLaptopProfile", new JSONArray(getResources().getStringArray(R.array.Laptop_DVDList)));
            DVDwriterListtLaptopProfile = jsonLaptopProfile.toString();


        } catch (JSONException e) {
            e.printStackTrace();
        }

     LaptopProfile laptopProfile= new  LaptopProfile();
        laptopProfile.setBrandName(brandListLaptopProfile);
        laptopProfile.setProtypeList(processortypeListLaptopProfile);
        laptopProfile.setGen(genrationListLaptopProfile);
        laptopProfile.setRam(RAMListLaptopProfile);
        laptopProfile.setHdd(InchesLaptopProfile);
        laptopProfile.setShdd(HDDListLaptopProfile);
        laptopProfile.setOs(SHDDListLaptopProfile);
        laptopProfile.setGrapcard(osListLaptopProfile);
        laptopProfile.setDvd(GraphiccardListLaptopProfile);
        laptopProfile.setDvd(DVDwriterListtLaptopProfile);


        if (db.getLaptopProfileCount() > 0) {
            db.deleteLaptopProfileList();
        }
        db.insertLaptopetails(laptopProfile);
        //Laptop End



        //Monitor Profile
        JSONObject jsonMonitoProfile= new JSONObject();
        String brandListMonitoProfile = null,  ichesListMouseProfile = null,portListMouseProfile=null;
        try {
            jsonMonitoProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Monitor_brandList)));
            brandListMonitoProfile = jsonMonitoProfile.toString();

            jsonMonitoProfile.put("portList", new JSONArray(getResources().getStringArray(R.array.Monitor_PortList)));
            ichesListMouseProfile = jsonMonitoProfile.toString();

            jsonMonitoProfile.put("inchesList", new JSONArray(getResources().getStringArray(R.array.Monitor_InchesList)));
            portListMouseProfile = jsonMonitoProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MonitorProfile monitorProfile = new MonitorProfile();
        monitorProfile.setBrandName(brandListMonitoProfile);
        monitorProfile.setPort(portListMouseProfile);
        monitorProfile.setInches(ichesListMouseProfile);

        if (db.getMonitorProfileCount() > 0) {
            db.deleteMonitorProfileList();
        }
        db.insertMonitorDetails(monitorProfile);

        //Monitor end


        //Printer Profile
        JSONObject jsonPrinterProfile= new JSONObject();
        String brandListPrinterProfile = null;
        try {
            jsonPrinterProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Printer_brandList)));
            brandListPrinterProfile = jsonPrinterProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        PrinterProfile printerProfile = new PrinterProfile();
            printerProfile.setBrandName(brandListPrinterProfile);

            if (db.getprinterProfileCount()> 0) {
                db.deletePrinterProfileList();
            }
            db.insertPrinterDetails(printerProfile);

            //printer end

        //Scanner Profile
        JSONObject jsonScannerProfile= new JSONObject();
        String brandListScannerProfile = null,  typeListScannerProfile = null;
        try {
            jsonScannerProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Scanner_brandList)));
            brandListScannerProfile = jsonScannerProfile.toString();

            jsonScannerProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.Scanner_typeList)));
            typeListScannerProfile = jsonScannerProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

       ScannerProfile scannerProfile = new ScannerProfile();
        scannerProfile.setBrandList(brandListScannerProfile);
        scannerProfile.setTypeList(typeListScannerProfile);

        if (db.getScannerProfileCount() > 0) {
            db.deleteScannerProfileList();
        }
        db.insertScannerProfileDetails(scannerProfile);

        //Scanner end


        //UPS Profile
        JSONObject jsonUPSProfile= new JSONObject();
        String brandListUPSProfile = null,  typeListUPSProfile = null,capacityListUPSProfile=null;
        try {
            jsonUPSProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.UPS_brandList)));
            brandListUPSProfile = jsonUPSProfile.toString();

            jsonUPSProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.UPS_typeList)));
            typeListUPSProfile = jsonUPSProfile.toString();

            jsonUPSProfile.put("capacityList", new JSONArray(getResources().getStringArray(R.array.UPS_capacityList)));
            capacityListUPSProfile = jsonUPSProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

      UPSProfile upsProfile = new UPSProfile();
        upsProfile.setBrandName(brandListUPSProfile);
        upsProfile.setUpstype(typeListUPSProfile);
        upsProfile.setUpstype(capacityListUPSProfile);

        if (db.getUPSProfileCount() > 0) {
            db.deleteUPSProfileList();
        }
        db.insertUPSProfileDetails(upsProfile);

        //UPS end


        //Router Profile
        JSONObject jsonRouterProfile= new JSONObject();
        String brandListRouterProfile = null,  typeListRouterProfile = null,portListRouterProfile=null,mbpsListRouterProfile=null;
        try {
            jsonRouterProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Router_brandList)));
            brandListRouterProfile = jsonRouterProfile.toString();

            jsonRouterProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.Router_typeList)));
            typeListRouterProfile = jsonRouterProfile.toString();

            jsonRouterProfile.put("capacityList", new JSONArray(getResources().getStringArray(R.array.Router_portList)));
            portListRouterProfile = jsonRouterProfile.toString();

            jsonRouterProfile.put("MbpsList", new JSONArray(getResources().getStringArray(R.array.Router_mbpsList)));
            mbpsListRouterProfile = jsonRouterProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

       RouterProfile routerProfile = new RouterProfile();
        routerProfile.setBrandName(brandListRouterProfile);
        routerProfile.setType(typeListRouterProfile);
        routerProfile.setPort(portListRouterProfile);
        routerProfile.setMbps(mbpsListRouterProfile);


        if (db.getRouterProfileCount() > 0) {
            db.deleteRouterProfileList();
        }
        db.insertRouterProfileDetails(routerProfile);

        //Router end



        //Wifidongle Profile
        JSONObject jsonWifidongleProfile= new JSONObject();
        String brandListWifidongleProfile = null,  typeListWifidongleProfile = null;
        try {
            jsonWifidongleProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Wifidongle_brandList)));
            brandListWifidongleProfile = jsonWifidongleProfile.toString();

            jsonWifidongleProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.Wifidongle_typeList)));
            typeListWifidongleProfile = jsonWifidongleProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

wifi_dongleProfile wifidongleProfile = new wifi_dongleProfile ();
        wifidongleProfile.setBrandName(brandListWifidongleProfile);
        wifidongleProfile.setTypeList(typeListWifidongleProfile);

        if (db.getwifi_dongleProfileCount() > 0) {
            db.deletewifi_dongleProfileList();
        }
        db.insertwifi_dongleProfileDetails(wifidongleProfile);

        //Wifidongle end


        //RAM Profile
        JSONObject jsonRAmProfile= new JSONObject();
        String brandListRAMProfile = null,  typeListRAMProfile = null,GBListRAMProfile=null;
        try {
            jsonRAmProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.RAM_brandList)));
            brandListRAMProfile = jsonRAmProfile.toString();

            jsonRAmProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.RAM_typeList)));
            typeListRAMProfile = jsonRAmProfile.toString();

            jsonRAmProfile.put("GBList", new JSONArray(getResources().getStringArray(R.array.RAM_GBList)));
            GBListRAMProfile = jsonRAmProfile.toString();


        } catch (JSONException e) {
            e.printStackTrace();
        }

   RAMProfile ramProfile = new   RAMProfile();
        ramProfile.setBrandName(brandListRAMProfile);
        ramProfile.setTypeList(typeListRAMProfile);
        ramProfile.setGb(GBListRAMProfile);



        if (db.getRAMProfileCount() > 0) {
            db.deleteRAMProfileList();
        }
        db.insertRAMProfileDetails(ramProfile);

        //RAM end


        //GPS-tracking Profile
        JSONObject jsonGPSProfile= new JSONObject();
        String brandListGPSProfile = null;
        try {
            jsonGPSProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.GPS_brandList)));
            brandListGPSProfile = jsonGPSProfile.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }


  GPSProfile gpsProfile = new GPSProfile();
        gpsProfile.setBrandName(brandListGPSProfile);

        if (db.getGPSProfileCount()> 0) {
            db.deleteGPSProfileList();
        }
        db.insertGPSDetails(gpsProfile);

        //GPS end

        //Xerox Profile
        JSONObject jsonXeroxProfile= new JSONObject();
        String brandListXeroxProfile = null,ppmListXeroxProfile=null;
        try {
            jsonXeroxProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Xerox_brandList)));
            brandListXeroxProfile = jsonXeroxProfile.toString();

            jsonXeroxProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Xerox_ppmList)));
            ppmListXeroxProfile = jsonXeroxProfile.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

XeroxProfile xeroxProfile = new XeroxProfile ();
        xeroxProfile.setBrandName(brandListXeroxProfile);
        xeroxProfile.setBrandName(ppmListXeroxProfile);

        if (db.getXeroxProfileCount()> 0) {
            db.deleteXeroxProfileList();
        }
        db.insertXeroxProfileDetails(xeroxProfile);

        //Xerox end


              //Switch Profile

        JSONObject jsonSwitchProfile= new JSONObject();
        String brandListSwitchProfile = null,  typeListSwitchProfile = null,portListSwitchProfile=null;
        try {
            jsonSwitchProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Switch_brandList)));
            brandListSwitchProfile = jsonSwitchProfile.toString();

            jsonSwitchProfile.put("typeList", new JSONArray(getResources().getStringArray(R.array.Switch_typeList)));
            typeListSwitchProfile = jsonSwitchProfile.toString();

            jsonSwitchProfile.put("PortList", new JSONArray(getResources().getStringArray(R.array.Switch_portList)));
            portListSwitchProfile = jsonSwitchProfile.toString();


        } catch (JSONException e) {
            e.printStackTrace();
        }

        SwitchProfile switchProfile = new     SwitchProfile();
        switchProfile.setBrandName(brandListSwitchProfile);
        switchProfile.setType(typeListSwitchProfile);
        switchProfile.setPort(portListSwitchProfile);


        if (db.getSwitchProfileCount() > 0) {
            db.deleteSwitchProfileList();
        }
        db.insertSwitchProfileDetails(switchProfile);

        //Switch end


        //Tablet Profile

        JSONObject jsonTabletProfile= new JSONObject();
        String brandListTabletProfile = null, inchesListTabletProfile = null;
        try {
            jsonTabletProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Tablet_brandList)));
            brandListTabletProfile = jsonTabletProfile.toString();

            jsonTabletProfile.put("inchesList", new JSONArray(getResources().getStringArray(R.array.Tablet_inchesList)));
            inchesListTabletProfile = jsonTabletProfile.toString();



        } catch (JSONException e) {
            e.printStackTrace();
        }

        TabletProfile tabletProfile = new     TabletProfile ();
        tabletProfile.setBrandName(brandListTabletProfile);

        tabletProfile.setInchesList(inchesListTabletProfile);


        if (db.getTabletProfileCount() > 0) {
            db.deleteTabletProfileList();
        }
        db.insertTabletProfileDetails(tabletProfile);

        //Tablet ends


        //TV Profile

        JSONObject jsonTVtProfile= new JSONObject();
        String brandListTVtProfile = null, inchesListTVProfile = null;
        try {
            jsonTVtProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.TV_brandList)));
            brandListTVtProfile = jsonTVtProfile.toString();

            jsonTVtProfile.put("inchesList", new JSONArray(getResources().getStringArray(R.array.TV_inchesList)));
            inchesListTVProfile = jsonTVtProfile.toString();



        } catch (JSONException e) {
            e.printStackTrace();
        }

  TVProfile tvProfile = new TVProfile ();
        tvProfile.setBrandName(brandListTVtProfile);

        tvProfile.setInchesList(inchesListTVProfile);


        if (db.getTVProfileCount() > 0) {
            db.deleteTVProfileList();
        }
        db.insertTVProfileDetails(tvProfile);

        //TV ends



        //WifiLan Profile

        JSONObject jsonWifiLanProfile= new JSONObject();
        String brandListWifiLanProfile = null, mbpsListWifiLanProfile = null;
        try {
            jsonWifiLanProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.WifiLan_brandList)));
            brandListWifiLanProfile = jsonWifiLanProfile.toString();

            jsonWifiLanProfile.put("MbpsList", new JSONArray(getResources().getStringArray(R.array.WifiLan_mbpsList)));
            mbpsListWifiLanProfile = jsonWifiLanProfile.toString();



        } catch (JSONException e) {
            e.printStackTrace();
        }

        wifi_LanProfile wifiLanProfile = new  wifi_LanProfile ();
        wifiLanProfile.setBrandName(brandListWifiLanProfile);

        wifiLanProfile.setMbps(mbpsListWifiLanProfile);


        if (db.getwifi_LanProfileCount() > 0) {
            db.deletewifi_LanProfileList();
        }
        db.insertwifi_LanProfileDetails(wifiLanProfile);

        //WifiLan end


        //Cables Start
        JSONObject jsonCablesProfile= new JSONObject();
        String brandListCablesProfile = null;
        try {
            jsonCablesProfile.put("brandList", new JSONArray(getResources().getStringArray(R.array.Cables_brandList)));
            brandListCablesProfile = jsonCablesProfile.toString();




        } catch (JSONException e) {
            e.printStackTrace();
        }
        CablesProfile cablesProfile = new CablesProfile();
        cablesProfile.setBrandName(brandListCablesProfile);



        if (db.getCablesProfileCount() > 0) {
            db.deleteCablesProfileList();
        }
        db.insertCablesProfileDetails(cablesProfile);

        //Cabels ends




    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }
        if (id == R.id.action_settings2) {
            Intent mainActivity = new Intent(MainActivity.this, LoginPage.class);
            startActivity(mainActivity);
        } else if (id == R.id.refreshContact) {
            //Sync Contact List
            GetSupplierDetailsSync syncList = new GetSupplierDetailsSync();
            Toast.makeText(getApplicationContext(), "Refreshing Please hold on ", Toast.LENGTH_LONG).show();
            //syncContactList.startFunction(db,getApplicationContext());
            syncList.startSyncyContact(db);

            //End
        } else if (id == R.id.homeActionmenu) {
            Toast.makeText(getApplicationContext(), "Home Sweet Home", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.item) {
            Toast.makeText(getApplicationContext(), "Show Item Page Here ", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.supplier) {
            Intent intent = new Intent(MainActivity.this, Stock_IN_View.class);
            startActivity(intent);

        } else if (id == R.id.customer) {
            Intent intent = new Intent(MainActivity.this, stock_OUT.class);
            startActivity(intent);

        } else if (id == R.id.stockin) {
            Intent intent = new Intent(MainActivity.this, Stock_Out_View.class);
            startActivity(intent);

        } else if (id == R.id.stockout) {

            Intent intent = new Intent(MainActivity.this, view_item.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            Intent intent = new Intent(MainActivity.this, Add_Item.class);
            startActivity(intent);
        } else if (id == R.id.retun) {
            Intent intent = new Intent(MainActivity.this, customer_List.class);
            startActivity(intent);
        } /*else if (id == R.id.damage) {
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);

        }*/ else if (id == R.id.qrCode) {
            Intent intent = new Intent(MainActivity.this, AddItemSpinner.class);
            startActivity(intent);
        } else if (id == R.id.adminActivty) {
            Intent intent = new Intent(MainActivity.this, AddItemSpinner.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("Item", true, true, "item");
        headerList.add(menuModel);

        List<MenuModel> item_childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("Add", false, false, "item add");
        item_childModelsList.add(childModel);

        childModel = new MenuModel("View", false, false, "item view");
        item_childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, item_childModelsList);
        }


        /*if (!itemmenuModel.hasChildren) {
            childList.put(itemmenuModel, null);
        }*/

        menuModel = new MenuModel("Supplier", true, false, "supplier");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Customer", true, false, "customer");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Stock IN", true, true, "stock in");
        headerList.add(menuModel);

        List<MenuModel> stockIN_childModelsList = new ArrayList<>();
        MenuModel stockIN_childModel = new MenuModel("Add", false, false, "stock in add");
        stockIN_childModelsList.add(stockIN_childModel);

        stockIN_childModel = new MenuModel("View", false, false, "stock in view");
        stockIN_childModelsList.add(stockIN_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, stockIN_childModelsList);
        }

        menuModel = new MenuModel("Stock Out", true, true, "stock out");
        headerList.add(menuModel);

        List<MenuModel> stockOut_childModelsList = new ArrayList<>();
        MenuModel stockOut_childModel = new MenuModel("Add", false, false, "stock out add");
        stockOut_childModelsList.add(stockOut_childModel);

        stockOut_childModel = new MenuModel("View", false, false, "stock out view");
        stockOut_childModelsList.add(stockOut_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, stockOut_childModelsList);
        }

        menuModel = new MenuModel("Return", true, true, "return");
        headerList.add(menuModel);

        List<MenuModel> return_childModelsList = new ArrayList<>();
        MenuModel return_childModel = new MenuModel("Add", false, false, "return add");
        return_childModelsList.add(return_childModel);

        return_childModel = new MenuModel("View", false, false, "return view");
        return_childModelsList.add(return_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, return_childModelsList);
        }

        /*menuModel = new MenuModel("Damage", true, true, "damage");
        headerList.add(menuModel);

        List<MenuModel> damage_childModelsList = new ArrayList<>();
        MenuModel damage_childModel = new MenuModel("Add", false, false, "damage add");
        damage_childModelsList.add(damage_childModel);

        damage_childModel = new MenuModel("View", false, false, "damage view");
        damage_childModelsList.add(damage_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, damage_childModelsList);
        }*/

        menuModel = new MenuModel("QR Code", true, false, "qrCode");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Admin Acitivity", true, false, "adminActivity");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }
    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        Toast.makeText(getApplicationContext(), "Selected Menu " + headerList.get(groupPosition).url, Toast.LENGTH_SHORT).show();
                        openPage(headerList.get(groupPosition).url);
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.url.length() > 0) {
                        Toast.makeText(getApplicationContext(), "Child Selected Menu " + model.url, Toast.LENGTH_SHORT).show();
                        openPage(model.url);
                        onBackPressed();
                    }
                }

                return false;
            }
        });
    }


    private void openPage(String pageName) {

        if (pageName.contains("item add")) {
            Toast.makeText(getApplicationContext(), "Show Item Page Add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, com.oswal.stockmangmentnew.Services.Items.Add_Item.class);
            startActivity(intent);

        } else if (pageName.contains("item view")) {

            Intent intent = new Intent(MainActivity.this, view_item.class);
            startActivity(intent);

        } else if (pageName.contains("supplier")) {
            //Intent intent = new Intent(MainActivity.this, supplier_List.class);
            Intent intent = new Intent(MainActivity.this, DistrictMainActivity.class);
            startActivity(intent);

        } else if (pageName.contains("customer")) {
            //Intent intent = new Intent(MainActivity.this, customer_List.class);
            Intent intent = new Intent(MainActivity.this, CustomerMainActivity.class);
            startActivity(intent);

        } else if (pageName.contains("stock in add")) {
            Toast.makeText(getApplicationContext(), "stock in add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_in.class);
            startActivity(intent);
        } else if (pageName.contains("stock in view")) {
            Toast.makeText(getApplicationContext(), "stock in view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_IN_View.class);
            startActivity(intent);

        } else if (pageName.contains("stock out add")) {
            Toast.makeText(getApplicationContext(), "stock out add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, stock_OUT.class);
            startActivity(intent);
        } else if (pageName.contains("stock out view")) {
            Toast.makeText(getApplicationContext(), "stock out view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_Out_View.class);
            startActivity(intent);
        } else if (pageName.contains("return add")) {

            Toast.makeText(getApplicationContext(), "return add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Return.class);
            startActivity(intent);

        } else if (pageName.contains("return view")) {
            Toast.makeText(getApplicationContext(), "return view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Return.class);
            startActivity(intent);
        } else if (pageName.contains("damage add")) {
            Toast.makeText(getApplicationContext(), "damage add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);
        } else if (pageName.contains("damage view")) {
            Toast.makeText(getApplicationContext(), "damage view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);
        } else if (pageName.contains("qrCode")) {
            Intent intent = new Intent(MainActivity.this, com.oswal.stockmangmentnew.QRcodeModule.MainActivity.class);
            startActivity(intent);
        } else if (pageName.contains("adminActivity")) {
            Intent intent = new Intent(MainActivity.this, AddItemSpinner.class);
            startActivity(intent);
        }
    }
}
