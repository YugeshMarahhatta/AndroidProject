package com.example.pharmacy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pharmacy.databinding.ActivityDashboardBinding;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    //for insertion
    EditText tradename,commonname,composition,batchno,quantity,costprice,sellingprice;
    Button add,addbutton,viewbtn2;
    DBHelper DB;


    ActivityDashboardBinding activityDashboardBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contyainer, new StockFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_view);
        }
//        addbutton = (Button)findViewById(R.id.addbutton);
//        addbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1 = new Intent(DashboardActivity.this, AddProduct.class );
//                startActivity(intent1);
//
//            }
//        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_view:
                break;
            case R.id.nav_stock:
                Intent intent1 = new Intent(DashboardActivity.this, fetchdata.class );
                startActivity(intent1);
                break;

            case R.id.nav_add:
                Intent intent2 = new Intent(DashboardActivity.this, AddProduct.class );
                startActivity(intent2);
                break;

            case R.id.nav_medicine:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contyainer,new MedicineFragment()).commit();
                break;

            case R.id.nav_vaccine:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contyainer,new VaccineFragment()).commit();
                break;


            case R.id.nav_surgical:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contyainer,new SurgicalFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Logout ?")
                .setCancelable(false)
                .setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DashboardActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


}
