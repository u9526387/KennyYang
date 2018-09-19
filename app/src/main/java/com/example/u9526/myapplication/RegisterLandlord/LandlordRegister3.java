package com.example.u9526.myapplication.RegisterLandlord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.u9526.myapplication.MainActivity;
import com.example.u9526.myapplication.R;

public class LandlordRegister3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_register3);
    }


    public void jumpToMain(View v) {
        Intent mmmm = new Intent(this, MainActivity.class);
        startActivity(mmmm);
    }
}
