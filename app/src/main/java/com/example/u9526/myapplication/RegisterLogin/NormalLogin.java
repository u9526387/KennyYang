package com.example.u9526.myapplication.RegisterLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.R;
import com.example.u9526.myapplication.homepage;

import org.json.JSONException;
import org.json.JSONObject;

public class NormalLogin extends AppCompatActivity {
    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_login);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("登入");//第一頁 title 設定為首頁

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button FinishLogin = (Button) findViewById(R.id.FinishLogin);

        FinishLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success && username != null && password != null) {
                                Intent intent = new Intent(NormalLogin.this, homepage.class);
                                NormalLogin.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(NormalLogin.this);
                                builder.setMessage("Login Fail")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(NormalLogin.this);
                queue.add(loginRequest);
            }
        });
    }

}

