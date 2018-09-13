package com.example.u9526.myapplication.RegisterLandlord;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.Constants;
import com.example.u9526.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LandlordRegister extends AppCompatActivity implements View.OnClickListener {
    private ActionBar toolbar;

    private EditText etName, etPhone, etPassword;
    private Button Nextstep;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_register);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("屋主註冊");//第一頁 title 設定為首頁


        etName = (EditText) findViewById(R.id.LandlordName);
        etPhone = (EditText) findViewById(R.id.LandlordPhone);
        etPassword = (EditText) findViewById(R.id.LandlordPassword);

        Nextstep = (Button) findViewById(R.id.FinishRegister);
        progressDialog = new ProgressDialog(this);
        Nextstep.setOnClickListener(this);


    }

    //傳到資料庫裡

    private void LandlordRegister() {
        final String username = etName.getText().toString().trim();
        final String phoneNum = etPhone.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        progressDialog.setMessage("Register user ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_LandlordRegister,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("phoneNum", phoneNum);
                params.put("password", password);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    //傳到資料庫裡

    @Override
    public void onClick(View view) {
        if (view == Nextstep)
            LandlordRegister();


        Intent Next = new Intent(this, Landlord_register2.class);
        startActivity(Next);
    }


}
