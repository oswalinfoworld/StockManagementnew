package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class CustomerProfile implements Serializable {

    public static final String TABLE_NAME = "CustomerProfile";
    public static final String COLUMN_userID = "ID";
    public static final String COLUMN_Name = "Name";
    public static final String COLUMN_Personal_mobile = "Personal_mobile";
    public static final String COLUMN_Address = "Personal_Address";


    private int customerProfileID;
    private String name;
    private String Personal_Mobile;
    private String address;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_userID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Name + " TEXT,"
                    + COLUMN_Personal_mobile + " TEXT,"
                    + COLUMN_Address + " TEXT"
                    + ")";

    public static String getCOLUMN_userID() {
        return COLUMN_userID;
    }

    public static String getCOLUMN_Name() {
        return COLUMN_Name;
    }

    public static String getCOLUMN_Personal_mobile() {
        return COLUMN_Personal_mobile;
    }

    public static String getCOLUMN_Address() {
        return COLUMN_Address;
    }

    public int getSupplierProfileID() {
        return customerProfileID;
    }

    public void setSupplierProfileID(int supplierProfileID) {
        this.customerProfileID = supplierProfileID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonal_Mobile() {
        return Personal_Mobile;
    }

    public void setPersonal_Mobile(String personal_Mobile) {
        Personal_Mobile = personal_Mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
