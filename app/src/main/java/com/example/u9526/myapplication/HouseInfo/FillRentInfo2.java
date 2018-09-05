package com.example.u9526.myapplication.HouseInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.R;

public class FillRentInfo2 extends AppCompatActivity {

    private Button NextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info2);

        NextStep = (Button) findViewById(R.id.NextStep);
        NextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FillRentInfo2.this, FillRentInfo3.class);
                startActivity(i);
            }
        });


    }
}
