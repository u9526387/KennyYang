package com.example.u9526.myapplication.RegisterTenant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class TenantRegister extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences user_data;
    private int pair_lord_status = -1, pair_angel_status = -1, userid;//傳值用
    private String token;//半段使用者裝置重複用
    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    //弓弦
    private EditText editTextusername, editTextphoneNumber, editTextpassword;
    private Button Jump;
    private ProgressDialog progressDialog;
    private ActionBar toolbar;
    //弓弦




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("房客註冊");//第一頁 title 設定為首頁

        editTextusername = (EditText) findViewById(R.id.username);
        editTextphoneNumber = (EditText) findViewById(R.id.phoneNumber);
        editTextpassword = (EditText) findViewById(R.id.password);


        Jump = (Button) findViewById(R.id.jumpTotr2);

        progressDialog = new ProgressDialog(this);


        Jump.setOnClickListener(this);


    }


    private void tenantRegister() {
        final String username = editTextusername.getText().toString().trim();
        final String phoneNumber = editTextphoneNumber.getText().toString().trim();
        final String password = editTextpassword.getText().toString().trim();

        progressDialog.setMessage("Register user ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_TENANT_REGISTER,
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
                params.put("phoneNumber", phoneNumber);
                params.put("password", password);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    @Override
    public void onClick(View view) {
        if (view == Jump)
            tenantRegister();


        Intent Next = new Intent(this, Tenant_register2.class);
        startActivity(Next);
    }


}














