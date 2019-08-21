package com.oswal.stockmangmentnew.ProductDetail;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.Toast;

        import com.oswal.stockmangmentnew.R;
        import com.oswal.stockmangmentnew.Services.Items.Add_Item;

public class RAM_activity extends AppCompatActivity {
    CheckBox type1,type2,type3,type4,type5,type6,type7;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_activity);
        getSupportActionBar().setTitle("RAM Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        type1=(CheckBox)findViewById(R.id.RAM_type1);
        type2=(CheckBox)findViewById(R.id.RAM_type2);
        type3=(CheckBox)findViewById(R.id.RAM_type3);
        type4=(CheckBox)findViewById(R.id.RAM_type4);
        type5=(CheckBox)findViewById(R.id.RAM_type5);
        type6=(CheckBox)findViewById(R.id.RAM_type6);
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
