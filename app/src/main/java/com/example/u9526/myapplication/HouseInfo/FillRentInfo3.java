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

public class FillRentInfo3 extends AppCompatActivity implements View.OnClickListener{


    private EditText editTextRent,editTextDeposit;
    private CheckBox ch_bed,ch_closet,ch_sofa,ch_table,ch_chair;
    private Spinner spinnerShortRent,spinnerYear,spinnerMonth,spinnerDay;
    private RadioGroup RadioGroupCar,RadioGroupEleva;
    private RadioButton rd_car_yes,rd_car_no,rd_eleva_yes,rd_eleva_no;
    private String car_value,eleva_value,ShortRent_value,Year_value,Month_value,Day_value;
    private String bed_value,closet_value,sofa_value,table_value,chair_value;
    private ProgressDialog progressDialog;
    private Button NextStep3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info3);

        editTextRent = (EditText) findViewById(R.id.editTextRent);
        editTextDeposit = (EditText) findViewById(R.id.editTextDeposit);

        ch_bed = (CheckBox) findViewById(R.id.ch_bed);
        ch_closet = (CheckBox) findViewById(R.id.ch_closet);
        ch_sofa = (CheckBox) findViewById(R.id.ch_sofa);
        ch_table = (CheckBox) findViewById(R.id.ch_table);
        ch_chair = (CheckBox) findViewById(R.id.ch_chair);

        spinnerShortRent = (Spinner) findViewById(R.id.spinnerShortRent);
        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);

        rd_car_yes = (RadioButton) findViewById(R.id.rd_car_yes);
        rd_car_no = (RadioButton) findViewById(R.id.rd_car_no);
        rd_eleva_yes = (RadioButton) findViewById(R.id.rd_eleva_yes);
        rd_eleva_no = (RadioButton) findViewById(R.id.rd_eleva_no);

        RadioGroupCar = (RadioGroup) findViewById(R.id.RadioGroupCar);
        RadioGroupEleva = (RadioGroup) findViewById(R.id.RadioGroupEleva);

        car_value = "0";
        eleva_value = "0";
        ShortRent_value = "0";
        Year_value = "0";
        Month_value = "0";
        Day_value = "0";
        bed_value = "0";
        closet_value = "0";
        sofa_value = "0";
        table_value = "0";
        chair_value = "0";


        //////////設定RadioButton的value轉為string///////////
        RadioGroupCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkid) {
                car_value = ((RadioButton) findViewById(RadioGroupCar.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getBaseContext(), car_value, Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroupEleva.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkid) {
                eleva_value = ((RadioButton) findViewById(RadioGroupEleva.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getBaseContext(), eleva_value, Toast.LENGTH_SHORT).show();
            }
        });
        //////////設定RadioButton的value轉為string///////////



        ///////////設定checkbox的value轉為string/////////////
        ch_bed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bed_value = ch_bed.getText().toString();
            }
        });

        ch_closet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                closet_value = ch_closet.getText().toString();
            }
        });

        ch_sofa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cbuttonview, boolean isChecked) {
                sofa_value = ch_sofa.getText().toString();
            }
        });

        ch_table.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                table_value = ch_table.getText().toString();
            }
        });

        ch_chair.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                chair_value = ch_chair.getText().toString();
            }
        });
        ///////////設定checkbox的value轉為string/////////////


        ///////////////設定spinner的value///////////////////
        ArrayAdapter<CharSequence> adapterShortRent = ArrayAdapter.createFromResource(this,R.array.rent_time, android.R.layout.simple_dropdown_item_1line);
        adapterShortRent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortRent.setAdapter(adapterShortRent);
        spinnerShortRent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ShortRent_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterYear_value = ArrayAdapter.createFromResource(this, R.array.spn_year, android.R.layout.simple_dropdown_item_1line);
        adapterYear_value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapterYear_value);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Year_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterMonth_Value = ArrayAdapter.createFromResource(this, R.array.spn_month, android.R.layout.simple_dropdown_item_1line);
        adapterMonth_Value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterMonth_Value);
        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Month_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterDay_Value = ArrayAdapter.createFromResource(this, R.array.spn_day, android.R.layout.simple_dropdown_item_1line);
        adapterDay_Value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDay_Value);
        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Day_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        NextStep3 = (Button)findViewById(R.id.NextStep3);
        progressDialog = new ProgressDialog(this);
        NextStep3.setOnClickListener(this);



    }

    private void FillRentInfo3() {
        final String bed = bed_value.toString().trim();
        final String closet = closet_value.toString().trim();
        final String sofa = sofa_value.toString().trim();
        final String table = table_value.toString().trim();
        final String chair = chair_value.toString().trim();
        final String car = car_value.toString().trim();
        final String eleva = eleva_value.toString().trim();
        final String Rent = editTextRent.getText().toString().trim();
        final String Deposit = editTextDeposit.getText().toString().trim();
        final String ShortRent = ShortRent_value.toString().trim();
        final String Year = Year_value.toString().trim();
        final String Month = Month_value.toString().trim();
        final String Day = Day_value.toString().trim();



        progressDialog.setMessage("正在輸入 ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_HOUSE_INFO3,
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
                params.put("ch_bed", bed);
                params.put("ch_closet", closet);
                params.put("ch_sofa", sofa);
                params.put("ch_table", table);
                params.put("ch_chair", chair);
                params.put("rd_car", car);
                params.put("rd_eleva", eleva);
                params.put("H_Rent", Rent);
                params.put("H_Deposit", Deposit);
                params.put("H_ShortRent", ShortRent);
                params.put("H_Year", Year);
                params.put("H_Month", Month);
                params.put("H_Day", Day);


                return params;
            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View view) {
        if(view == NextStep3){
            FillRentInfo3();
        }
        Intent i = new Intent(this, FillRentInfo4.class);
        startActivity(i);
    }
}