package com.example.u9526.myapplication.recommend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.R;
import com.example.u9526.myapplication.rent_homepage__search;
import com.example.u9526.myapplication.rent_homepgae;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class main_recommend extends AppCompatActivity {

    private Button TurnSearch;
    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    private static final String PRODUCT_URL = "http://140.136.155.135/testphp/api.php";

    //a list to store all the products
    List<house> houseList;

    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recommend);
        //getting the recyclerview from xml
        TurnSearch =(Button)findViewById(R.id.turnsearch);
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        houseList = new ArrayList<>();

        TurnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kk=new Intent(main_recommend.this,rent_homepage__search.class);
                startActivity(kk);
            }
        });
        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();

    }

    private void loadProducts() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                houseList.add(new house(
                                        product.getInt("id"),
                                        product.getString("title"),
                                        product.getString("shortdesc"),
                                        product.getDouble("price"),
                                        product.getString("image")
                                ));
                            }
//creating adapter object and setting it to recyclerview
                            HouseAdapter adapter = new HouseAdapter(main_recommend.this, houseList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
