package com.example.u9526.myapplication.RegisterTenant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class Tenant_register2 extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextAddress, editTextSchool, editTextDepartent, editTextIDnumber;
    private Button Nextstep;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register2);

        editTextAddress = (EditText) findViewById(R.id.Address);
        editTextIDnumber = (EditText) findViewById(R.id.IDnumbers);
        editTextSchool = (EditText) findViewById(R.id.School);
        editTextDepartent = (EditText) findViewById(R.id.Departent);

        Nextstep = (Button) findViewById(R.id.Finish);

        progressDialog = new ProgressDialog(this);

        Nextstep.setOnClickListener(this);


    }


    private void registerUser() {
        final String Address = editTextAddress.getText().toString().trim();
        final String IDnumber = editTextIDnumber.getText().toString().trim();
        final String School = editTextSchool.getText().toString().trim();
        final String Departent = editTextDepartent.getText().toString().trim();

        progressDialog.setMessage("Register user ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
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
                params.put("Address", Address);
                params.put("IDnumber", IDnumber);
                params.put("School", School);
                params.put("Departent", Departent);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    @Override
    public void onClick(View view) {
        if (view == Nextstep)
            registerUser();


        Intent Next = new Intent(this, tenant_register3.class);
        startActivity(Next);
    }


}














