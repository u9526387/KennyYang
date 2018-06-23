package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rent_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_message);
    }
    public void jumpTorent_homepage(View v){
        Intent rent_homepage=new Intent(this,rent_homepgae.class);
        startActivity(rent_homepage);
    }

    public void jumpTorent_collection(View v){
        Intent rent_collection=new Intent(this, com.example.u9526.myapplication.rent_collection.class);
        startActivity(rent_collection);
    }

    public void jumpTorent_personalData(View v){
        Intent rent_personalData=new Intent(this,rent_personalData.class);
        startActivity(rent_personalData);
    }
}
