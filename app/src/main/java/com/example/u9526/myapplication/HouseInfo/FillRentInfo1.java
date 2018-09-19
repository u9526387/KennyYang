package com.example.u9526.myapplication.HouseInfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.R;

public class FillRentInfo1 extends AppCompatActivity {


    private Button MoreHouseInfo;
    private ActionBar toolbar;
    private SharedPreferences user_data;

    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info1);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("填寫房屋資料");//第一頁 title 設定為首頁

        MoreHouseInfo = (Button)findViewById(R.id.MoreHouseInfo);
        MoreHouseInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(FillRentInfo1.this, FillRentInfo2.class);
                startActivity(x);
                //x = 繼續填寫下一頁;
            }
        });
    }

}
