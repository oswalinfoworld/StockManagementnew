package com.oswal.stockmangmentnew.ProductDetail;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
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
        import com.oswal.stockmangmentnew.R;
        import com.oswal.stockmangmentnew.Services.Items.Add_Item;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;

public class RAM_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat,GBcat,Typecat;
  /*  String[] brandList = {"Select","HP","DEll" };
    String[] GBList = {"Select","2GB","4GB","8GB","16GB","32GB","64GB","128" };
    String[] typeList = {"Select","SRAM","DRAM","DDR2","DDR3","DDR4","SDRAM" };
*/

    DatabaseHelper db =null;
   RAMProfile ramProfile= new   RAMProfile();
    ArrayList<String> brandListArray = new ArrayList<String>();
    ArrayList<String> GBListArray = new ArrayList<String>();
    ArrayList<String> typeListArray = new ArrayList<String>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_activity);
        getSupportActionBar().setTitle("RAM Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.ram_spinner1);
        GBcat=(Spinner)findViewById(R.id.ram_spinner3) ;
        Typecat=(Spinner)findViewById(R.id.ram_spinner2) ;

        db = new DatabaseHelper(this);
        if(db.getRAMProfileCount()>0){
            ramProfile=db.getAllRAMProfileDetails();
            Toast.makeText(getApplicationContext()," keyBoard brand List "+ramProfile.getBrandName(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"I dont find any Data Keyboard Details",Toast.LENGTH_LONG).show();
            // Intent home = new Intent(Keyboard_activity.this, MainActivity.class);
            // startActivity(home);
        }



        try {
            Toast.makeText(getApplicationContext(),"Here"+ramProfile.getBrandName(),Toast.LENGTH_LONG ).show();
            JSONObject jsonbrandList = new JSONObject(ramProfile.getBrandName().toString());
            JSONArray jArraybrandList = jsonbrandList.optJSONArray("brandList");

            if (jArraybrandList != null) {
                for (int i=0;i<jArraybrandList.length();i++){
                    brandListArray.add(jArraybrandList.getString(i));
                }
            }
            JSONObject jsonGBList = new JSONObject(ramProfile.getGb().toString());
            JSONArray jArrayGBList = jsonGBList.optJSONArray("GBList");

            if (jArrayGBList != null) {
                for (int i=0;i<jArrayGBList.length();i++){
                 GBListArray.add(jArrayGBList.getString(i));
                }
            }
            JSONObject jsontypeList = new JSONObject(RAMProfile.getTypeList().toString());
            JSONArray jArraytypeList = jsontypeList.optJSONArray("typeList");

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
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
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
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        break;
                    case 6:
                        intent = new Intent(RAM_activity.this, RAM_activity.class);
                        startActivity(intent);
                        break;
                    case 7:
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
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Data selected", Toast.LENGTH_SHORT).show();

                        break;
                    case 6:
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
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RAM_activity.this, Add_Item.class);
                startActivity(i);
            }
        });


    }
}
