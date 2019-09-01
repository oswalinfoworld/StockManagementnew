package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class RAMProfile implements Serializable {

    public static final String TABLE_NAME = "RAMProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_GBList = "GBList";
    public static final String COLUMN_TypeList = "typeList";


    private int ProfileID;
    private String brandName;
    private String gb;
    private String typeList;

    private static String COLUMN_COLUMN_GBList;
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_COLUMN_GBList + " TEXT,"
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

    public static String getCOLUMN_GBList() {
        return COLUMN_GBList;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb;
    }

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public static String getCOLUMN_COLUMN_GBList() {
        return COLUMN_COLUMN_GBList;
    }

    public static void setCOLUMN_COLUMN_GBList(String COLUMN_COLUMN_GBList) {
        RAMProfile.COLUMN_COLUMN_GBList = COLUMN_COLUMN_GBList;
    }


}
