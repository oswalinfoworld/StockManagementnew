package com.oswal.stockmangmentnew.OnlineDBActivity;


import android.widget.Spinner;

import com.oswal.stockmangmentnew.POJO.Item;
import com.oswal.stockmangmentnew.POJO.StockIn;
import com.oswal.stockmangmentnew.POJO.StockOut;
import com.oswal.stockmangmentnew.POJO.ApplicationUser;
import com.oswal.stockmangmentnew.UtilityClass.ConstantsIdentifier;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by abhishek on 09/06/2018.
 */

public class ApiConnector {

    public String checkUserCredential(String userName, String password) {

        //New Code Embeded
        String url1 = ConstantsIdentifier.getDomainName() + "/validateStockUserDetails.php?username=" + userName + "&&password=" + password;
        String response = "";
        java.net.URL url = null;
        try {
            url = new java.net.URL(url1);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // read the response
            System.out.println("Response Code: " + conn.getResponseCode());
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            System.out.println(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public JSONArray insert_stock_user(ApplicationUser userProfile) {
        String name = userProfile.getName().replaceAll(" ", "%20");
        String contactNumber = userProfile.getContactNumber();
        String userName = userProfile.getUserName();
        String DOB = userProfile.getDOB();
        String password = userProfile.getPassword();

        String url = ConstantsIdentifier.getDomainName() + "/stockUserAdd.php?name=" + name + "&contactNumber=" + contactNumber + "&username=" + userName + "&DOB=" + DOB + "&password=" + password;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object
        HttpEntity httpEntity = null;
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhi***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();


        } catch (ClientProtocolException e) {
            System.out.print("AbhiError " + e.getMessage());
            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here
        } catch (IOException e) {
            System.out.print("Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                // Log.e("Entity Response  : ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }

    public JSONArray insert_item_details(Item oneItem) {

        String model_number = oneItem.getModel_number().replaceAll(" ", "%20");
        String serial_number = oneItem.getSerial_number().replaceAll(" ", "%20");
        String date = oneItem.getDate().replaceAll(" ", "%20");
        String category = oneItem.getCategory().replaceAll(" ", "%20");
        //step3
        String mouse_activity_brandCat=oneItem.getItemSpecification().getMouse_activity_brandCat();
        String mouse_activity_typeCat=oneItem.getItemSpecification().getMouse_activity_typeCat();

        String Laptop_activity_breandCat=oneItem.getItemSpecification().getLaptop_activity_breandCat();
        String Laptop_activity_typeCat=oneItem.getItemSpecification().getLaptop_activity_typeCat();
        String Laptop_activity_generationCat=oneItem.getItemSpecification().getLaptop_activity_generationCat();
        String Laptop_activity_ramCat=oneItem.getItemSpecification().getLaptop_activity_ramCat();
        String Laptop_activity_inchesCat=oneItem.getItemSpecification().getLaptop_activity_inchesCat();
        String Laptop_activity_HDDCat=oneItem.getItemSpecification().getLaptop_activity_HDDCat();
        String  Laptop_activity_SHDDCat=oneItem.getItemSpecification().getLaptop_activity_SHDDCat();
        String Laptop_activity_OSCatt=oneItem.getItemSpecification().getLaptop_activity_OSCat();
        String  Laptop_activity_graphiccardCat=oneItem.getItemSpecification().getLaptop_activity_graphiccardCat();
        String  Laptop_acDDtivity_DVDCat=oneItem.getItemSpecification().getLaptop_acDDtivity_DVDCat();

        String Printer_acDDtivity_brandcat=oneItem.getItemSpecification().getPrinter_activity_brandcat();

        String Scanner_acDDtivity_brandcat=oneItem.getItemSpecification().getScanner_acDDtivity_brandcat();
        String Scanner_acDDtivity_typecat=oneItem.getItemSpecification().getScanner_acDDtivity_typecat();

        String CPU_activity_brandCat=oneItem.getItemSpecification().getCPU_activity_breandCat();
        String CPU_activity_typeCat=oneItem.getItemSpecification().getCPU_activity_typeCat();
        String CPU_activity_generationCat=oneItem.getItemSpecification().getCPU_activity_generationCat();
        String CPU_activity_ramCat=oneItem.getItemSpecification().getCPU_activity_ramCat();
        String CPU_activity_HDDCat=oneItem.getItemSpecification().getCPU_activity_HDDCat();
        String  CPU_activity_SHDDCat=oneItem.getItemSpecification().getCPU_activity_SHDDCat();
        String CPU_activity_OSCatt=oneItem.getItemSpecification().getCPU_activity_OSCat();
        String  CPU_activity_graphiccardCat=oneItem.getItemSpecification().getCPU_activity_graphiccardCat();
        String CPU_acDDtivity_DVDCat=oneItem.getItemSpecification().getCPU_acDDtivity_DVDCat();

        String Router_activity_brandCat=oneItem.getItemSpecification().getRouter_activity_brandcat();
        String Router_activity_typeCat=oneItem.getItemSpecification().getRouter_activity_typecat();
        String Router_activity_portCat=oneItem.getItemSpecification().getRouter_activity_portcat();
        String Router_activity_mbpsCat=oneItem.getItemSpecification().getRouter_activity_mbpscat();

        String wifidongle_activity_brandCat=oneItem.getItemSpecification().getWifidongle_activity_brandcat();
        String wifidongle_activity_typeCat=oneItem.getItemSpecification().getWifidongle_activity_typecat();

        String RAM_activity_brandCat=oneItem.getItemSpecification().getRAM_activity_brandcat();
        String RAM_activity_typeCat=oneItem.getItemSpecification().getRAM_activity_typecat();
        String RAM_activity_gbCat=oneItem.getItemSpecification().getRAM_activity_gbcat();

        String Cable_activity_brandCat=oneItem.getItemSpecification().getCables_activity_brandcat();


        String GPS_activity_brandCat=oneItem.getItemSpecification().getGPS_activity_brandcat();


        String Xerox_activity_brandCat=oneItem.getItemSpecification().getXerox_activity_brandcat();
        String Xerox_activity_ppmCat=oneItem.getItemSpecification().getXerox_activity_ppmcat();


        String Switches_activity_brandCat=oneItem.getItemSpecification().getSwitches_activity_brandcat();
        String Switches_activity_typeCat=oneItem.getItemSpecification().getSwitches_activity_typecat();
        String Switches_activity_portCat=oneItem.getItemSpecification().getSwitches_activity_portcat();

        String tablet_activity_brandCat=oneItem.getItemSpecification().getTablet_activity_brandcat();
        String tablet_activity_inchesCat=oneItem.getItemSpecification().getTablet_activity_inchescat();

        String tv_activity_brandCat=oneItem.getItemSpecification().getTv_activity_brandcat();
        String tv_activity_inchesCat=oneItem.getItemSpecification().getTv_activity_inchescat();

        String wifi_Lan_activity_brandCat=oneItem.getItemSpecification().getWifi_Lan_activity_brandcat();
        String wifi_Lan_activity_inchesCat=oneItem.getItemSpecification().getWifi_Lan_activity_mbpscat();

        //
        // String url = ConstantsIdentifier.getDomainName() + "/stockItemAdd.php?model_number=" + model_number + "&serial_number=" + serial_number + "&dom=" + dom + "&supplier_name=" + supplier_name + "&contact_no=" + mobile_number + "&item_quatity=" + quantity + "&date=" + date;
        //step4 change link
        //step5 Php script change
        String url = ConstantsIdentifier.getDomainName() + "/stockItemAdd.php?model_number=" + model_number + "&serial_number=" + serial_number + "&date=" + date;

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object
        HttpEntity httpEntity = null;
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhi***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();


        } catch (ClientProtocolException e) {
            System.out.print("Error " + e.getMessage());
            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here
        } catch (IOException e) {
            System.out.print("Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                System.out.println("Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }


    public JSONArray insert_stockIn_Record_list(List<StockIn> stockInList) {
        JSONArray jsonArray = null;
        for (StockIn stockIn : stockInList) {
            String supplierID = stockIn.getSupplierID();
            String date = stockIn.getDate().replaceAll(" ", "%20");
            String billNumber = stockIn.getBillNumber();
            String supplierName = stockIn.getSupplierName().replaceAll(" ", "%20");
            String contactNumber = stockIn.getContactNumber();
            String address = stockIn.getAddress().replaceAll(" ", "%20");
            String availableQuantity = stockIn.getAvailableQuantity();
            String item_uniqid = stockIn.getItemuniqid().trim();
            String storageLocation = stockIn.getStorageLocation().replaceAll(" ", "%20");
            String url = ConstantsIdentifier.getDomainName() + "/stockInRecord.php?supplierID=" + supplierID + "&item_uniqueID=" + item_uniqid + "&date=" + date + "&billNumber=" + billNumber + "&supplierName=" + supplierName + "&contactNumber=" + contactNumber + "&address=" + address + "&date=" + date + "&availableQuantity=" + availableQuantity + "&storage_location=" + storageLocation;
            HttpEntity httpEntity = null;
            try {

                DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
                //Log.d("abhi", url);
                System.out.print("Abhi***************** URL " + url);
                HttpPost httpGet = new HttpPost(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);

                httpEntity = httpResponse.getEntity();


            } catch (ClientProtocolException e) {
                System.out.print("Error " + e.getMessage());
                // Signals error in http protocol
                e.printStackTrace();

                //Log Errors Here
            } catch (IOException e) {
                System.out.print("Error " + e.getMessage());
                e.printStackTrace();
            }
            // Convert HttpEntity into JSON Array

            if (httpEntity != null) {
                try {
                    String entityResponse = EntityUtils.toString(httpEntity);

                    // Log.e("Entity Response  : ", entityResponse);
                    jsonArray = new JSONArray(entityResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonArray;
    }

    public JSONArray insert_stockIn_Record(StockIn stockIn) {
        JSONArray jsonArray = null;
        String supplierID = stockIn.getSupplierID();
        String date = stockIn.getDate().replaceAll(" ", "%20");
        String billNumber = stockIn.getBillNumber();
        String supplierName = stockIn.getSupplierName().replaceAll(" ", "%20");
        String contactNumber = stockIn.getContactNumber();
        String address = stockIn.getAddress().replaceAll(" ", "%20");
        String availableQuantity = stockIn.getAvailableQuantity();
        String item_uniqid = stockIn.getItemuniqid().trim();
        String storageLocation = stockIn.getStorageLocation().replaceAll(" ", "%20");
        System.out.print("abhi***************** Reached ");
        String url = ConstantsIdentifier.getDomainName() + "/stockInRecord.php?supplierID=" + supplierID + "&item_uniqueID=" + item_uniqid + "&date=" + date + "&billNumber=" + billNumber + "&supplierName=" + supplierName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity + "&storage_location=" + storageLocation;
        System.out.print("abhi***************** URL " + url);
        HttpEntity httpEntity = null;
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("abhi***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();


        } catch (ClientProtocolException e) {
            System.out.print("Error " + e.getMessage());
            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here
        } catch (IOException e) {
            System.out.print("Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                // Log.e("Entity Response  : ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public JSONArray insert_stockOut_Record_list(List<StockOut> stockOutList) {
        JSONArray jsonArray = null;
        for (StockOut stockOut : stockOutList) {
            String customerID = stockOut.getCustomer_id();
            String date = stockOut.getDate().replaceAll(" ", "%20");
            String billNumber = stockOut.getBill_number();
            String contactNumber = stockOut.getContact_number();
            String address = stockOut.getAddress().replaceAll(" ", "%20");
            String customerName = stockOut.getCustomer_name().replaceAll(" ", "%20");
            String availableQuantity = stockOut.getQuantity();
            String item_uniqid = stockOut.getItemuniqid().trim();
            String url = ConstantsIdentifier.getDomainName() + "/stockOutRecord.php?customerID=" + customerID +"&item_uniqueID=" + item_uniqid + "&date=" + date + "&billNumber=" + billNumber + "&customerName=" + customerName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity;
            HttpEntity httpEntity = null;
            try {

                DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
                //Log.d("abhi", url);
                System.out.print("***************** URL " + url);
                HttpPost httpGet = new HttpPost(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);

                httpEntity = httpResponse.getEntity();


            } catch (ClientProtocolException e) {
                System.out.print("Error " + e.getMessage());
                // Signals error in http protocol
                e.printStackTrace();

                //Log Errors Here
            } catch (IOException e) {
                System.out.print("Error " + e.getMessage());
                e.printStackTrace();
            }
            // Convert HttpEntity into JSON Array

            if (httpEntity != null) {
                try {
                    String entityResponse = EntityUtils.toString(httpEntity);

                    // Log.e("Entity Response  : ", entityResponse);
                    jsonArray = new JSONArray(entityResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonArray;
    }

    public JSONArray insert_stockOut_Record(StockOut stockOut) {
        JSONArray jsonArray = null;
        String customerID = stockOut.getCustomer_id();
        String date = stockOut.getDate().replaceAll(" ", "%20");
        String billNumber = stockOut.getBill_number();
        String contactNumber = stockOut.getContact_number();
        String address = stockOut.getAddress().replaceAll(" ", "%20");
        String customerName = stockOut.getCustomer_name().replaceAll(" ", "%20");
        String availableQuantity = stockOut.getQuantity();
        String item_uniqid = stockOut.getItemuniqid().trim();
        String url = ConstantsIdentifier.getDomainName() + "/stockOutRecord.php?customerID=" + customerID +"&item_uniqueID=" + item_uniqid+ "&date="  + date + "&billNumber=" + billNumber + "&customerName=" + customerName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity;
        HttpEntity httpEntity = null;
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhi***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();


        } catch (ClientProtocolException e) {
            System.out.print("Error " + e.getMessage());
            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here
        } catch (IOException e) {
            System.out.print("Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                // Log.e("Entity Response  : ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public JSONArray GetListOfSupplierJson() {
        String url = ConstantsIdentifier.getDomainName() + "/getAllSupplierList.php";
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();

//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;


        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
               /* System.out.println("Abhishek ------jsonArray  : "+jsonArray.getJSONObject(0));
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                users= gson.fromJson(entityResponse, ArrayList.class);
                System.out.println("Abhishek List of Users APIConnector---------------> "+users.get(0));
                System.out.println("Abhishek Size of User List APIConnector"+users.size());*/
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;

    }

    public JSONArray GetListOfCustomerJson() {
        String url = ConstantsIdentifier.getDomainName() + "/getCustomerList.php";
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();

//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;


        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
               /* System.out.println("Abhishek ------jsonArray  : "+jsonArray.getJSONObject(0));
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                users= gson.fromJson(entityResponse, ArrayList.class);
                System.out.println("Abhishek List of Users APIConnector---------------> "+users.get(0));
                System.out.println("Abhishek Size of User List APIConnector"+users.size());*/
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;

    }

    public JSONArray insert_reject_item(String itemUniqueID, String reason_string) {
        String itemUniqueID1 = itemUniqueID.replaceAll(" ", "%20");
        String reasonS1 = reason_string.replaceAll(" ", "%20");
        String url = ConstantsIdentifier.getDomainName() + "/StockRejectitem.php?itemId=" + itemUniqueID1 + "&reason=" + reasonS1;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();

//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;


        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
               /* System.out.println("Abhishek ------jsonArray  : "+jsonArray.getJSONObject(0));
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                users= gson.fromJson(entityResponse, ArrayList.class);
                System.out.println("Abhishek List of Users APIConnector---------------> "+users.get(0));
                System.out.println("Abhishek Size of User List APIConnector"+users.size());*/
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public JSONArray insert_damage_item(String itemUniqueID, String reasonS, String item_nameS, String model_noS, String bill_noS, String dateS, String customer_nameS, String store_locS) {
        String itemUniqueID1 = itemUniqueID.replaceAll(" ", "%20");
        String reasonS1 = reasonS.replaceAll(" ", "%20");
        String item_nameS1 = item_nameS.replaceAll(" ", "%20");
        String model_noS1 = model_noS.replaceAll(" ", "%20");
        String bill_noS1 = bill_noS.replaceAll(" ", "%20");
        String dateS1 = dateS.replaceAll(" ", "%20");
        String customer_nameS1 = customer_nameS.replaceAll(" ", "%20");
        String store_locS1 = store_locS.replaceAll(" ", "%20");
        String url = ConstantsIdentifier.getDomainName() + "/StockDamageItem.php?itemId=" + itemUniqueID1 + "&reason=" + reasonS1 + "&itemName=" + item_nameS1 + "&modelNumber=" + model_noS1 + "&billNumber=" + bill_noS1 + "&date=" + dateS1 + "&customerName=" + customer_nameS1 + "&storageLocation=" + store_locS1;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;
        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public JSONArray insert_Repair_item(String itemUniqueID, String reasonS, String item_nameS, String model_noS, String bill_noS, String dateS, String customer_nameS, String store_locS) {
        String itemUniqueID1 = itemUniqueID.replaceAll(" ", "%20");
        String reasonS1 = reasonS.replaceAll(" ", "%20");
        String item_nameS1 = item_nameS.replaceAll(" ", "%20");
        String model_noS1 = model_noS.replaceAll(" ", "%20");
        String bill_noS1 = bill_noS.replaceAll(" ", "%20");
        String dateS1 = dateS.replaceAll(" ", "%20");
        String customer_nameS1 = customer_nameS.replaceAll(" ", "%20");
        String store_locS1 = store_locS.replaceAll(" ", "%20");
        String url = ConstantsIdentifier.getDomainName() + "/StockRepaireItem.php?itemId=" + itemUniqueID1 + "&reason=" + reasonS1 + "&itemName=" + item_nameS1 + "&modelNumber=" + model_noS1 + "&billNumber=" + bill_noS1 + "&date=" + dateS1 + "&customerName=" + customer_nameS1 + "&storageLocation=" + store_locS1;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;
        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }





   /* public JSONArray insert_stock_product_detail(String itemUniqueID ,String Brandcat1,Spinner Typecat, Spinner genrationcat, Spinner ramcat, Spinner inchescat,Spinner HDDcat,
                                                 Spinner SHDDcat, Spinner oscat, Spinner graphiccardcat,Spinner dvdcat) {
       String itemUniqueID1=itemUniqueID;
        String BrandcatS=Brandcat1.replaceAll(" ", "%20");
        String TypecatS=Typecat.replaceAll(" ", "%20");
        String genrationcatS=genrationcat.replaceAll(" ", "%20");
        String ramcatS=ramcat.replaceAll(" ", "%20");
        String inchescatS=inchescat.replaceAll(" ", "%20");
        String HDDcatS=HDDcat.replaceAll(" ", "%20");
        String SHDDcatS=SHDDcat.replaceAll(" ", "%20");
        String  oscatS= oscat.replaceAll(" ", "%20");
        String graphiccardcatS=graphiccardcat.replaceAll(" ", "%20");
        String dvdcatS=dvdcat.replaceAll(" ", "%20");

        String url = ConstantsIdentifier.getDomainName() + "/Laptop.php?itemId=" + itemUniqueID1 + "&Brandcat=" +  BrandcatS + "&Typecat=" + TypecatS + "&genrationcat=" + genrationcatS + "&ramcat=" + ramcatS + "&inchescat=" +
                inchescatS + "&HDDcat=" + HDDcatS + "&SHDDcat" +SHDDcatS+  "&oscat=" + oscatS + "&graphiccardcat" + graphiccardcatS + "dvdcat" +dvdcatS;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;
        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }
*/


    public JSONArray insert_mouse_activity(String itemUniqueID, Spinner brandname, Spinner type) {
        String itemUniqueID1 = itemUniqueID.replaceAll(" ", "%20");
       Spinner brandnameS = brandname;
        Spinner typeS =type;
        String url = ConstantsIdentifier.getDomainName() + "/mouseactivity.php?itemId=" + itemUniqueID1 + "&brandnameS=" + brandname+"$typeS="+type;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            //Log.d("abhi", url);
            System.out.print("Abhishek***************** URL " + url);
            HttpPost httpGet = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();

//            HashMap<String, Object> hashMap = new HashMap<>(Utility.jsonToMap(httpResponse)) ;


        } catch (IOException e) {
            System.out.print("Abhishek Error " + e.getMessage());
            e.printStackTrace();
        }
        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;
        // List<EVBUser> users=new ArrayList<EVBUser>() ;
        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("Abhishek123 SupplierJson------>Entity Response  : " + entityResponse);
                jsonArray = new JSONArray(entityResponse);
               /* System.out.println("Abhishek ------jsonArray  : "+jsonArray.getJSONObject(0));
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                users= gson.fromJson(entityResponse, ArrayList.class);
                System.out.println("Abhishek List of Users APIConnector---------------> "+users.get(0));
                System.out.println("Abhishek Size of User List APIConnector"+users.size());*/
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }



}
