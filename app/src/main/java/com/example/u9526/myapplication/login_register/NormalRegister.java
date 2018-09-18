package com.example.u9526.myapplication.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NormalRegister extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_register);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etTextPhone = (EditText) findViewById(R.id.etTextPhone);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText checkpassword = (EditText) findViewById(R.id.checkpassword);
        final Button Confirm = (Button) findViewById(R.id.Confirm);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                final String username = etTextPhone.getText().toString();
                final String password = etPassword.getText().toString();
                final String Checkpassword = checkpassword.getText().toString();
                

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success && password.equals(Checkpassword) && !TextUtils.isEmpty(etPassword.getText())) {//PROBLEM
                                Intent intent = new Intent(NormalRegister.this, NormalLogin.class);
                                NormalRegister.this.startActivity(intent);
                            } else if (!success && TextUtils.isEmpty(etPassword.getText())) {
                                etName.setError("Enter name...");
                                etName.requestFocus();

                                etTextPhone.setError("Enter phone...");
                                etTextPhone.requestFocus();

                                etPassword.setError("Enter password...");
                                etPassword.requestFocus();
                                return;
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