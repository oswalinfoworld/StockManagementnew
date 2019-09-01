package com.oswal.stockmangmentnew.OnlineDBActivity;


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
        //String dom = oneItem.getDOM().replaceAll(" ", "%20");
       // String supplier_name = oneItem.getSupplier_name().replaceAll(" ", "%20");
       // String mobile_number = oneItem.getMobile_number();
       // String quantity = oneItem.getQuantity();
        String date = oneItem.getDate().replaceAll(" ", "%20");

      //  String url = ConstantsIdentifier.getDomainName() + "/stockItemAdd.php?model_number=" + model_number + "&serial_number=" + serial_number + "&dom=" + dom + "&supplier_name=" + supplier_name + "&contact_no=" + mobile_number + "&item_quatity=" + quantity + "&date=" + date;
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
            String storageLocation = stockIn.getStorageLocation().replaceAll(" ", "%20");
            String url = ConstantsIdentifier.getDomainName() + "/stockInRecord.php?supplierID=" + supplierID + "&date=" + date + "&billNumber=" + billNumber + "&supplierName=" + supplierName + "&contactNumber=" + contactNumber + "&address=" + address + "&date=" + date + "&availableQuantity=" + availableQuantity + "&storage_location=" + storageLocation;
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
        String storageLocation = stockIn.getStorageLocation().replaceAll(" ", "%20");
        String url = ConstantsIdentifier.getDomainName() + "/stockInRecord.php?supplierID=" + supplierID + "&date=" + date + "&billNumber=" + billNumber + "&supplierName=" + supplierName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity + "&storage_location=" + storageLocation;
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
            String url = ConstantsIdentifier.getDomainName() + "/stockOutRecord.php?customerID=" + customerID + "&date=" + date + "&billNumber=" + billNumber + "&customerName=" + customerName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity;
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
        String url = ConstantsIdentifier.getDomainName() + "/stockOutRecord.php?customerID=" + customerID + "&date=" + date + "&billNumber=" + billNumber + "&customerName=" + customerName + "&contactNumber=" + contactNumber + "&address=" + address + "&availableQuantity=" + availableQuantity;
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
        String itemUniqueID1=itemUniqueID.replaceAll(" ", "%20");
        String reasonS1=reason_string.replaceAll(" ", "%20");
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
        String itemUniqueID1=itemUniqueID.replaceAll(" ", "%20");
        String reasonS1=reasonS.replaceAll(" ", "%20");
        String item_nameS1=item_nameS.replaceAll(" ", "%20");
        String model_noS1=model_noS.replaceAll(" ", "%20");
        String bill_noS1=bill_noS.replaceAll(" ", "%20");
        String dateS1=dateS.replaceAll(" ", "%20");
        String customer_nameS1=customer_nameS.replaceAll(" ", "%20");
        String store_locS1=store_locS.replaceAll(" ", "%20");
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
        String itemUniqueID1=itemUniqueID.replaceAll(" ", "%20");
        String reasonS1=reasonS.replaceAll(" ", "%20");
        String item_nameS1=item_nameS.replaceAll(" ", "%20");
        String model_noS1=model_noS.replaceAll(" ", "%20");
        String bill_noS1=bill_noS.replaceAll(" ", "%20");
        String dateS1=dateS.replaceAll(" ", "%20");
        String customer_nameS1=customer_nameS.replaceAll(" ", "%20");
        String store_locS1=store_locS.replaceAll(" ", "%20");
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
}
