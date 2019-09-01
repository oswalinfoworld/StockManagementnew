package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class MonitorProfile implements Serializable {
    public static final String TABLE_NAME = "MonitorProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_InchesList = "InchesList";
    public static final String COLUMN_PortList = "PortList";

    private int ProfileID;
    private String brandName;
    private String inches;
    private String Port;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_InchesList + " TEXT,"
                    + COLUMN_PortList + " TEXT"
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

    public static String getCOLUMN_InchesList() {
        return COLUMN_InchesList;
    }

    public static String getCOLUMN_PortList() {
        return COLUMN_PortList;
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

    public String getInches() {
        return inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }


}
