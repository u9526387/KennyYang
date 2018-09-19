package com.example.u9526.myapplication.RegisterTenant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.Constants;
import com.example.u9526.myapplication.MainActivity;
import com.example.u9526.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class tenant_register3 extends AppCompatActivity implements View.OnClickListener {
    private Button Nextstep;
    private ProgressDialog progressDialog;
    private ActionBar toolbar;
    private RadioGroup radioGroup1, radioGroupPet;
    private RadioButton smoke_radio_button_yes, smoke_radio_button_no, pet_rb_yes, pet_rb_no;
    private CheckBox interest1, interest2, interest3, interest4, interest5, interest6, interest7, interest8, interest9;
    private String smoke_value, pet_value;
    private String interest1_value, interest2_value, interest3_value, interest4_value, interest5_value, interest6_value, interest7_value, interest8_value, interest9_value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register3);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("房客註冊");//第一頁 title 設定為首頁


        //宣告有radio buttonon＆radioGroup
        smoke_radio_button_yes = (RadioButton) findViewById(R.id.smoke_radio_button_yes);
        smoke_radio_button_no = (RadioButton) findViewById(R.id.smoke_radio_button_no);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        pet_rb_yes = (RadioButton) findViewById(R.id.pet_rb_yes);
        pet_rb_no = (RadioButton) findViewById(R.id.pet_rb_no);
        radioGroupPet = (RadioGroup) findViewById(R.id.radioGroupPet);
        //宣告有radio buttonon＆radioGroup





        //smoke_value = ((RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId())).getText().toString();//取得RadioButton選取值


        //先設值為0，不為空，用PHP至少能讀到0
        smoke_value = "0";
        pet_value = "0";
        interest1_value = "0";
        interest2_value = "0";
        interest3_value = "0";
        interest4_value = "0";
        interest5_value = "0";
        interest6_value = "0";
        interest7_value = "0";
        interest8_value = "0";
        interest9_value = "0";


        //先設值為0，不為空，用PHP至少能讀到0


        interest1 = (CheckBox) findViewById(R.id.inChess);
        interest2 = (CheckBox) findViewById(R.id.inChess2);
        interest3 = (CheckBox) findViewById(R.id.inChess3);
        interest4 = (CheckBox) findViewById(R.id.inMusic);
        interest5 = (CheckBox) findViewById(R.id.inDance);
        interest6 = (CheckBox) findViewById(R.id.inTree);
        interest7 = (CheckBox) findViewById(R.id.inPhoto);
        interest8 = (CheckBox) findViewById(R.id.inHiking);
        interest9 = (CheckBox) findViewById(R.id.inTvgame);




        //觸發Checkbox被選取的事件
        interest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //interest1_value = interest1.getText().toString();//inChess_value=得到的Text值
                interest1_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });
        //觸發Checkbox被選取的事件
        interest2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest2_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest3_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest4_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest4_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest6_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest7_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest8_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        interest9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                interest9_value = "1";
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });











        //觸發radioButton事件
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                smoke_value = ((RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId())).getText().toString();//smoke_value得到被選取的RadioButton的Text

                Toast.makeText(getBaseContext(), smoke_value, Toast.LENGTH_SHORT).show();

                smoke_value = "1";
            }
        });
        //觸發radioButton事件
        radioGroupPet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pet_value = ((RadioButton) findViewById(radioGroupPet.getCheckedRadioButtonId())).getText().toString();

                smoke_value = "1";
            }
        });


        Nextstep = (Button) findViewById(R.id.FinishRegister);

        progressDialog = new ProgressDialog(this);

        Nextstep.setOnClickListener(this);

    }


    //傳值進PHP
    private void Tenant_register3() {
        final String inChess = interest1_value.toString().trim();
        final String Smoke = smoke_value.toString().trim();

        progressDialog.setMessage("Register user ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_TENANT_REGISTER3,
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
                params.put("T_ChineseChess", inChess);
                params.put("T_Smoke", Smoke);
                params.put("T_Pet", pet_value);
                params.put("T_Chess", interest2_value);
                params.put("T_Mahjong", interest3_value);
                params.put("T_Instrument", interest4_value);
                params.put("T_Dance", interest5_value);
                params.put("T_Garden", interest6_value);
                params.put("T_Photography", interest7_value);
                params.put("T_Climbing", interest8_value);
                params.put("T_TVgame", interest9_value);


                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    //傳值進PHP

    @Override
    public void onClick(View view) {
        if (view == Nextstep)
            Tenant_register3();
        //按完Button 動作


        Intent Next = new Intent(this, MainActivity.class);
        startActivity(Next);
    }

}
