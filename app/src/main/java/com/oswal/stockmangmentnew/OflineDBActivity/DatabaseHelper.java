package com.oswal.stockmangmentnew.OflineDBActivity;

/**
 * Created by abhishek on 24/03/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.oswal.stockmangmentnew.OflineDBActivity.model.CPUProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.CablesProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.CustomerProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.GPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.LaptopProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MonitorProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.MouseProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.PrinterProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.RAMProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.RouterProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.ScannerProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.SupplierProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.SwitchProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TVProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.TabletProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.UPSProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.XeroxProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_LanProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.wifi_dongleProfile;
import com.oswal.stockmangmentnew.POJO.Customer;
import com.oswal.stockmangmentnew.POJO.Supplier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Abhishek on 23/08/19.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    String databasePath;
    SQLiteDatabase sampleDB;
    // Database Name
    private static final String DATABASE_NAME = "StockManagement.db";


    public String getDatabasePath() {
        return databasePath;
    }

    public DatabaseHelper(final Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "com.oswal.stockmangmentnew"
                + File.separator + DATABASE_NAME, null, DATABASE_VERSION);


        Log.d("Abhishek ------>", Environment.getExternalStorageDirectory()
                + File.separator + "com.oswal.stockmangmentnew"
                + File.separator + DATABASE_NAME);
        SQLiteDatabase.openOrCreateDatabase(context.getDatabasePath(DATABASE_NAME).getPath().toString(), null);
    }


    public static String getDBName() {
        return DATABASE_NAME;
    }

    public void createTables(String table) {
        sampleDB.execSQL(table);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SupplierProfile.CREATE_TABLE);
            db.execSQL(CustomerProfile.CREATE_TABLE);
            db.execSQL(KeyboardProfile.CREATE_TABLE);
            db.execSQL(CPUProfile.CREATE_TABLE);
            db.execSQL(CablesProfile.CREATE_TABLE);
            db.execSQL(GPSProfile.CREATE_TABLE);
            db.execSQL(LaptopProfile.CREATE_TABLE);
            db.execSQL(MonitorProfile.CREATE_TABLE);
            db.execSQL(MouseProfile.CREATE_TABLE);
            db.execSQL(PrinterProfile.CREATE_TABLE);
            db.execSQL(RAMProfile.CREATE_TABLE);
            db.execSQL(RouterProfile.CREATE_TABLE);
            db.execSQL(ScannerProfile.CREATE_TABLE);
            db.execSQL(SwitchProfile.CREATE_TABLE);
            db.execSQL(TabletProfile.CREATE_TABLE);
            db.execSQL(TVProfile.CREATE_TABLE);
            db.execSQL(UPSProfile.CREATE_TABLE);
            db.execSQL(wifi_dongleProfile.CREATE_TABLE);
            db.execSQL(wifi_LanProfile.CREATE_TABLE);
            db.execSQL(XeroxProfile.CREATE_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error------------>", e.getMessage());
        }
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + SupplierProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CustomerProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KeyboardProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CPUProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GPSProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CablesProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LaptopProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MonitorProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MouseProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PrinterProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RAMProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RouterProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScannerProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SwitchProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TabletProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TVProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UPSProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + wifi_dongleProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + wifi_LanProfile.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + XeroxProfile.TABLE_NAME);
        System.out.println("Abhishek Droping All TAble------------------------------");
        onCreate(db);
    }


    public ArrayList<String> allTableName() {
        ArrayList<String> arrTblNames = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                arrTblNames.add(c.getString(c.getColumnIndex("name")));
                c.moveToNext();
            }
        }
        return arrTblNames;
    }

    public long insertSupplierDetails(Supplier temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SupplierProfile.COLUMN_Name, temp.getName());
        values.put(SupplierProfile.COLUMN_Personal_mobile, temp.getContact_number());
        values.put(SupplierProfile.COLUMN_Address, temp.getAddress());

        // insert row
        long id = db.insert(SupplierProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For Supplier
    public List<Supplier> getAllSupplierDetails() {
        List<Supplier> supplierListDetails = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + SupplierProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Supplier supplierDetails = new Supplier();

                supplierDetails.setName(cursor.getString(cursor.getColumnIndex(SupplierProfile.COLUMN_Name)));
                supplierDetails.setContact_number(cursor.getString(cursor.getColumnIndex(SupplierProfile.COLUMN_Personal_mobile)));
                supplierDetails.setAddress(cursor.getString(cursor.getColumnIndex(SupplierProfile.COLUMN_Address)));
                supplierListDetails.add(supplierDetails);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return supplierListDetails;
    }

    public long getSupplierCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, SupplierProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteSupplierList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + SupplierProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //CustomerActivity
    public long insertCustomerDetails(Customer temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CustomerProfile.COLUMN_Name, temp.getName());
        values.put(CustomerProfile.COLUMN_Personal_mobile, temp.getContact_number());
        values.put(CustomerProfile.COLUMN_Address, temp.getAddress());

        // insert row
        long id = db.insert(CustomerProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For Supplier
    public List<Customer> getAllCustomerDetails() {
        List<Customer> customerListDetails = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + CustomerProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Customer customerDetails = new Customer();

                customerDetails.setName(cursor.getString(cursor.getColumnIndex(CustomerProfile.COLUMN_Name)));
                customerDetails.setContact_number(cursor.getString(cursor.getColumnIndex(CustomerProfile.COLUMN_Personal_mobile)));
                customerDetails.setAddress(cursor.getString(cursor.getColumnIndex(CustomerProfile.COLUMN_Address)));
                customerListDetails.add(customerDetails);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return customerListDetails;
    }

    public long getCustomerCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, CustomerProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteCustomerList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + CustomerProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


//KeyBoard Profile

    public long insertKeyboardDetails(KeyboardProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KeyboardProfile.COLUMN_Brand_Name, temp.getBrandList());
        values.put(KeyboardProfile.COLUMN_TypeList, temp.getTypeList());

        // insert row
        long id = db.insert(KeyboardProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllKeyboardProfileDetails
    public KeyboardProfile getAllKeyboardProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + KeyboardProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        KeyboardProfile keyboardProfileDetails = new KeyboardProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            keyboardProfileDetails.setBrandList(cursor.getString(cursor.getColumnIndex(KeyboardProfile.COLUMN_Brand_Name)));
            keyboardProfileDetails.setTypeList(cursor.getString(cursor.getColumnIndex(KeyboardProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return keyboardProfileDetails;
    }

    public long getKeyboardProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, KeyboardProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteKeyboardProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + KeyboardProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //CPU  Profile

    public long insertCPUDetails(CPUProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CPUProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(CPUProfile.COLUMN_ProcessorTypeList, temp.getProtypeList());
        values.put(CPUProfile.COLUMN_GenrationList, temp.getGen());
        values.put(CPUProfile.COLUMN_RAMList, temp.getRam());
        values.put(CPUProfile.COLUMN_HDDList, temp.getHdd());
        values.put(CPUProfile.COLUMN_SHDDList, temp.getShdd());
        values.put(CPUProfile.COLUMN_osList, temp.getOs());
        values.put(CPUProfile.COLUMN_GraphiccardList, temp.getGrapcard());
        values.put(CPUProfile.COLUMN_DVDwriterList, temp.getDvd());

        // insert row
        long id = db.insert(CPUProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllKeyboardProfileDetails
    public CPUProfile getAllCPUProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CPUProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        CPUProfile CPUProfileDetails = new CPUProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            CPUProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_Brand_Name)));
            CPUProfileDetails.setProtypeList(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_ProcessorTypeList)));
            CPUProfileDetails.setGen(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_GenrationList)));
            CPUProfileDetails.setRam(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_RAMList)));
            CPUProfileDetails.setHdd(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_HDDList)));
            CPUProfileDetails.setShdd(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_SHDDList)));
            CPUProfileDetails.setOs(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_osList)));
            CPUProfileDetails.setGrapcard(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_GraphiccardList)));
            CPUProfileDetails.setDvd(cursor.getString(cursor.getColumnIndex(CPUProfile.COLUMN_DVDwriterList)));
        }
        // close db connection
        db.close();

        // return notes list
        return CPUProfileDetails;
    }

    public long getCPUProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, CPUProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteCPUProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + CPUProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //Start GPS Profile

    public long insertGPSDetails(GPSProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(GPSProfile.COLUMN_Brand_Name, temp.getBrandName());

        // insert row
        long id = db.insert(GPSProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllGPSProfileDetails
    public GPSProfile getAllGPSProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + GPSProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        GPSProfile GPSProfileDetails = new GPSProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            GPSProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(GPSProfile.COLUMN_Brand_Name)));
        }
        // close db connection
        db.close();

        // return notes list
        return GPSProfileDetails;
    }

    public long getGPSProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, GPSProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteGPSProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + GPSProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //Start Cables Profile

    public long insertCablesProfileDetails(CablesProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CablesProfile.COLUMN_Brand_Name, temp.getBrandName());

        // insert row
        long id = db.insert(CablesProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllGPSProfileDetails
    public CablesProfile getAllCablesProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CablesProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
      CablesProfile CablesProfileDetails = new CablesProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            CablesProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(CablesProfile.COLUMN_Brand_Name)));
        }
        // close db connection
        db.close();

        // return notes list
        return CablesProfileDetails;
    }

    public long getCablesProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, CablesProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteCablesProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + CablesProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }



    //start Laptop  Profile

    public long insertLaptopetails(LaptopProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LaptopProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(LaptopProfile.COLUMN_ProcessorTypeList, temp.getProtypeList());
        values.put(LaptopProfile.COLUMN_GenrationList, temp.getGen());
        values.put(LaptopProfile.COLUMN_RAMList, temp.getRam());
        values.put(LaptopProfile.COLUMN_InchesList, temp.getInches());
        values.put(LaptopProfile.COLUMN_HDDList, temp.getHdd());
        values.put(LaptopProfile.COLUMN_SHDDList, temp.getShdd());
        values.put(LaptopProfile.COLUMN_osList, temp.getOs());
        values.put(LaptopProfile.COLUMN_GraphiccardList, temp.getGrapcard());
        values.put(LaptopProfile.COLUMN_DVDwriterList, temp.getDvd());

        // insert row
        long id = db.insert(LaptopProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllLaptopProfileDetails
    public LaptopProfile getAllLaptopProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + LaptopProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        LaptopProfile LaptopProfileDetails = new LaptopProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            LaptopProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_Brand_Name)));
            LaptopProfileDetails.setProtypeList(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_ProcessorTypeList)));
            LaptopProfileDetails.setGen(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_GenrationList)));
            LaptopProfileDetails.setRam(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_RAMList)));
            LaptopProfileDetails.setInches(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_InchesList)));
            LaptopProfileDetails.setHdd(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_HDDList)));
            LaptopProfileDetails.setShdd(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_SHDDList)));
            LaptopProfileDetails.setOs(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_osList)));
            LaptopProfileDetails.setGrapcard(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_GraphiccardList)));
            LaptopProfileDetails.setDvd(cursor.getString(cursor.getColumnIndex(LaptopProfile.COLUMN_DVDwriterList)));
        }
        // close db connection
        db.close();

        // return notes list
        return LaptopProfileDetails;
    }

    public long getLaptopProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, LaptopProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteLaptopProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + LaptopProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //start Monitor  Profile

    public long insertMonitorDetails(MonitorProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MonitorProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(MonitorProfile.COLUMN_InchesList, temp.getInches());
        values.put(MonitorProfile.COLUMN_PortList, temp.getPort());

        // insert row
        long id = db.insert(MonitorProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllmonitorProfileDetails
    public MonitorProfile getAllmonitorProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + MonitorProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        MonitorProfile monitorProfileDetails = new MonitorProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            monitorProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(MonitorProfile.COLUMN_Brand_Name)));
            monitorProfileDetails.setInches(cursor.getString(cursor.getColumnIndex(MonitorProfile.COLUMN_InchesList)));
            monitorProfileDetails.setPort(cursor.getString(cursor.getColumnIndex(MonitorProfile.COLUMN_PortList)));
        }
        // close db connection
        db.close();

        // return notes list
        return monitorProfileDetails;
    }

    public long getMonitorProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, MonitorProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteMonitorProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + MonitorProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

//Mouse Profile

    public long insertMouseDetails(MouseProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MouseProfile .COLUMN_Brand_Name, temp.getBrandName());
        values.put(MouseProfile.COLUMN_TypeList, temp.getTypeList());

        // insert row
        long id = db.insert(MouseProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllMouseProfileDetails
    public MouseProfile getAllMouseProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + MouseProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        MouseProfile mouseProfile = new MouseProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            mouseProfile.setBrandName(cursor.getString(cursor.getColumnIndex(MouseProfile.COLUMN_Brand_Name)));
            mouseProfile.setTypeList(cursor.getString(cursor.getColumnIndex(MouseProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return mouseProfile;
    }

    public long getMouseProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, MouseProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteMouseProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + KeyboardProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //start Printer  Profile


    public long insertPrinterDetails(PrinterProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PrinterProfile.COLUMN_Brand_Name, temp.getBrandName());

        // insert row
        long id = db.insert(PrinterProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllmonitorProfileDetails
    public PrinterProfile getAllPrinterProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + PrinterProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        PrinterProfile printerProfileDetails = new PrinterProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            printerProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(PrinterProfile.COLUMN_Brand_Name)));
        }
        // close db connection
        db.close();

        // return notes list
        return printerProfileDetails;
    }

    public long getprinterProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, PrinterProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deletePrinterProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + PrinterProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //start RAM  Profile

    public long insertRamDetails(RAMProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RAMProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(RAMProfile.COLUMN_GBList, temp.getGb());
        values.put(RAMProfile.COLUMN_TypeList, temp.getTypeList());

        // insert row
        long id = db.insert(RAMProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllmonitorProfileDetails
    public RAMProfile getAllRAMProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + RAMProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        RAMProfile rAMProfileDetails = new RAMProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            rAMProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(RAMProfile.COLUMN_Brand_Name)));
            rAMProfileDetails.setGb(cursor.getString(cursor.getColumnIndex(RAMProfile.COLUMN_GBList)));
            rAMProfileDetails.setTypeList(cursor.getString(cursor.getColumnIndex(RAMProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return rAMProfileDetails;
    }

    public long getRAMProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, RAMProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteRAMProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + RAMProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    //start RouterProfile

    public long insertRouterProfileDetails(RouterProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RouterProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(RouterProfile.COLUMN_TypeList, temp.getType());
        values.put(RouterProfile.COLUMN_PortList, temp.getPort());
        values.put(RouterProfile.COLUMN_mbpsList, temp.getMbps());

        // insert row
        long id = db.insert(RouterProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    //Creating Function For getAllmonitorProfileDetails
    public RouterProfile getAllRouterProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + RouterProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        RouterProfile routerProfileDetails = new RouterProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            routerProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(RouterProfile.COLUMN_Brand_Name)));
            routerProfileDetails.setType(cursor.getString(cursor.getColumnIndex(RouterProfile.COLUMN_TypeList)));
            routerProfileDetails.setPort(cursor.getString(cursor.getColumnIndex(RouterProfile.COLUMN_PortList)));
            routerProfileDetails.setMbps(cursor.getString(cursor.getColumnIndex(RouterProfile.COLUMN_mbpsList)));
        }
        // close db connection
        db.close();

        // return notes list
        return routerProfileDetails;
    }

    public long getRouterProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, RouterProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSupplierList
    public void deleteRouterProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + RouterProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start ScannerProfile

    public long insertScannerProfileDetails(ScannerProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ScannerProfile.COLUMN_Brand_Name, temp.getBrandList());
        values.put(ScannerProfile.COLUMN_TypeList, temp.getTypeList());

        // insert row
        long id = db.insert(ScannerProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllScannerProfileDetails
    public ScannerProfile getAllScannerProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + ScannerProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ScannerProfile scannerProfileDetails = new ScannerProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            scannerProfileDetails.setBrandList(cursor.getString(cursor.getColumnIndex(ScannerProfile.COLUMN_Brand_Name)));
            scannerProfileDetails.setTypeList(cursor.getString(cursor.getColumnIndex(ScannerProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return scannerProfileDetails;
    }

    public long getScannerProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, ScannerProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteScannerProfileList
    public void deleteScannerProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + ScannerProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start SwitchProfile

    public long insertSwitchProfileDetails(SwitchProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SwitchProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(SwitchProfile.COLUMN_PortList, temp.getPort());
        values.put(SwitchProfile.COLUMN_TypeList, temp.getType());

        // insert row
        long id = db.insert(SwitchProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public SwitchProfile getAllSwitchProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + SwitchProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        SwitchProfile switchProfileDetails = new SwitchProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            switchProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(SwitchProfile.COLUMN_Brand_Name)));
            switchProfileDetails.setPort(cursor.getString(cursor.getColumnIndex(SwitchProfile.COLUMN_PortList)));
            switchProfileDetails.setType(cursor.getString(cursor.getColumnIndex(SwitchProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return switchProfileDetails;
    }

    public long getSwitchProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, SwitchProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deleteSwitchProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + SwitchProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start TabletProfile

    public long insertTabletProfileDetails(TabletProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TabletProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(TabletProfile.COLUMN_Inches_List, temp.getInchesList());

        // insert row
        long id = db.insert(TabletProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public TabletProfile getAllTabletProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TabletProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        TabletProfile tabletProfileDetails = new TabletProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            tabletProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(TabletProfile.COLUMN_Brand_Name)));
            tabletProfileDetails.setInchesList(cursor.getString(cursor.getColumnIndex(TabletProfile.COLUMN_Inches_List)));
        }
        // close db connection
        db.close();

        // return notes list
        return tabletProfileDetails;
    }

    public long getTabletProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TabletProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deleteTabletProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + TabletProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start TVProfile

    public long insertTVProfileDetails(TVProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TVProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(TVProfile.COLUMN_Inches_List, temp.getInchesList());

        // insert row
        long id = db.insert(TVProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public TVProfile getAllTVProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TVProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        TVProfile tVProfileDetails = new TVProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            tVProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(TVProfile.COLUMN_Brand_Name)));
            tVProfileDetails.setInchesList(cursor.getString(cursor.getColumnIndex(TVProfile.COLUMN_Inches_List)));
        }
        // close db connection
        db.close();

        // return notes list
        return tVProfileDetails;
    }

    public long getTVProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TVProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deleteTVProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + TVProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start UPSProfile

    public long insertUPSProfileDetails(UPSProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UPSProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(UPSProfile.COLUMN_CapacityList, temp.getCapacityList());
        values.put(UPSProfile.COLUMN_UPSTypeList, temp.getUpstype());

        // insert row
        long id = db.insert(UPSProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public UPSProfile getAllUPSProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + UPSProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        UPSProfile uPSProfileDetails = new UPSProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            uPSProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(UPSProfile.COLUMN_Brand_Name)));
            uPSProfileDetails.setCapacityList(cursor.getString(cursor.getColumnIndex(UPSProfile.COLUMN_CapacityList)));
            uPSProfileDetails.setUpstype(cursor.getString(cursor.getColumnIndex(UPSProfile.COLUMN_UPSTypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return uPSProfileDetails;
    }

    public long getUPSProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, UPSProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deleteUPSProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + UPSProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start wifi_dongleProfile

    public long insertwifi_dongleProfileDetails(wifi_dongleProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(wifi_dongleProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(wifi_dongleProfile.COLUMN_TypeList, temp.getTypeList());

        // insert row
        long id = db.insert(wifi_dongleProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public wifi_dongleProfile getAllwifi_dongleProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + wifi_dongleProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        wifi_dongleProfile wifi_dongleProfileDetails = new wifi_dongleProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            wifi_dongleProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(wifi_dongleProfile.COLUMN_Brand_Name)));
            wifi_dongleProfileDetails.setTypeList(cursor.getString(cursor.getColumnIndex(wifi_dongleProfile.COLUMN_TypeList)));
        }
        // close db connection
        db.close();

        // return notes list
        return wifi_dongleProfileDetails;
    }

    public long getwifi_dongleProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, wifi_dongleProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deletewifi_dongleProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + wifi_dongleProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start wifi_LanProfile

    public long insertwifi_LanProfileDetails(wifi_LanProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(wifi_LanProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(wifi_LanProfile.COLUMN_MBPS_List, temp.getMbps());

        // insert row
        long id = db.insert(wifi_LanProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public wifi_LanProfile getAllwifi_LanProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + wifi_LanProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        wifi_LanProfile wifi_LanProfileDetails = new wifi_LanProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            wifi_LanProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(wifi_LanProfile.COLUMN_Brand_Name)));
            wifi_LanProfileDetails.setMbps(cursor.getString(cursor.getColumnIndex(wifi_LanProfile.COLUMN_MBPS_List)));
        }
        // close db connection
        db.close();

        // return notes list
        return wifi_LanProfileDetails;
    }

    public long getwifi_LanProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, wifi_LanProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deletewifi_LanProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + wifi_LanProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    //start XeroxProfile

    public long insertXeroxProfileDetails(XeroxProfile temp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(XeroxProfile.COLUMN_Brand_Name, temp.getBrandName());
        values.put(XeroxProfile.COLUMN_PPM, temp.getPPMList());

        // insert row
        long id = db.insert(XeroxProfile.TABLE_NAME, null, values);

        // close db connection
        db.close();
        return id;
    }

    //Creating Function For getAllSwitchProfileDetails
    public XeroxProfile getAllXeroxProfileDetails() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + XeroxProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        XeroxProfile xeroxProfileDetails = new XeroxProfile();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            xeroxProfileDetails.setBrandName(cursor.getString(cursor.getColumnIndex(XeroxProfile.COLUMN_Brand_Name)));
            xeroxProfileDetails.setPPMList(cursor.getString(cursor.getColumnIndex(XeroxProfile.COLUMN_PPM)));
        }
        // close db connection
        db.close();

        // return notes list
        return xeroxProfileDetails;
    }

    public long getXeroxProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, XeroxProfile.TABLE_NAME);
        db.close();
        return count;
    }

    //Creating Function For deleteSwitchProfileList
    public void deleteXeroxProfileList() {
        // Select All Query
        String deleteQuery = "DELETE FROM " + XeroxProfile.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
    }


    public void insertRAMProfileDetails(RAMProfile ramProfile) {
    }



}