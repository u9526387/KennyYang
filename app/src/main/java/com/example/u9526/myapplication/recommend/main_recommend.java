package com.example.u9526.myapplication.recommend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.u9526.myapplication.R;
import com.example.u9526.myapplication.Rent.rent_homepage__search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class main_recommend extends AppCompatActivity implements HouseAdapter.OnItemClickListener {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_ROOMTYPE = "roomtype";
    public static final String EXTRA_HOUSETYPE = "housetype";
    public static final String EXTRA_CAR = "car";
    public static final String EXTRA_GENDER = "gender";
    public static final String EXTRA_PET = "pet";
    public static final String EXTRA_LIVINGROOM = "livingroom";
    public static final String EXTRA_ROOM = "room";
    public static final String EXTRA_TOILET = "toilet";
    public static final String EXTRA_BALCONY = "balcony";
    public static final String EXTRA_PING = "ping";
    public static final String EXTRA_CITY = "city";
    public static final String EXTRA_REGION = "region";
    public static final String EXTRA_ADDRESS = "address";
    public static final String EXTRA_CHECKREFRIG = "checkrefrig";
    public static final String EXTRA_CHECKWASH = "checkwash";
    public static final String EXTRA_CHECKTV = "checktv";
    public static final String EXTRA_CHECKAIR = "checkair";
    public static final String EXTRA_CHECKHOT = "checkhot";
    public static final String EXTRA_CHECKNET = "checknet";
    public static final String EXTRA_CHECKFOUR = "checkfour";
    public static final String EXTRA_CHECKGAS = "checkgas";
    public static final String EXTRA_BED = "bed";
    public static final String EXTRA_CLOSET = "closet";
    public static final String EXTRA_SOFA = "sofa";
    public static final String EXTRA_TABLE = "table";
    public static final String EXTRA_CHAIR = "chair";
    public static final String EXTRA_ELEVA = "eleva";
    public static final String EXTRA_RENT = "rent";
    public static final String EXTRA_DESPOSIT = "desposit";
    public static final String EXTRA_SHORTRENT = "shortrent";
    public static final String EXTRA_YEAR = "year";
    public static final String EXTRA_MONTH = "month";
    public static final String EXTRA_DAY = "day";
    public static final String EXTRA_FIRE = "fire";
    public static final String EXTRA_STORE = "store";
    public static final String EXTRA_DSTORE = "dstore";
    public static final String EXTRA_PARK = "park";
    public static final String EXTRA_SCHOOL = "school";
    public static final String EXTRA_NIGHT = "night";
    public static final String EXTRA_HOSPITAL = "hospital";
    public static final String EXTRA_MRT = "MRT";
    public static final String EXTRA_TRAIN = "train";
    public static final String EXTRA_CONTACT = "contact";
    public static final String EXTRA_PHONE = "phone";
    public static final String EXTRA_CONTACT_AM = "contact_am";
    public static final String EXTRA_CONTACT_PM = "contact_pm";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_IMAGE = "image";
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
        getSupportActionBar().hide();
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
        EditText editText = findViewById(R.id.editText14);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

        });
    }


    private void filter(String text) {
        ArrayList<house> filteredList = new ArrayList<>();

        for (house item : houseList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        HouseAdapter.filterList(filteredList);
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
                                        product.getInt("ID"),
                                        product.getString("H_Title"),
                                        product.getString("H_RoomType"),
                                        product.getString("H_HouseType"),
                                        product.getString("H_City"),
                                        product.getString("H_Region"),
                                        product.getString("H_Address"),
                                        product.getString("H_LivingRoom"),
                                        product.getString("H_Room"),
                                        product.getString("H_Toilet"),
                                        product.getString("H_Balcony"),
                                        product.getString("H_Ping"),
                                        product.getString("H_CheckRefrig"),
                                        product.getString("H_CheckWash"),
                                        product.getString("H_CheckTV"),
                                        product.getString("H_CheckAir"),
                                        product.getString("H_CheckHot"),
                                        product.getString("H_CheckNet"),
                                        product.getString("H_CheckFour"),
                                        product.getString("H_CheckGas"),
                                        product.getString("ch_bed"),
                                        product.getString("ch_closet"),
                                        product.getString("ch_sofa"),
                                        product.getString("ch_table"),
                                        product.getString("ch_chair"),
                                        product.getString("rd_car"),
                                        product.getString("rd_eleva"),
                                        product.getString("H_Rent"),
                                        product.getString("H_Desposit"),
                                        product.getString("H_ShortRent"),
                                        product.getString("H_Year"),
                                        product.getString("H_Month"),
                                        product.getString("H_Day"),
                                        product.getString("H_Gender"),
                                        product.getString("rd_fire"),
                                        product.getString("rd_pet"),
                                        product.getString("ch_store"),
                                        product.getString("ch_Dstore"),
                                        product.getString("ch_park"),
                                        product.getString("ch_school"),
                                        product.getString("ch_night"),
                                        product.getString("ch_hospital"),
                                        product.getString("H_MRT"),
                                        product.getString("H_Train"),
                                        product.getString("H_Contact"),
                                        product.getString("H_Phone"),
                                        product.getString("H_Contact_am"),
                                        product.getString("H_Contact_pm"),
                                        product.getString("H_Email"),
                                        product.getString("url"),
                                        product.getString("name")
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
        detailIntent.putExtra(EXTRA_ROOMTYPE, clickItem.getRoomtype());
        detailIntent.putExtra(EXTRA_HOUSETYPE, clickItem.getHousetype());
        detailIntent.putExtra(EXTRA_CITY, clickItem.getCity());
        detailIntent.putExtra(EXTRA_REGION, clickItem.getRegion());
        detailIntent.putExtra(EXTRA_ADDRESS, clickItem.getAddress());
        detailIntent.putExtra(EXTRA_LIVINGROOM, clickItem.getLivingroom());
        detailIntent.putExtra(EXTRA_ROOM, clickItem.getRoom());
        detailIntent.putExtra(EXTRA_TOILET, clickItem.getToilet());
        detailIntent.putExtra(EXTRA_BALCONY, clickItem.getBalcony());
        detailIntent.putExtra(EXTRA_PING, clickItem.getPing());
        detailIntent.putExtra(EXTRA_CHECKREFRIG, clickItem.getCheckrefrig());
        detailIntent.putExtra(EXTRA_CHECKWASH, clickItem.getCheckwash());
        detailIntent.putExtra(EXTRA_CHECKTV, clickItem.getCheckTV());
        detailIntent.putExtra(EXTRA_CHECKAIR, clickItem.getCheckair());
        detailIntent.putExtra(EXTRA_CHECKHOT, clickItem.getCheckhot());
        detailIntent.putExtra(EXTRA_CHECKNET, clickItem.getChecknet());
        detailIntent.putExtra(EXTRA_CHECKFOUR, clickItem.getCheckfour());
        detailIntent.putExtra(EXTRA_CHECKGAS, clickItem.getCheckgas());
        detailIntent.putExtra(EXTRA_BED, clickItem.getBed());
        detailIntent.putExtra(EXTRA_CLOSET, clickItem.getCloset());
        detailIntent.putExtra(EXTRA_SOFA, clickItem.getSofa());
        detailIntent.putExtra(EXTRA_TABLE, clickItem.getTable());
        detailIntent.putExtra(EXTRA_CHAIR, clickItem.getChair());
        detailIntent.putExtra(EXTRA_CAR, clickItem.getCar());
        detailIntent.putExtra(EXTRA_ELEVA, clickItem.getEleva());
        detailIntent.putExtra(EXTRA_RENT, clickItem.getRent());
        detailIntent.putExtra(EXTRA_DESPOSIT, clickItem.getDespoit());
        detailIntent.putExtra(EXTRA_SHORTRENT, clickItem.getShortrent());
        detailIntent.putExtra(EXTRA_YEAR, clickItem.getYear());
        detailIntent.putExtra(EXTRA_MONTH, clickItem.getMonth());
        detailIntent.putExtra(EXTRA_DAY, clickItem.getDay());
        detailIntent.putExtra(EXTRA_GENDER, clickItem.getGender());
        detailIntent.putExtra(EXTRA_FIRE, clickItem.getFire());
        detailIntent.putExtra(EXTRA_PET, clickItem.getPet());
        detailIntent.putExtra(EXTRA_STORE, clickItem.getStore());
        detailIntent.putExtra(EXTRA_DSTORE, clickItem.getDstore());
        detailIntent.putExtra(EXTRA_PARK, clickItem.getPark());
        detailIntent.putExtra(EXTRA_SCHOOL, clickItem.getSchool());
        detailIntent.putExtra(EXTRA_NIGHT, clickItem.getNight());
        detailIntent.putExtra(EXTRA_HOSPITAL, clickItem.getHospital());
        detailIntent.putExtra(EXTRA_MRT, clickItem.getMRT());
        detailIntent.putExtra(EXTRA_TRAIN, clickItem.getTrain());
        detailIntent.putExtra(EXTRA_CONTACT, clickItem.getContact());
        detailIntent.putExtra(EXTRA_PHONE, clickItem.getPhone());
        detailIntent.putExtra(EXTRA_CONTACT_AM, clickItem.getContact_am());
        detailIntent.putExtra(EXTRA_CONTACT_PM, clickItem.getContact_pm());
        detailIntent.putExtra(EXTRA_EMAIL, clickItem.getEmail());
        detailIntent.putExtra(EXTRA_IMAGE, clickItem.getImage());
        detailIntent.putExtra(EXTRA_NAME, clickItem.getName());


        startActivity(detailIntent);
    }
}
