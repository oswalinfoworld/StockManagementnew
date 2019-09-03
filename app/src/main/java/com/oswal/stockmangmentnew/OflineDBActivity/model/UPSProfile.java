package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class UPSProfile implements Serializable {

    public static final String TABLE_NAME = "UPSProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_CapacityList = "capacityList";
    public static final String COLUMN_UPSTypeList = "UPSList";


    private int ProfileID;
    private String brandName;
    private String upstype;

    private String CapacityList;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_CapacityList + " TEXT,"
                    + COLUMN_UPSTypeList + " TEXT"
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

    public static String getCOLUMN_CapacityList() {
        return COLUMN_CapacityList;
    }

    public static String getCOLUMN_UPSTypeList() {
        return COLUMN_UPSTypeList;
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

    public String getUpstype() {
        return upstype;
    }

    public void setUpstype(String upstype) {
        this.upstype = upstype;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCapacityList() {
        return CapacityList;
    }

    public void setCapacityList(String capacityList) {
        CapacityList = capacityList;
    }


}
