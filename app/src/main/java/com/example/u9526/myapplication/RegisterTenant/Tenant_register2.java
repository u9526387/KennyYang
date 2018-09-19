package com.example.u9526.myapplication.RegisterTenant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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

public class Tenant_register2 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private EditText editTextAddress, editTextSchool, editTextDepartent, editTextIDnumber;
    private Button Nextstep;
    private ProgressDialog progressDialog;
    private ActionBar toolbar;

    private Spinner spGender, spinnerYear, spinnerMonth, spinnerDay, spinnerReligion;
    private int major_value;
    private String gender_value, spinnerYear_value, spinnerMonth_value, spinnerDay_value, spinnerReligion_value;
    private CheckBox cbChinese, cbEnglish, cbTaiwanese, cbBike, cbScooter, cbCar;
    private String cbChinese_value, cbEnglish_value, cbTaiwanese_value, cbBike_value, cbScooter_value, cbCar_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register2);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("房客註冊");//第一頁 title 設定為首頁

        editTextAddress = (EditText) findViewById(R.id.Address);
        editTextIDnumber = (EditText) findViewById(R.id.IDnumbers);
        editTextSchool = (EditText) findViewById(R.id.School);
        editTextDepartent = (EditText) findViewById(R.id.Departent);
        //宣告
        spGender = (Spinner) findViewById(R.id.spGender);
        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        spinnerReligion = (Spinner) findViewById(R.id.spinnerReligion);


        cbChinese = (CheckBox) findViewById(R.id.cbChinese);
        cbEnglish = (CheckBox) findViewById(R.id.cbEnglish);
        cbTaiwanese = (CheckBox) findViewById(R.id.cbTaiwnese);
        cbBike = (CheckBox) findViewById(R.id.cbBike);
        cbScooter = (CheckBox) findViewById(R.id.cbScooter);
        cbCar = (CheckBox) findViewById(R.id.cbCar);
        cbChinese_value = "0";
        cbEnglish_value = "0";
        cbTaiwanese_value = "0";
        cbBike_value = "0";
        cbScooter_value = "0";
        cbCar_value = "0";

        //觸發Checkbox被選取的事件
        cbChinese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbChinese_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });
        //觸發Checkbox被選取的事件
        cbEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbEnglish_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });


        cbTaiwanese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbTaiwanese_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        cbBike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbBike_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        cbScooter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbScooter_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });

        cbCar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cbCar_value = "1";//inChess_value=得到的Text值
                //inChess.setChecked(false);//如果沒有被選取就False，由於inChess_value沒有改變，所以等下會傳0進資料庫


            }
        });


        //宣告

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spn_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                gender_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(this, R.array.spn_year, android.R.layout.simple_spinner_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapterYear);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerYear_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(this, R.array.spn_month, android.R.layout.simple_spinner_item);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterMonth);
        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerMonth_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterDay = ArrayAdapter.createFromResource(this, R.array.spn_day, android.R.layout.simple_spinner_item);
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDay);
        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerDay_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterReligion = ArrayAdapter.createFromResource(this, R.array.spn_religion, android.R.layout.simple_spinner_item);
        adapterReligion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReligion.setAdapter(adapterReligion);
        spinnerReligion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerReligion_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Nextstep = (Button) findViewById(R.id.Finish);

        progressDialog = new ProgressDialog(this);

        Nextstep.setOnClickListener(this);


    }

    //傳值進PHP
    private void Tenant_register2() {



        final String Address = editTextAddress.getText().toString().trim();
        final String IDnumber = editTextIDnumber.getText().toString().trim();
        final String School = editTextSchool.getText().toString().trim();
        final String Departent = editTextDepartent.getText().toString().trim();
        final String gender = gender_value.toString().trim();
        final String BrithdayYear = spinnerYear_value.toString().trim();
        final String BrithdayMonth = spinnerMonth_value.toString().trim();
        final String BrithdayDay = spinnerDay_value.toString().trim();
        final String Religion = spinnerReligion_value.toString().trim();

        progressDialog.setMessage("Register user ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_TENANT_REGISTER2,
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
                params.put("T_Address", Address);
                params.put("T_IDnumber", IDnumber);
                params.put("T_School", School);
                params.put("T_Department", Departent);
                params.put("T_Gender", gender);
                params.put("T_BrithdayYear", BrithdayYear);
                params.put("T_BrithdayMonth", BrithdayMonth);
                params.put("T_BrithdayDay", BrithdayDay);
                params.put("T_Religion", Religion);
                params.put("T_LanguageC", cbChinese_value);
                params.put("T_LanguageE", cbEnglish_value);
                params.put("T_LanguageT", cbTaiwanese_value);
                params.put("T_TransportationBike", cbBike_value);
                params.put("T_TransportationScooter", cbScooter_value);
                params.put("T_TransportationCar", cbCar_value);




                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    //傳值進PHP


    //以下到210行沒用到，但刪掉會錯，故先放著
    /**
     *
     *
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Impelmenters can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, gender_value, Toast.LENGTH_SHORT).show();


    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    public void onNothingSelected(AdapterView<?> parent) {


    }

    //以上程式碼沒用到

    @Override
    public void onClick(View view) {
        if (view == Nextstep)
            Tenant_register2();
        //按完Button 動作


        Intent Next = new Intent(this, tenant_register3.class);
        startActivity(Next);
    }
}














