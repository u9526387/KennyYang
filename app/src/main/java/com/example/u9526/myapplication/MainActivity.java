package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.login_register.ChooseIdentity;
import com.example.u9526.myapplication.login_register.NormalLogin;

public class MainActivity extends AppCompatActivity {

    private Button Register;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("吾居無束");//第一頁 title 設定為首頁

        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ChooseIdentity.class);
                startActivity(i);
                // i = choose identity
            }
        });


    }

    public void jumpTologin(View v) {
        Intent l = new Intent(this, NormalLogin.class);
        startActivity(l);


//i love ivy

    }
}
