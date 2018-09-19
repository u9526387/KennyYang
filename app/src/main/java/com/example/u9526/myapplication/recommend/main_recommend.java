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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class main_recommend extends AppCompatActivity implements HouseAdapter.OnItemClickListener {
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_ADDRESS = "address";
    public static final String EXTRA_PRICE = "price";
    public static final String EXTRA_CAR = "car";
    public static final String EXTRA_GENDER = "gender";
    public static final String EXTRA_PET = "pet";
    public static final String EXTRA_VALLEY = "valley";
    public static final String EXTRA_NONG = "nong";
    public static final String EXTRA_HOUSENUMBER = "housenumber";
    public static final String EXTRA_FLOOR = "floor";
    public static final String EXTRA_LIVINGROOM = "livingroom";
    public static final String EXTRA_ROOM = "room";
    public static final String EXTRA_TOILET = "toilet";
    public static final String EXTRA_BALCONY = "balcony";
    public static final String EXTRA_PING = "ping";

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
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TurnSearch = findViewById(R.id.turnsearch);
        //initializing the productlist
        houseList = new ArrayList<>();

        TurnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kk = new Intent(main_recommend.this, rent_homepage__search.class);
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
                                        product.getString("address"),
                                        product.getInt("price"),
                                        product.getString("image"),
                                        product.getString("car"),
                                        product.getString("gender"),
                                        product.getString("pet"),
                                        product.getString("valley"),
                                        product.getString("nong"),
                                        product.getString("housenumber"),
                                        product.getString("floor"),
                                        product.getString("livingroom"),
                                        product.getString("room"),
                                        product.getString("toilet"),
                                        product.getString("balcony"),
                                        product.getString("ping")
                                ));
                            }
//creating adapter object and setting it to recyclerview
                            HouseAdapter adapter = new HouseAdapter(main_recommend.this, houseList);
                            recyclerView.setAdapter(adapter);

                            adapter.setOnItemClickListener(main_recommend.this);
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

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, Showhousedetail.class);
        house clickItem = houseList.get(position);

        detailIntent.putExtra(EXTRA_IMAGE, clickItem.getImage());
        detailIntent.putExtra(EXTRA_TITLE, clickItem.getTitle());
        detailIntent.putExtra(EXTRA_PRICE, clickItem.getPrice());
        detailIntent.putExtra(EXTRA_ADDRESS, clickItem.getAddress());
        detailIntent.putExtra(EXTRA_CAR, clickItem.getCar());
        detailIntent.putExtra(EXTRA_GENDER, clickItem.getGender());
        detailIntent.putExtra(EXTRA_PET, clickItem.getPet());
        detailIntent.putExtra(EXTRA_VALLEY, clickItem.getValley());
        detailIntent.putExtra(EXTRA_NONG, clickItem.getNong());
        detailIntent.putExtra(EXTRA_HOUSENUMBER, clickItem.getHousenumber());
        detailIntent.putExtra(EXTRA_FLOOR, clickItem.getFloor());
        detailIntent.putExtra(EXTRA_LIVINGROOM, clickItem.getLivingroom());
        detailIntent.putExtra(EXTRA_ROOM, clickItem.getRoom());
        detailIntent.putExtra(EXTRA_TOILET, clickItem.getToilet());
        detailIntent.putExtra(EXTRA_BALCONY, clickItem.getBalcony());
        detailIntent.putExtra(EXTRA_PING, clickItem.getPing());


        startActivity(detailIntent);
    }
}
