package com.example.u9526.myapplication.HouseInfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FillRentInfo5 extends AppCompatActivity implements View.OnClickListener {


    private Button buttonChoose,buttonUpload;
    private ImageView imageView;
    private EditText editText,editTextContact,editTextPhone,editTextEmail;
    private Spinner spinnerAM,spinnerPM;
    private String AM_value,PM_value;
    private ProgressDialog progressDialog;
    private Button FinishStep;

    private static final int STORAGE_PERMISSION_CODE = 2342;
    private static final int PICK_IMAGE_REQUEST = 22;

    private Uri filePath;
    private Bitmap bitmap;

    private static final String URL_UPLOAD = "http://140.136.155.135/testphp/upload.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_rent_info5);

        requestStoragePermission();

        editTextContact = (EditText) findViewById(R.id.editTextContact);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        spinnerAM = (Spinner) findViewById(R.id.spinnerAM);
        spinnerPM = (Spinner) findViewById(R.id.spinnerPM);

        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);

        imageView = (ImageView) findViewById(R.id.image);
        editText = (EditText) findViewById(R.id.editText);

        AM_value ="0";
        PM_value ="0";

        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapterAM = ArrayAdapter.createFromResource(this, R.array.day_time, android.R.layout.simple_dropdown_item_1line);
        adapterAM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAM.setAdapter(adapterAM);
        spinnerAM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AM_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterPM = ArrayAdapter.createFromResource(this, R.array.day_time, android.R.layout.simple_dropdown_item_1line);
        adapterAM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPM.setAdapter(adapterAM);
        spinnerPM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PM_value = parent.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FinishStep = (Button) findViewById(R.id.FinishStep);
        progressDialog = new ProgressDialog(this);
        FinishStep.setOnClickListener(this);





    }


    private void FillRentInfo5(){

        final String Contact = editTextContact.getText().toString().trim();
        final String Phone = editTextPhone.getText().toString().trim();
        final String AM = AM_value.toString().toString().trim();
        final String PM = PM_value.toString().toString().trim();
        final String Email = editTextEmail.getText().toString().trim();

        progressDialog.setMessage("正在輸入 ......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_HOUSE_INFO5,
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
                params.put("H_Contact", Contact);
                params.put("H_Phone", Phone);
                params.put("Contact_am", AM);
                params.put("Contact_pm", PM);
                params.put("H_Email", Email);



                return params;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void requestStoragePermission(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_LONG).show();
            }
        }

    }

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }catch (IOException e){

            }
        }

    }

    private String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null , null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);

        document_id = document_id.substring(document_id.lastIndexOf(":")+1);
        cursor.close();

        cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + " = ? ",
                new String[] {document_id},null
        );

        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }

    private void UploadImage(){
        String name = editText.getText().toString().trim();
        String path = getPath(filePath);

        try{
            String uploadid = UUID.randomUUID().toString();

            new MultipartUploadRequest(this, uploadid,URL_UPLOAD)
                    .addFileToUpload(path, "image")
                    .addParameter("name", name)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload();


        }catch (Exception e){

        }








    }

    @Override
    public void onClick(View view) {

        if(view == buttonUpload){
            UploadImage();
        }


        if(view == buttonChoose){
            showFileChooser();
        }

        if(view == FinishStep){
            FillRentInfo5();
        }

    }
}