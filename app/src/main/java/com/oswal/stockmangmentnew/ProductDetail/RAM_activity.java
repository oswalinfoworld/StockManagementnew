package com.oswal.stockmangmentnew.ProductDetail;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.net.ConnectivityManager;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.oswal.stockmangmentnew.OflineDBActivity.DatabaseHelper;
        import com.oswal.stockmangmentnew.OflineDBActivity.model.KeyboardProfile;
        import com.oswal.stockmangmentnew.OflineDBActivity.model.RAMProfile;
        import com.oswal.stockmangmentnew.OnlineDBActivity.ApiConnector;
        import com.oswal.stockmangmentnew.POJO.Item;
        import com.oswal.stockmangmentnew.POJO.ItemSpecification;
        import com.oswal.stockmangmentnew.R;
        import com.oswal.stockmangmentnew.Services.Items.Add_Item;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;

public class RAM_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat,GBcat,Typecat;
    String brandCatS,typeCatS,gbS;

  /*  String[] brandList = {"Select","HP","DEll" };
    String[] GBList = {"Select","2GB","4GB","8GB","16GB","32GB","64GB","128" };
    String[] typeList = {"Select","SRAM","DRAM","DDR2","DDR3","DDR4","SDRAM" };
*/

    DatabaseHelper db =null;
   RAMProfile ramProfile= new   RAMProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> GBListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();


    String model_number,model_category,model_serial_number,model_date;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_activity);
        getSupportActionBar().setTitle("RAM Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model_number=getIntent().getStringExtra("model_number");
        model_category=getIntent().getStringExtra("model_Category");
        model_serial_number=getIntent().getStringExtra("model_serial_number");
        model_date=getIntent().getStringExtra("model_date");



        Brandcat=(Spinner)findViewById(R.id.ram_spinner1);
        GBcat=(Spinner)findViewById(R.id.ram_spinner3) ;
        Typecat=(Spinner)findViewById(R.id.ram_spinner2) ;

        db = new DatabaseHelper(this);
        if(db.getRAMProfileCount()>0){
            ramProfile=db.getAllRAMProfileDetails();
            Toast.makeText(getApplicationContext()," ramProfile brand List "+ramProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data ramProfile Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }


        try {
            Toast.makeText(getApplicationContext(),"Here"+ramProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(ramProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("RAmProfile_brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }
            JSONObject jsonGBList = new JSONObject(ramProfile.getGb().toString());
            JSONArray jArrayGBList = jsonGBList.optJSONArray("RAmProfile_GBList");

            if (jArrayGBList != null) {
                for (int i=0;i<jArrayGBList.length();i++){
                 GBListArray.add(jArrayGBList.getString(i));
                }
            }
            JSONObject jsontypeList = new JSONObject(ramProfile.getTypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("RAmProfile_typeList");

            if (jArraytypeList != null) {
                for (int i=0;i<jArraytypeList.length();i++){
                    typeListArray.add(jArraytypeList.getString(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }






        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        brandCatS= adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        brandCatS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        brandCatS= adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        GBcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        gbS = adapterView.getItemAtPosition(i).toString();
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Typecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
                        typeCatS= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;



                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandListArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, GBListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        GBcat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeListArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);


        submit=(Button)findViewById(R.id.RAM_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Data Submited", Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(RAM_activity.this, Add_Item.class);
                i.putExtra("RAM_activity_breandCat",brandCatS);
                i.putExtra("RAM_activity_typeCat",typeCatS);
                i.putExtra("RAM_activity_GB",gbS);

                startActivity(i);*/



                if (isInternetOn()) {
                    new RAM_activity.insertItemToOnlineDB().execute(new ApiConnector());
                    Intent i1 = new Intent(RAM_activity.this, Add_Item.class);
                    startActivity(i1);
                }

            }
        });


    }

    public boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(getApplicationContext(), "Internet Down Data not Reflect on server", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }



    private class insertItemToOnlineDB extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on Background thread
            //Toast.makeText(getApplicationContext(),"Saving Data Online ",Toast.LENGTH_LONG).show();
            Log.d("Abhishek", "Saving Data Online ");

            Item item= new Item();
            item.setCategory(model_category);
            item.setModel_number(model_number);
            item.setSerial_number(model_serial_number);
            item.setDate(model_date);

            ItemSpecification itemSpecification = new ItemSpecification();

            itemSpecification.setBrand(brandCatS);
            itemSpecification.setType(typeCatS);
            itemSpecification.setGb(gbS);


            item.setItemSpecification(itemSpecification);
            return params[0].insert_item_details(item);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
        }


    }

}
