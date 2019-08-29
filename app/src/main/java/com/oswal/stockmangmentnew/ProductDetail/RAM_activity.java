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

        import com.oswal.stockmangmentnew.R;
        import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class RAM_activity extends AppCompatActivity {

    Button submit;
    Spinner Brandcat,GBcat,Typecat;
    String[] brandList = {"Select","HP","DEll" };
    String[] GBList = {"Select","2GB","4GB","8GB","16GB","32GB","64GB","128" };
    String[] typeList = {"Select","SRAM","DRAM","DDR2","DDR3","DDR4","SDRAM" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_activity);
        getSupportActionBar().setTitle("RAM Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Brandcat=(Spinner)findViewById(R.id.ram_spinner1);
        GBcat=(Spinner)findViewById(R.id.ram_spinner3) ;
        Typecat=(Spinner)findViewById(R.id.ram_spinner2) ;
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
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Brandcat.setAdapter(aa);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, GBList);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        GBcat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeList);
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
