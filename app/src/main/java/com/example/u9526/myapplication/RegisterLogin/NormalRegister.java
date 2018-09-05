package com.example.u9526.myapplication.RegisterLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

public class NormalRegister extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_register);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText passworcheck = (EditText) findViewById(R.id.passwordcheck);
        final Button FinishRegister = (Button) findViewById(R.id.FinishRegister);

        FinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String passwordcheck = passworcheck.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {//PROBLEM
                                Intent intent = new Intent(NormalRegister.this,NormalLogin.class);
                                NormalRegister.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder  = new AlertDialog.Builder(NormalRegister.this);
                                builder.setMessage("Register Fail")
                                        .setNegativeButton("Retry" ,null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(NormalRegister.this);
                queue.add(registerRequest);

            }
        });

    }
}
