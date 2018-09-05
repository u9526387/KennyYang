package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u9526.myapplication.RegisterLogin.ChooseIdentity;
import com.example.u9526.myapplication.RegisterLogin.NormalLogin;

public class MainActivity extends AppCompatActivity {

    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
