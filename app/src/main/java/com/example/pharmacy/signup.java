package com.example.pharmacy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class signup extends Activity {
    Button signedupbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);


        //signedup button
        signedupbtn = (Button)findViewById(R.id.signedupbtn);
        signedupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(signup.this, HomeActivity.class );
                startActivity(intent1);

            }
        });

    }
}
