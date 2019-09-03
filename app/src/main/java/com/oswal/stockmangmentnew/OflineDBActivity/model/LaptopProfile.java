package com.oswal.stockmangmentnew.OflineDBActivity.model;

import java.io.Serializable;

public class LaptopProfile implements Serializable {
    public static final String TABLE_NAME = "LaptopProfile";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Brand_Name = "brandList";
    public static final String COLUMN_ProcessorTypeList = "processortypeList";
    public static final String COLUMN_GenrationList = "genrationList";
    public static final String COLUMN_RAMList = "RAMList";
    public static final String COLUMN_InchesList = "InchesList";
    public static final String COLUMN_HDDList = "HDDList";
    public static final String COLUMN_SHDDList = "SHDDList";
    public static final String COLUMN_osList = "osList";
    public static final String COLUMN_GraphiccardList = "GraphiccardList";
    public static final String COLUMN_DVDwriterList = "DVDwriterListt";


    private int ProfileID;
    private String brandName;
    private String protypeList;
    private String gen;
    private String ram;
    private String inches;
    private String hdd;
    private String shdd;
    private String os;
    private String grapcard;
    private String dvd;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Brand_Name + " TEXT,"
                    + COLUMN_ProcessorTypeList  + " TEXT,"
                    + COLUMN_GenrationList   + " TEXT,"
                    + COLUMN_RAMList  + " TEXT,"
                    + COLUMN_InchesList + " TEXT,"
                    + COLUMN_HDDList  + " TEXT,"
                    + COLUMN_SHDDList   + " TEXT,"
                    + COLUMN_osList  + " TEXT,"
                    + COLUMN_GraphiccardList  + " TEXT,"
                    + COLUMN_DVDwriterList + " TEXT"
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

    public static String getCOLUMN_ProcessorTypeList() {
        return COLUMN_ProcessorTypeList;
    }

    public static String getCOLUMN_GenrationList() {
        return COLUMN_GenrationList;
    }

    public static String getCOLUMN_RAMList() {
        return COLUMN_RAMList;
    }

    public static String getCOLUMN_InchesList() {
        return COLUMN_InchesList;
    }

    public static String getCOLUMN_HDDList() {
        return COLUMN_HDDList;
    }

    public static String getCOLUMN_SHDDList() {
        return COLUMN_SHDDList;
    }

    public static String getCOLUMN_osList() {
        return COLUMN_osList;
    }

    public static String getCOLUMN_GraphiccardList() {
        return COLUMN_GraphiccardList;
    }

    public static String getCOLUMN_DVDwriterList() {
        return COLUMN_DVDwriterList;
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

    public static void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProtypeList() {
        return protypeList;
    }

    public static void setProtypeList(String protypeList) {
        this.protypeList = protypeList;
    }

    public String getGen() {
        return gen;
    }

    public static void setGen(String gen) {
        this.gen = gen;
    }

    public String getRam() {
        return ram;
    }

    public static void setRam(String ram) {
        this.ram = ram;
    }

    public String getInches() {
        return inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

    public String getHdd() {
        return hdd;
    }

    public static void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getShdd() {
        return shdd;
    }

    public static void setShdd(String shdd) {
        this.shdd = shdd;
    }

    public String getOs() {
        return os;
    }

    public static void setOs(String os) {
        this.os = os;
    }

    public String getGrapcard() {
        return grapcard;
    }

    public static void setGrapcard(String grapcard) {
        this.grapcard = grapcard;
    }

    public String getDvd() {
        return dvd;
    }

    public static void setDvd(String dvd) {
        this.dvd = dvd;
    }


}
