package com.example.u9526.myapplication.HouseInfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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




public class FillRentInfo2 extends Activity implements View.OnClickListener {


    private EditText editTextAddress, editTextLivingRoom, editTextRoom, editTextToilet, editTextBalcony, editTextPing;
    private Spinner spinnerCity,spinnerRegion;
    private CheckBox checkRefrig, checkWash , checkTV, checkAir, checkHot, checkNet, checkFour , checkGas;
    private String City_Value,Region_Value;
    private String RefrigValue,WashValue,TVValue,AirValue,HotValue,NetValue,FourValue,GasValue;
    private Button NextStep2;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info2);

        //宣告區

        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextLivingRoom = (EditText) findViewById(R.id.editTextLivingRoom);
        editTextRoom = (EditText) findViewById(R.id.editTextRoom);
        editTextToilet = (EditText) findViewById(R.id.editTextToilet);
        editTextBalcony = (EditText) findViewById(R.id.editTextBalcony);
        editTextPing = (EditText) findViewById(R.id.editTextPing);
        checkRefrig = (CheckBox) findViewById(R.id.checkRefrig);
        checkWash = (CheckBox) findViewById(R.id.checkWash);
        checkTV = (CheckBox) findViewById(R.id.checkTV);
        checkAir = (CheckBox) findViewById(R.id.checkAir);
        checkHot = (CheckBox) findViewById(R.id.checkHot);
        checkNet = (CheckBox) findViewById(R.id.checkNet);
        checkFour = (CheckBox) findViewById(R.id.checkFour);
        checkGas = (CheckBox) findViewById(R.id.checkGas);

        //宣告區

        //先設值為0，PHP才不會讀到空值
        City_Value = "0";  Region_Value = "0";
        RefrigValue = "0";WashValue = "0";TVValue = "0"; AirValue = "0"; HotValue = "0"; NetValue = "0";FourValue = "0";GasValue = "0";
        //先設值為0，PHP才不會讀到空值




        NextStep2 = (Button) findViewById(R.id.NextStep2);
        progressDialog = new ProgressDialog(this);
        NextStep2.setOnClickListener(this);


        //選取城市的Spinner，將其轉為value並讀取。//
        ArrayAdapter<CharSequence> adapterCity_Value = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_dropdown_item_1line);
        adapterCity_Value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterCity_Value);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                City_Value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //選取城市的Spinner，將其轉為value並讀取。//

        //選取區域的Spinner，將其轉為value並讀取。//
        ArrayAdapter<CharSequence> adapterRegion_Value = ArrayAdapter.createFromResource(this, R.array.Taipei, android.R.layout.simple_dropdown_item_1line);
        adapterRegion_Value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(adapterRegion_Value);
        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Region_Value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //選取城市的Spinner，將其轉為value並讀取。//



        //觸發checkBox被選取的事件
        checkRefrig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RefrigValue = "1";
                //Refrig_value=得到的Text值
                //checkRefrig.setChecked(false)
                // 如果沒有被選取就False，由於value沒有改變，所以等下會傳0進資料庫
            }
        });
        //觸發chekcBox被選取的事件

        checkWash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                WashValue = "1";
            }
        });

        checkTV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TVValue = "1";
            }
        });

        checkAir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AirValue = "1";
            }
        });

        checkHot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                HotValue = "1";
            }
        });

        checkNet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                NetValue = "1";
            }
        });

        checkFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FourValue = "1";
            }
        });

        checkGas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                GasValue = "1";
            }
        });






    }

    private void FillRentInfo2() {

        final String City = City_Value.toString().trim();
        final String Region = Region_Value.toString().trim();
        final String Address = editTextAddress.getText().toString().trim();
        final String LivingRoom = editTextLivingRoom.getText().toString().trim();
        final String Room = editTextRoom.getText().toString().trim();
        final String Toilet = editTextToilet.getText().toString().trim();
        final String Balcony = editTextBalcony.getText().toString().trim();
        final String Ping = editTextPing.getText().toString().trim();
        final String Refrig = RefrigValue.toString().trim();
        final String Wash = WashValue.toString().trim();
        final String TV = TVValue.toString().trim();
        final String Air = AirValue.toString().trim();
        final String Hot = HotValue.toString().trim();
        final String Net = NetValue.toString().trim();
        final String Four = FourValue.toString().trim();
        final String Gas = GasValue.toString().trim();

        progressDialog.setMessage("正在輸入...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_HOUSE_INFO2,
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

                params.put("H_City",City);
                params.put("H_Region",Region);
                params.put("H_Address" , Address);
                params.put("H_LivingRoom", LivingRoom);
                params.put("H_Room", Room);
                params.put("H_Toilet", Toilet);
                params.put("H_Balcony", Balcony);
                params.put("H_Ping", Ping);
                params.put("checkRefrig", Refrig);
                params.put("checkWash", Wash);
                params.put("checkTV" , TV);
                params.put("checkAir" , Air);
                params.put("checkHot", Hot);
                params.put("checkNet", Net);
                params.put("checkFour" , Four);
                params.put("checkGas" , Gas);


                return params;


            }
        };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        }




        public void onClick (View view){
            if (view == NextStep2) {
                FillRentInfo2();
                Intent i = new Intent(FillRentInfo2.this, FillRentInfo3.class);
                startActivity(i);
            }

        }
    }


