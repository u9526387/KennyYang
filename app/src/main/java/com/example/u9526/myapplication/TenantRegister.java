package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TenantRegister extends AppCompatActivity {
    EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);
        editTextPhone = findViewById(R.id.editTextPhone);
        findViewById(R.id.Confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editTextPhone.getText().toString().trim();
                if(number.isEmpty() || number.length() <10){
                    editTextPhone.setError("Number is required");
                    editTextPhone.requestFocus();
                    return;
                }

            }
        });
    }
    public void jumpTotenant_info(View v){
        Intent tenant_info=new Intent(this,TenantInfo.class);
        startActivity(tenant_info);
    }
}
