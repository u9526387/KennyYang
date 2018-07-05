package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    }
    public void jumpTorent_homepage(View v){
        Intent jumptorent_homepage=new Intent(this,rent_homepgae.class);
        startActivity(jumptorent_homepage);

    }

}
