package com.example.u9526.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class FillRentInfo2 extends Activity implements View.OnClickListener {


    private EditText editTextValley,editTextNong,editTextNumber,editTextFloor,editTextLivingRoom,editTextRoom,editTextToilet,editTextBalcony,editTextPing;
    private Button NextStep2;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info2);

        editTextValley = (EditText) findViewById(R.id.editTextValley);
        editTextNong = (EditText) findViewById(R.id.editTextNong);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextFloor = (EditText) findViewById(R.id.editTextFloor);
        editTextLivingRoom = (EditText) findViewById(R.id.editTextLivingRoom);
        editTextRoom = (EditText) findViewById(R.id.editTextRoom);
        editTextToilet = (EditText) findViewById(R.id.editTextToilet);
        editTextBalcony = (EditText) findViewById(R.id.editTextBalcony);
        editTextPing = (EditText) findViewById(R.id.editTextPing);

        NextStep2 = (Button) findViewById(R.id.NextStep2);
        progressDialog = new ProgressDialog(this);

        NextStep2.setOnClickListener(this);

    }

    private void FillRentInfo2(){
        final String Valley = editTextValley.getText().toString().trim();
        final String Nong = editTextNong.getText().toString().trim();
        final String Number = editTextNumber.getText().toString().trim();
        final String Floor = editTextFloor.getText().toString().trim();
        final String LivingRoom = editTextLivingRoom.getText().toString().trim();
        final String Room = editTextRoom.getText().toString().trim();
        final String Toilet = editTextToilet.getText().toString().trim();
        final String Balcony = editTextBalcony.getText().toString().trim();
        final String Ping = editTextPing.getText().toString().trim();

        progressDialog.setMessage("Filling now...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_HOUSE_INFO,
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
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Valley",Valley);
                params.put("Nong",Nong);
                params.put("Number",Number);
                params.put("Floor",Floor);
                params.put("LivingRoom",LivingRoom);
                params.put("Room",Room);
                params.put("Toilet",Toilet);
                params.put("Balcony",Balcony);
                params.put("Ping",Ping);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    @Override
    public void onClick(View view) {
       if(view == NextStep2){
           FillRentInfo2();
           Intent i = new Intent(FillRentInfo2.this,FillRentInfo3.class);
           startActivity(i);
       }

    }
}