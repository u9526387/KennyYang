package com.example.u9526.myapplication.Rent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.u9526.myapplication.R;

public class rent_personalData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_personal_data);
    }

    public void jumpTorent_homepage(View v){
        Intent rent_homepage = new Intent(this, com.example.u9526.myapplication.Rent.rent_homepage.class);
        startActivity(rent_homepage);
    }

    public void jumpTorent_collection(View v){
        Intent rent_collection = new Intent(this, com.example.u9526.myapplication.Rent.rent_collection.class);
        startActivity(rent_collection);
    }
    public void jumpTorent_message(View v){
        Intent rent_message = new Intent(this, com.example.u9526.myapplication.Rent.rent_message.class);
        startActivity(rent_message);
    }
}
