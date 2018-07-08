package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormalRegister extends AppCompatActivity {

    private Button FinishRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_register);

        FinishRegister = (Button) findViewById(R.id.FinishRegister);
        FinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NormalRegister.this,homepage.class);
                startActivity(i);
                //i = 註冊完打開主頁;
            }
        });



    }
}
