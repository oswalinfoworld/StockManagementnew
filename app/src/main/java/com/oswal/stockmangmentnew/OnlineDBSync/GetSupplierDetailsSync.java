package com.oswal.stockmangmentnew.OnlineDBSync;

import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
import com.oswal.stockmangmentnew.POJO.Customer;
import com.oswal.stockmangmentnew.POJO.Supplier;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetSupplierDetailsSync extends AppCompatActivity {

    public static DatabaseHelper db = null;

    public void startSyncyContact(DatabaseHelper dbPass) {
        GetSupplierDetailsSync.db = dbPass;
        new GetListOfSupplier().execute(new ApiConnector());
        new GetListOfCustomer().execute(new ApiConnector());
    }
    public static DatabaseHelper getDB() {
        return db;
    }


    class GetListOfSupplier extends AsyncTask<ApiConnector, Long, JSONArray> {
        List<Supplier> usersList = new ArrayList<Supplier>();

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            Log.d("Abhishek", "District_wise_list_of_members ");
            return params[0].GetListOfSupplierJson();
        }

        public List<Supplier> getUsersList() {
            return usersList;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            try {
                System.out.println(" Abhishek GetListOfSupplier onPostExecute imp jsonArray.size() --------------------------------------------------------------------" + jsonArray.getJSONObject(0).getString("supplier_name"));
                System.out.println(" Abhishek GetListOfSupplier jsonArray.length()--------------------------------------------" + jsonArray.length());


                System.out.println("-------------------------------------------------Supplier-----------------------------------------");
                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject childJsonArray = jsonArray.getJSONObject(i);
                        if (childJsonArray != null && childJsonArray.length() > 0) {
                            Supplier tempUser = new Supplier();
                            tempUser.setName(childJsonArray.getString("supplier_name"));
                            tempUser.setAddress(childJsonArray.getString("supplier_address"));
                            tempUser.setContact_number(childJsonArray.getString("supplier_contact"));
                            usersList.add(tempUser);
                        }
                    }
                }

                DatabaseHelper db = GetSupplierDetailsSync.getDB();
                if (db != null) {
                    if (db.getSupplierCount() > 0) {
                        db.deleteSupplierList();
                    }
                    if (usersList.size() > 0) {
                        for (Supplier supplier : usersList) {
                            System.out.println("Abhishek " + usersList.get(0));
                            long id = db.insertSupplierDetails(supplier);
                        }
                    } else {
                        System.out.println("Supplier List Return Empty ");
                    }
                } else {
                    System.out.println("Abhishek Database Return Failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    class GetListOfCustomer extends AsyncTask<ApiConnector, Long, JSONArray> {
        List<Customer> usersList = new ArrayList<Customer>();

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            Log.d("Abhishek", "District_wise_list_of_members ");
            return params[0].GetListOfCustomerJson();
        }

        public List<Customer> getUsersList() {
            return usersList;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            try {
                System.out.println(" Abhishek GetListOfSupplier onPostExecute imp jsonArray.size() --------------------------------------------------------------------" + jsonArray.getJSONObject(0).getString("customer_name"));
                System.out.println(" Abhishek GetListOfSupplier jsonArray.length()--------------------------------------------" + jsonArray.length());


                System.out.println("-------------------------------------------------Supplier-----------------------------------------");
                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject childJsonArray = jsonArray.getJSONObject(i);
                        if (childJsonArray != null && childJsonArray.length() > 0) {
                            Customer tempUser = new Customer();
                            tempUser.setName(childJsonArray.getString("customer_name"));
                            tempUser.setAddress(childJsonArray.getString("customer_address"));
                            tempUser.setContact_number(childJsonArray.getString("customer_contact"));
                            usersList.add(tempUser);
                        }
                    }
                }

                DatabaseHelper db = GetSupplierDetailsSync.getDB();
                if (db != null) {
                    if (db.getCustomerCount() > 0) {
                        db.deleteCustomerList();
                    }
                    if (usersList.size() > 0) {
                        for (Customer customer : usersList) {
                            System.out.println("Abhishek " + usersList.get(0));
                            long id = db.insertCustomerDetails(customer);
                        }
                    } else {
                        System.out.println("Customer List Return Empty ");
                    }
                } else {
                    System.out.println("Abhishek Database Return Failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
