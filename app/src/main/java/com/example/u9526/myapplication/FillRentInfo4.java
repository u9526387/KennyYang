package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillRentInfo4 extends AppCompatActivity {

    private Button NextStep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info4);

        NextStep4 = (Button) findViewById(R.id.NextStep4);
        NextStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(FillRentInfo4.this,FillRentInfo5.class);
                startActivity(i4);
            }
        });




    }
}
