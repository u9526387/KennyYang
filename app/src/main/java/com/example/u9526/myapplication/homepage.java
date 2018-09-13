package com.example.u9526.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class homepage extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle(R.string.title_homepage);//第一頁 title 設定為首頁


    }
    public void jumpTorent_homepage(View v){
        Intent jumptorent_homepage = new Intent(this, bottom_navigation.class);
        startActivity(jumptorent_homepage);

    }

}
