package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.u9526.myapplication.Rent.rent_homepage;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    }
    public void jumpTorent_homepage(View v){
        Intent jumptorent_homepage = new Intent(this, rent_homepage.class);
        startActivity(jumptorent_homepage);

    }

}
