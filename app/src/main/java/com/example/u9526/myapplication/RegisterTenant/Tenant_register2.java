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

    private Spinner spinner1, spinnerYear, spinnerMonth, spinnerDay, spinnerReligion;
    private int major_value;
    private String gender_value, spinnerYear_value, spinnerMonth_value, spinnerDay_value, spinnerReligion_value;


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
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinnerYear = findViewById(R.id.spinnerYear);
        Spinner spinnerMonth = findViewById(R.id.spinnerMonth);
        Spinner spinnerDay = findViewById(R.id.spinnerDay);
        Spinner spinnerReligion = findViewById(R.id.spinnerReligion);

        //宣告

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spn_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        spinnerYear.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(this, R.array.spn_month, android.R.layout.simple_spinner_item);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterMonth);
        spinnerMonth.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterDay = ArrayAdapter.createFromResource(this, R.array.spn_day, android.R.layout.simple_spinner_item);
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDay);
        spinnerDay.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterReligion = ArrayAdapter.createFromResource(this, R.array.spn_religion, android.R.layout.simple_spinner_item);
        adapterReligion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReligion.setAdapter(adapterReligion);
        spinnerReligion.setOnItemSelectedListener(this);


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
                params.put("Address", Address);
                params.put("IDnumber", IDnumber);
                params.put("School", School);
                params.put("Departent", Departent);
                params.put("gender", gender);
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














