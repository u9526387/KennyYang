package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseIdentity extends AppCompatActivity {

    private Button TenantR;
    private Button NormalR;
    private Button LandlordR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_identity);

        TenantR = (Button) findViewById(R.id.TenantR);
        TenantR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regi = new Intent(ChooseIdentity.this,TenantRegister2.class);
                startActivity(Regi);
            }
        });

        NormalR = (Button) findViewById(R.id.NormalR);
        NormalR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NormalRegi = new Intent(ChooseIdentity.this,NormalRegister.class);
                startActivity(NormalRegi);
            }
        });

        LandlordR = (Button) findViewById(R.id.LandlordR);
        LandlordR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LandlordRegi = new Intent(ChooseIdentity.this,LandlordRegister.class);
                startActivity(LandlordRegi);
            }
        });

    }
}
