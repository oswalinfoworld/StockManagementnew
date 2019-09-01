package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class RouterProfile implements Serializable {
    public static final String TABLE_NAME = "RouterProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_TypeList = "typeList";
    public static final String COLUMN_PortList = "portList";
    public static final String COLUMN_mbpsList = "mbpsList";


    private int ProfileID;
    private String brandName;
    private String type;
    private String port;
    private String mbps;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_TypeList + " TEXT,"
                    + COLUMN_PortList + " TEXT,"
                    + COLUMN_mbpsList + " TEXT"
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

    public static String getCOLUMN_PortList() {
        return COLUMN_PortList;
    }

    public static String getCOLUMN_mbpsList() {
        return COLUMN_mbpsList;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMbps() {
        return mbps;
    }

    public void setMbps(String mbps) {
        this.mbps = mbps;
    }
}
