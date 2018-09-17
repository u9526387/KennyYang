package com.example.u9526.myapplication.RegisterLandlord;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.u9526.myapplication.R;

public class Landlord_register2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ActionBar toolbar;
    private Spinner spinner1, spinnerYear, spinnerMonth, spinnerDay, spinnerReligion;
    private int major_value;
    private String gender_value, spinnerYear_value, spinnerMonth_value, spinnerDay_value, spinnerReligion_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_register2);
        toolbar = getSupportActionBar();//上方tittle bar 工具列
        toolbar.setTitle("屋主註冊");//第一頁 title 設定為首頁


        //宣告
        Spinner spinner = findViewById(R.id.spinner1);
        Spinner spinnerYear = findViewById(R.id.spinnerYear);
        Spinner spinnerMonth = findViewById(R.id.spinnerMonth);
        Spinner spinnerDay = findViewById(R.id.spinnerDay);
        Spinner spinnerReligion = findViewById(R.id.spinnerReligion);
        //宣告



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spn_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        gender_value = spinner.getSelectedItem().toString();

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
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void jumpTolandlord_register3(View v) {
        Intent lttt = new Intent(this, landlord_register3.class);
        startActivity(lttt);
    }
}
