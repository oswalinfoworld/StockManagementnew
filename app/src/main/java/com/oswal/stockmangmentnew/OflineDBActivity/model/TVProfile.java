package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class TVProfile implements Serializable {

    public static final String TABLE_NAME = "TvProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_Inches_List = "inchesList";

    private int ProfileID;
    private String brandName;
    private String inchesList;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_Inches_List + " TEXT,"

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

    public static String getCOLUMN_Inches_List() {
        return COLUMN_Inches_List;
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

    public String getInchesList() {
        return inchesList;
    }

    public void setInchesList(String inchesList) {
        this.inchesList = inchesList;
    }
}
