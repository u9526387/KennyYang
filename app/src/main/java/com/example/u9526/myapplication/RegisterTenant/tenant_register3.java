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
    private RadioGroup radioGroup1;
    private RadioButton smoke_radio_button_yes, smoke_radio_button_no;
    private CheckBox inChess, inChess2, inChess3;
    private String smoke_value;
    private String inChess_value, inChess2_value, inChess3_value;



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
        //宣告有radio buttonon＆radioGroup





        //smoke_value = ((RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId())).getText().toString();//取得RadioButton選取值


        //先設值為0，不為空，用PHP至少能讀到0
        smoke_value = "0";
        inChess_value = "0";
        //先設值為0，不為空，用PHP至少能讀到0





        inChess = (CheckBox) findViewById(R.id.inChess);
        inChess2 = (CheckBox) findViewById(R.id.inChess2);
        inChess3 = (CheckBox) findViewById(R.id.inChess3);


        //觸發Checkbox被選取的事件
        inChess.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                inChess_value = inChess.getText().toString();//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });
        //觸發Checkbox被選取的事件


        //觸發radioButton事件
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                smoke_value = ((RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId())).getText().toString();//smoke_value得到被選取的RadioButton的Text
                Toast.makeText(getBaseContext(), smoke_value, Toast.LENGTH_SHORT).show();
            }
        });
        //觸發radioButton事件


        Nextstep = (Button) findViewById(R.id.FinishRegister);

        progressDialog = new ProgressDialog(this);

        Nextstep.setOnClickListener(this);

    }


    //傳值進PHP
    private void Tenant_register3() {
        final String inChess = inChess_value.toString().trim();
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
                params.put("inChess", inChess);
                params.put("Smoke", Smoke);
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
