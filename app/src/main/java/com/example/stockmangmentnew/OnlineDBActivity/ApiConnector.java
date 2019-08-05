package com.example.stockmangmentnew.OnlineDBActivity;


import com.example.stockmangmentnew.POJO.Item;
import com.example.stockmangmentnew.POJO.StockUser;

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

/**
 * Created by abhishek on 09/06/2018.
 */

public class ApiConnector {

    public String checkUserCredential(String userName, String password) {

        //New Code Embeded
        String url1 = "http://www.evbd.mannewarsamaj.org/dixit/validateStockUserDetails.php?username=" + userName + "&&password=" + password;
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


    public JSONArray insert_stock_user(StockUser userProfile) {
        String name = userProfile.getName().replaceAll(" ", "%20");
        String contactNumber = userProfile.getContactNumber();
        String userName = userProfile.getUserName();
        String DOB = userProfile.getDOB();

        String url = "http://www.evbd.mannewarsamaj.org/dixit/stockUserAdd.php?name=" + name + "&contactNumber=" + contactNumber + "&username=" + userName + "&DOB=" + DOB;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object
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

    public JSONArray insert_item_user(Item oneItem) {
        String name = oneItem.getName().replaceAll(" ", "%20");
        String model_number = oneItem.getModel_number().replaceAll(" ", "%20");
        String serial_number = oneItem.getSerial_number().replaceAll(" ", "%20");
        String specification = oneItem.getSpecification().replaceAll(" ", "%20");
        String supplier_name = oneItem.getSupplier_name().replaceAll(" ", "%20");
        String mobile_number = oneItem.getMobile_number();
        String storage_location = oneItem.getStorage_location().replaceAll(" ", "%20");
        String category = oneItem.getCategory().replaceAll(" ", "%20");

        String url = "http://www.evbd.mannewarsamaj.org/dixit/stockItemAdd.php?name=" + name + "&model_number=" + model_number + "&serial_number=" + serial_number + "&specification=" + specification + "&supplier_name=" + supplier_name + "&mobile_number  =" + mobile_number + "&storage_location=" + storage_location + "&category=" + category;
        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object
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
}
