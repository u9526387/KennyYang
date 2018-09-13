package com.example.u9526.myapplication.RegisterTenant;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.u9526.myapplication.MainActivity;
import com.example.u9526.myapplication.R;

public class tenant_register3 extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register3);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("房客註冊");//第一頁 title 設定為首頁
    }

    public void jumpToMain(View v) {
        Intent mmmm = new Intent(this, MainActivity.class);
        startActivity(mmmm);
    }
}
