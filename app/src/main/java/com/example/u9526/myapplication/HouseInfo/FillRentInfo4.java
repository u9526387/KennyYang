package com.example.u9526.myapplication.HouseInfo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.u9526.myapplication.R;

public class FillRentInfo4 extends AppCompatActivity {
    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info4);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("填寫房屋資料");//第一頁 title 設定為首頁


    }
}
