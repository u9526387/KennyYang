package com.example.u9526.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Tenant_register2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register2);





        Spinner spinner =findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spn_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);
         spinner.setOnItemSelectedListener(this);

        Spinner spinnerYear =findViewById(R.id.spinnerYear);
        ArrayAdapter<CharSequence> adapterYear =ArrayAdapter.createFromResource(this,R.array.spn_year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapterYear);
        spinnerYear.setOnItemSelectedListener(this);


        Spinner spinnerMonth =findViewById(R.id.spinnerMonth);
        ArrayAdapter<CharSequence> adapterMonth =ArrayAdapter.createFromResource(this,R.array.spn_month, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterMonth);
        spinnerMonth.setOnItemSelectedListener(this);


        Spinner spinnerDay =findViewById(R.id.spinnerDay);
        ArrayAdapter<CharSequence> adapterDay =ArrayAdapter.createFromResource(this,R.array.spn_day, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDay);
        spinnerDay.setOnItemSelectedListener(this);




        Spinner spinnerReligion =findViewById(R.id.spinnerReligion);
        ArrayAdapter<CharSequence> adapterReligion =ArrayAdapter.createFromResource(this,R.array.spn_religion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReligion.setAdapter(adapterReligion);
        spinnerReligion.setOnItemSelectedListener(this);








    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void jumpTotenant_info2(View v){
        Intent tenant_info2=new Intent(this,tenant_register3.class);
        startActivity(tenant_info2);
    }

}








