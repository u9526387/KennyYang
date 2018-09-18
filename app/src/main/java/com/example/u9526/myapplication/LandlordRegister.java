package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandlordRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_register);
    }

    public void jumpTolandlord_info(View v){
        Intent landlord_info=new Intent(this,Landlord_info.class);
        startActivity(landlord_info);
    }

    }
