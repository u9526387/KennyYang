package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class tenant_register3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register3);
    }

    public void jumpToMain(View v){
        Intent mmmm=new Intent(this,MainActivity.class);
        startActivity(mmmm);
    }
}
