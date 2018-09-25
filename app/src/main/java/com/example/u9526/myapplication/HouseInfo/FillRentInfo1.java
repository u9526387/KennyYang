package com.example.u9526.myapplication.HouseInfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class FillRentInfo1 extends AppCompatActivity implements View.OnClickListener{


    private Button MoreHouseInfo;
    private EditText editTextHouseTitle;
    private Spinner spinnerRoomType, spinnerHouseType;
    private String RoomType_Value,HouseType_Value;
    private ProgressDialog progressDialog;
    private android.support.v7.app.ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info1);


        //宣告要填的東西
        editTextHouseTitle = (EditText) findViewById(R.id.HouseTitle);
        spinnerRoomType = (Spinner) findViewById(R.id.spinnerRoomType);
        spinnerHouseType = (Spinner) findViewById(R.id.spinnerHouseType);


        ArrayAdapter<CharSequence> adapterRoomType = ArrayAdapter.createFromResource(this,R.array.RoomType,android.R.layout.simple_spinner_item);
        adapterRoomType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoomType.setAdapter(adapterRoomType);
        spinnerRoomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RoomType_Value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        ArrayAdapter<CharSequence> adapterHouseType = ArrayAdapter.createFromResource(this,R.array.HouseType,android.R.layout.simple_spinner_item);
        adapterHouseType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHouseType.setAdapter(adapterHouseType);
        spinnerHouseType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                HouseType_Value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        MoreHouseInfo = (Button) findViewById(R.id.MoreHouseInfo);

        progressDialog = new ProgressDialog(this);

        MoreHouseInfo.setOnClickListener(this);



    }


    private void FillRentInfo1() {
        final String HouseTitle = editTextHouseTitle.getText().toString().trim();
        final String RoomType = RoomType_Value.toString().trim();
        final String HouseType = HouseType_Value.toString().trim();

        progressDialog.setMessage("正在填寫 ......");
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


                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("H_Title", HouseTitle);
                params.put("H_RoomType", RoomType);
                params.put("H_HouseType", HouseType);

                return params;
            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onClick(View view) {

        if(view == MoreHouseInfo){
            FillRentInfo1();
        }
        Intent i = new Intent(this, FillRentInfo2.class);
        startActivity(i);

    }


}