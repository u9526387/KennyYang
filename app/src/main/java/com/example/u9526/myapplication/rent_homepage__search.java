package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.recommend.main_recommend;
import com.example.u9526.myapplication.testregion.keysearch;

public class rent_homepage__search extends AppCompatActivity {
    private Button normalsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_homepage__search);
        normalsearch = (Button) findViewById(R.id.normalsearch);
        normalsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kk=new Intent(rent_homepage__search.this,main_recommend.class);
                startActivity(kk);
            }
        });
}
}
