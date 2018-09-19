package com.example.u9526.myapplication.HouseInfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class FillRentInfo4 extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextMRT, editTextTrain;
    private Spinner spinnerGender;
    private RadioButton rd_fire_yes, rd_fire_no, rd_pet_yes, rd_pet_no;
    private RadioGroup RadioGroupFire, RadioGroupPet;
    private CheckBox ch_store, ch_Dstore, ch_park, ch_school, ch_night, ch_hospital;
    private String gender_value, fire_value, pet_value, store_value, Dstore_value, park_value, school_value, night_value, hospital_value;
    private Button NextStep4;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info4);

        editTextMRT = (EditText) findViewById(R.id.editTextMRT);
        editTextTrain = (EditText) findViewById(R.id.editTextTrain);

        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);

        rd_fire_yes = (RadioButton) findViewById(R.id.rd_fire_yes);
        rd_fire_no = (RadioButton) findViewById(R.id.rd_fire_no);
        rd_pet_yes = (RadioButton) findViewById(R.id.rd_pet_yes);
        rd_pet_no = (RadioButton) findViewById(R.id.rd_pet_no);

        RadioGroupFire = (RadioGroup) findViewById(R.id.RadioGroupFire);
        RadioGroupPet = (RadioGroup) findViewById(R.id.RadioGroupPet);

        ch_store = (CheckBox) findViewById(R.id.ch_store);
        ch_Dstore = (CheckBox) findViewById(R.id.ch_Dstore);
        ch_park = (CheckBox) findViewById(R.id.ch_park);
        ch_school = (CheckBox) findViewById(R.id.ch_school);
        ch_night = (CheckBox) findViewById(R.id.ch_night);
        ch_hospital = (CheckBox) findViewById(R.id.ch_hospital);

        gender_value = "0";
        fire_value = "0";
        pet_value = "0";
        store_value = "0";
        Dstore_value = "0";
        park_value = "0";
        school_value = "0";
        night_value = "0";
        hospital_value = "0";

        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_dropdown_item_1line);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RadioGroupFire.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkid) {
                fire_value = ((RadioButton) findViewById(RadioGroupFire.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getBaseContext(), fire_value, Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroupPet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkid) {
                pet_value = ((RadioButton) findViewById(RadioGroupFire.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getBaseContext(), pet_value, Toast.LENGTH_SHORT).show();
            }
        });

        ch_store.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                store_value = ch_store.getText().toString();
            }
        });

        ch_Dstore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                Dstore_value = ch_Dstore.getText().toString();
            }
        });

        ch_park.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                park_value = ch_park.getText().toString();
            }
        });

        ch_school.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                school_value = ch_school.getText().toString();
            }
        });

        ch_night.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                night_value = ch_night.getText().toString();
            }
        });

        ch_hospital.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                hospital_value = ch_hospital.getText().toString();
            }
        });

        NextStep4 = (Button) findViewById(R.id.NextStep4);
        progressDialog = new ProgressDialog(this);
        NextStep4.setOnClickListener(this);


    }

    private void FillRentInfo4() {

        final String gender = gender_value.toString().trim();

        final String fire = fire_value.toString().trim();
        final String pet = pet_value.toString().trim();

        final String store = store_value.toString().trim();
        final String Dstore = Dstore_value.toString().trim();
        final String park = park_value.toString().trim();
        final String school = school_value.toString().trim();
        final String night = night_value.toString().trim();
        final String hospital = hospital_value.toString().trim();

        final String MRT = editTextMRT.getText().toString().trim();
        final String Train = editTextTrain.getText().toString().trim();


        progressDialog.setMessage("正在輸入 ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_HOUSE_INFO4,
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
                params.put("H_Gender", gender);
                params.put("rd_fire", fire);
                params.put("rd_pet", pet);
                params.put("ch_store", store);
                params.put("ch_Dstore", Dstore);
                params.put("ch_park", park);
                params.put("ch_school", school);
                params.put("ch_night", night);
                params.put("ch_hospital", hospital);
                params.put("H_MRT", MRT);
                params.put("H_Train", Train);


                return params;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View view) {
        if(view == NextStep4){
            FillRentInfo4();
        }
        Intent i = new Intent(this, FillRentInfo5.class);
        startActivity(i);

    }
}

