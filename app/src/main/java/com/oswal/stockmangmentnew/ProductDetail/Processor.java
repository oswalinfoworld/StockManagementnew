package com.oswal.stockmangmentnew.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswal.stockmangmentnew.R;
import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class Processor extends AppCompatActivity {


    Button submit;
    Spinner Brandcat,companynamecat,Typecat,genrationcat,ramcat,HDDcat,SHDDcat,oscat,graphiccardcat,dvdcat;
    String[] brandList = {"Select","HP","DEll" };
    String[] companyList = {"Select","HP","DELL" };
    String[ ]typeList = {"Select","C2D", "DC", "i3", "i5", "i7"};
    String[] genList = {"Select","1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] ramList = {"Select","2", "4", "8", "6", "16", "32", "64", "128"};
    String[] hddList = {"Select","0", "250GB", "320GB", "500GB", "1TB", "2TB", "4TB"};
    String[] shddList = {"Select","80GB", "250GB", "320GB", "500GB", "1TB", "2TB", "4TB"};
    String[] osList = {"Select","DOS", "window10home", "window10pro"};
    String[] graphicsList = {"Select", "0", "onboard", "2GB", "4GB", "8GB"};
    String[]dvdsList = {"Select", "Yes","No"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);
        getSupportActionBar().setTitle("Processor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Brandcat=(Spinner)findViewById(R.id.cpu_spinner1) ;
        companynamecat=(Spinner)findViewById(R.id.cpu_spinner2) ;
        Typecat=(Spinner)findViewById(R.id.cpu_spinner3) ;
        genrationcat=(Spinner)findViewById(R.id.cpu_spinner4) ;
        ramcat=(Spinner)findViewById(R.id.cpu_spinner5) ;
        HDDcat=(Spinner)findViewById(R.id.cpu_spinner6) ;
        SHDDcat=(Spinner)findViewById(R.id.cpu_spinner7) ;
        oscat=(Spinner)findViewById(R.id.cpu_spinner8) ;
        graphiccardcat=(Spinner)findViewById(R.id.cpu_spinner9) ;
        dvdcat=(Spinner)findViewById(R.id.cpu_spinner10) ;


        Brandcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(com.oswal.stockmangmentnew.ProductDetail.Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        companynamecat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
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
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        genrationcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ramcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        HDDcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SHDDcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Laptop_activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                                intent = new Intent(Processor.this, Laptop_activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Laptop_activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        oscat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        graphiccardcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dvdcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Processor.this, Processor.class);
                        startActivity(intent);
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

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, companyList);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        companynamecat.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeList);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Typecat.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genList);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        genrationcat.setAdapter(aa3);

        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ramList);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        ramcat.setAdapter(aa4);



        ArrayAdapter aa6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hddList);
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        HDDcat.setAdapter(aa6);


        ArrayAdapter aa7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shddList);
        aa7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        SHDDcat.setAdapter(aa7);

        ArrayAdapter aa8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, osList);
        aa8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        oscat.setAdapter(aa8);

        ArrayAdapter aa9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, graphicsList);
        aa9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        graphiccardcat.setAdapter(aa9);

        ArrayAdapter aa10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dvdsList);
        aa10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dvdcat.setAdapter(aa10);





        submit=(Button)findViewById(R.id.processor_subbtn1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Processor.this, Add_Item.class);
                startActivity(i);
            }
        });


    }
}
