package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormalLogin extends AppCompatActivity {

    private Button FinishRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_login);

        FinishRegister = (Button) findViewById(R.id.FinishRegister);
        FinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FinishRegi = new Intent(NormalLogin.this,homepage.class);
                startActivity(FinishRegi);
            }
        });

    }


    }

