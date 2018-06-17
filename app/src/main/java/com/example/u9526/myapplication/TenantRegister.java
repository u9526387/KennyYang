package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TenantRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);
    }
    public void jumpTotenant_info(View v){
        Intent tenant_info=new Intent(this,TenantInfo.class);
        startActivity(tenant_info);
    }
}
