package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillRentInfo3 extends AppCompatActivity {

    private Button NextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info3);

        NextStep = (Button) findViewById(R.id.NextStep);
        NextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt= new Intent(FillRentInfo3.this,FillRentInfo4.class);
                startActivity(tt);
            }
        });


    }
}
