package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillRentInfo3 extends AppCompatActivity {

    private Button NextStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info3);

        NextStep3 = (Button) findViewById(R.id.NextStep3);
        NextStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(FillRentInfo3.this, com.example.u9526.myapplication.FillRentInfo4.class);
                startActivity(i3);
            }
        });


    }
}
