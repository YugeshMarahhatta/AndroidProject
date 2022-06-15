package com.example.pharmacy;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddProduct extends AppCompatActivity {
    EditText tradename,commonname,composition,batchno,quantity,costprice,sellingprice;
    Button add;
    DBHelper DB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_add);

        tradename= findViewById(R.id.tradename);
        commonname = findViewById(R.id.commonname);
        composition= findViewById(R.id.composition);
        batchno = findViewById(R.id.batchno);
        quantity = findViewById(R.id.quantity);
        costprice = findViewById(R.id.costprice);
        sellingprice =findViewById(R.id.sellingprice);

        add =findViewById(R.id.addbtn);

        DB = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tradenameTXT = tradename.getText().toString();
                String commonnameTXT = commonname.getText().toString();
                String compositionTXT = composition.getText().toString();
                String batchnoTXT = batchno.getText().toString();
                String quantityTXT = quantity.getText().toString();
                String costpriceTXT = costprice.getText().toString();
                String sellingpriceTXT = sellingprice.getText().toString();



                Boolean checkinsertdata = DB.insertproductdetails(tradenameTXT,commonnameTXT,compositionTXT,batchnoTXT,quantityTXT,costpriceTXT,sellingpriceTXT);
                if(checkinsertdata==true)

                    Toast.makeText(AddProduct.this,"New Product Added"+tradenameTXT,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddProduct.this,"Error adding product",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
