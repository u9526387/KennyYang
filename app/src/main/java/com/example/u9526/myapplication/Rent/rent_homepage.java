package com.example.u9526.myapplication.Rent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.u9526.myapplication.HouseInfo.FillRentInfo1;
import com.example.u9526.myapplication.R;

public class rent_homepage extends AppCompatActivity {

    private ImageButton Rent;
    private ImageButton Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_homepage);

        Rent = (ImageButton) findViewById(R.id.Rent);
        Search = (ImageButton) findViewById(R.id.Search);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kkbox = new Intent(rent_homepage.this, rent_homepage__search___attribute.class);
                startActivity(kkbox);
            }
        });
        Rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(rent_homepage.this, FillRentInfo1.class);
                startActivity(i);
                // i = 填寫註冊頁面;
            }
        });

    }




}
