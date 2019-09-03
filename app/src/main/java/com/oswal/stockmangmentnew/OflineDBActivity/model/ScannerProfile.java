package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class ScannerProfile implements Serializable {

    public static final String TABLE_NAME = "ScannerProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_TypeList = "typeList";

    private int ProfileID;
    private String brandName;

    private String typeList;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_TypeList + " TEXT"
                    + ")";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnId() {
        return COLUMN_ID;
    }

    public static String getCOLUMN_Brand_Name() {
        return COLUMN_Brand_Name;
    }


    public static String getCOLUMN_TypeList() {
        return COLUMN_TypeList;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public String getBrandList() {
        return brandName;
    }

    public void setBrandList(String brandList) {
        this.brandName = brandList;
    }


    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }


}
