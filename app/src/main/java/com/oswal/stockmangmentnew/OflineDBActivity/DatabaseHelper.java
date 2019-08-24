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

import com.oswal.stockmangmentnew.OflineDBActivity.model.CustomerProfile;
import com.oswal.stockmangmentnew.OflineDBActivity.model.SupplierProfile;
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
}