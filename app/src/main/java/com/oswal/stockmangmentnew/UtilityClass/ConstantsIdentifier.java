package com.oswal.stockmangmentnew.UtilityClass;

import com.oswal.stockmangmentnew.POJO.Supplier;

import java.util.ArrayList;
import java.util.List;

public class ConstantsIdentifier {

    private static String domainName="http://mahavirstores.com/mahavir/dixit/stockscript";

    public static String getDomainName() {
        return domainName;
    }

    public static List<Supplier> supplierList= new ArrayList<>();

    public static List<Supplier> getSupplierList() {
        return supplierList;
    }

    public static void setSupplierList(List<Supplier> supplierList) {
        ConstantsIdentifier.supplierList = supplierList;
    }
}
