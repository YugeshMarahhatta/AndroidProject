package com.example.pharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private static int SPLASH_TIME_OUT  =3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        new Handler().postDelayed(new Runnable(){
        @Override
            public void run(){
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }
        },SPLASH_TIME_OUT);


    }
}
