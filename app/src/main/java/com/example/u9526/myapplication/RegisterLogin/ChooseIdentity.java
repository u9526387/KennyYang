package com.example.u9526.myapplication.RegisterLogin;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.RegisterLandlord.LandlordRegister;
import com.example.u9526.myapplication.R;
import com.example.u9526.myapplication.RegisterTenant.TenantRegister;

public class ChooseIdentity extends AppCompatActivity {

    private Button TenantR;
    private Button NormalR;
    private Button LandlordR;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_identity);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("選擇註冊身份");//第一頁 title 設定為首頁

        TenantR = (Button) findViewById(R.id.TenantR);
        TenantR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regi = new Intent(ChooseIdentity.this, TenantRegister.class);
                startActivity(Regi);
            }
        });

        NormalR = (Button) findViewById(R.id.NormalR);
        NormalR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NormalRegi = new Intent(ChooseIdentity.this, NormalRegister.class);
                startActivity(NormalRegi);
            }
        });

        LandlordR = (Button) findViewById(R.id.LandlordR);
        LandlordR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LandlordRegi = new Intent(ChooseIdentity.this, LandlordRegister.class);
                startActivity(LandlordRegi);
            }
        });

    }
}
