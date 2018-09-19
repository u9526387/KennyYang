package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.u9526.myapplication.RegisterTenant.TenantRegister;

public class TenantRegister2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);
    }
    public void jumpTotenant_info(View v){
        Intent tenant_info=new Intent(this,TenantRegister.class);
        startActivity(tenant_info);
    }
}
