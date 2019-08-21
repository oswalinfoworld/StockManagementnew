package com.oswal.stockmangmentnew;

import android.content.Intent;
import android.os.Bundle;

import com.oswal.stockmangmentnew.LoginModule.LoginPage;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;
import com.oswal.stockmangmentnew.Services.Items.view_item;
import com.oswal.stockmangmentnew.Services.StockIn.Stock_IN_View;
import com.oswal.stockmangmentnew.Services.StockIn.Stock_in;
import com.oswal.stockmangmentnew.Services.Return.Damage;
import com.oswal.stockmangmentnew.Services.Return.Return;
import com.oswal.stockmangmentnew.Services.StockOut.Stock_Out_View;
import com.oswal.stockmangmentnew.Services.StockOut.stock_OUT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }
        if (id == R.id.action_settings2) {
            Intent mainActivity = new Intent(MainActivity.this, LoginPage.class);
            startActivity(mainActivity);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.item) {
            Toast.makeText(getApplicationContext(), "Show Item Page Here ", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.supplier) {
            Intent intent = new Intent(MainActivity.this, Stock_IN_View.class);
            startActivity(intent);

        } else if (id == R.id.customer) {
            Intent intent = new Intent(MainActivity.this, stock_OUT.class);
            startActivity(intent);

        } else if (id == R.id.stockin) {
            Intent intent = new Intent(MainActivity.this, Stock_Out_View.class);
            startActivity(intent);

        } else if (id == R.id.stockout) {

            Intent intent = new Intent(MainActivity.this, view_item.class);
            startActivity(intent);
        } else if (id == R.id.logout) {

            Intent intent = new Intent(MainActivity.this, Add_Item.class);
            startActivity(intent);
        } else if (id == R.id.retun) {
            Intent intent = new Intent(MainActivity.this, customer_List.class);
            startActivity(intent);
        } /*else if (id == R.id.damage) {
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);

        }*/ else if (id == R.id.qrCode) {
            Intent intent = new Intent(MainActivity.this, com.oswal.stockmangmentnew.QRcodeModule.MainActivity.class);
            startActivity(intent);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("Item", true, true, "item");
        headerList.add(menuModel);

        List<MenuModel> item_childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("Add", false, false, "item add");
        item_childModelsList.add(childModel);

        childModel = new MenuModel("View", false, false, "item view");
        item_childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, item_childModelsList);
        }


        /*if (!itemmenuModel.hasChildren) {
            childList.put(itemmenuModel, null);
        }*/

        menuModel = new MenuModel("Supplier", true, false, "supplier");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Customer", true, false, "customer");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Stock IN", true, true, "stock in");
        headerList.add(menuModel);

        List<MenuModel> stockIN_childModelsList = new ArrayList<>();
        MenuModel stockIN_childModel = new MenuModel("Add", false, false, "stock in add");
        stockIN_childModelsList.add(stockIN_childModel);

        stockIN_childModel = new MenuModel("View", false, false, "stock in view");
        stockIN_childModelsList.add(stockIN_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, stockIN_childModelsList);
        }

        menuModel = new MenuModel("Stock Out", true, true, "stock out");
        headerList.add(menuModel);

        List<MenuModel> stockOut_childModelsList = new ArrayList<>();
        MenuModel stockOut_childModel = new MenuModel("Add", false, false, "stock out add");
        stockOut_childModelsList.add(stockOut_childModel);

        stockOut_childModel = new MenuModel("View", false, false, "stock out view");
        stockOut_childModelsList.add(stockOut_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, stockOut_childModelsList);
        }

        menuModel = new MenuModel("Return", true, true, "return");
        headerList.add(menuModel);

        List<MenuModel> return_childModelsList = new ArrayList<>();
        MenuModel return_childModel = new MenuModel("Add", false, false, "return add");
        return_childModelsList.add(return_childModel);

        return_childModel = new MenuModel("View", false, false, "return view");
        return_childModelsList.add(return_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, return_childModelsList);
        }

        /*menuModel = new MenuModel("Damage", true, true, "damage");
        headerList.add(menuModel);

        List<MenuModel> damage_childModelsList = new ArrayList<>();
        MenuModel damage_childModel = new MenuModel("Add", false, false, "damage add");
        damage_childModelsList.add(damage_childModel);

        damage_childModel = new MenuModel("View", false, false, "damage view");
        damage_childModelsList.add(damage_childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, damage_childModelsList);
        }*/

        menuModel = new MenuModel("QR Code", true, false, "qrCode");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }
    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        Toast.makeText(getApplicationContext(), "Selected Menu " + headerList.get(groupPosition).url, Toast.LENGTH_SHORT).show();
                        openPage(headerList.get(groupPosition).url);
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.url.length() > 0) {
                        Toast.makeText(getApplicationContext(), "Child Selected Menu " + model.url, Toast.LENGTH_SHORT).show();
                        openPage(model.url);
                        onBackPressed();
                    }
                }

                return false;
            }
        });
    }


    private void openPage(String pageName) {

        if (pageName.contains("item add")) {
            Toast.makeText(getApplicationContext(), "Show Item Page Add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, com.oswal.stockmangmentnew.Services.Items.Add_Item.class);
            startActivity(intent);

        } else if (pageName.contains("item view")) {

            Intent intent = new Intent(MainActivity.this, view_item.class);
            startActivity(intent);

        } else if (pageName.contains("supplier")) {
            Intent intent = new Intent(MainActivity.this, supplier_List.class);
            startActivity(intent);

        } else if (pageName.contains("customer")) {
            Intent intent = new Intent(MainActivity.this, customer_List.class);
            startActivity(intent);

        } else if (pageName.contains("stock in add")) {
            Toast.makeText(getApplicationContext(), "stock in add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_in.class);
            startActivity(intent);
        } else if (pageName.contains("stock in view")) {
            Toast.makeText(getApplicationContext(), "stock in view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_IN_View.class);
            startActivity(intent);

        } else if (pageName.contains("stock out add")) {
            Toast.makeText(getApplicationContext(), "stock out add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, stock_OUT.class);
            startActivity(intent);
        } else if (pageName.contains("stock out view")) {
            Toast.makeText(getApplicationContext(), "stock out view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Stock_Out_View.class);
            startActivity(intent);
        }else if (pageName.contains("return add")) {

            Toast.makeText(getApplicationContext(), "return add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Return.class);
            startActivity(intent);

        } else if (pageName.contains("return view")) {
            Toast.makeText(getApplicationContext(), "return view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Return.class);
            startActivity(intent);
        }else if (pageName.contains("damage add")) {
            Toast.makeText(getApplicationContext(), "damage add ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);
        } else if (pageName.contains("damage view")) {
            Toast.makeText(getApplicationContext(), "damage view ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Damage.class);
            startActivity(intent);
        } else if (pageName.contains("qrCode")) {
            Intent intent = new Intent(MainActivity.this, com.oswal.stockmangmentnew.QRcodeModule.MainActivity.class);
            startActivity(intent);
        }
    }
}
