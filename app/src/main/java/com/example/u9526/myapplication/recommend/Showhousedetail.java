package com.example.u9526.myapplication.recommend;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.u9526.myapplication.R;

import org.w3c.dom.Text;

import com.bumptech.glide.Glide;


import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_ADDRESS;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_BALCONY;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_BED;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CAR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHAIR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKAIR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKFOUR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKGAS;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKHOT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKNET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKREFRIG;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKTV;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CHECKWASH;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CITY;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CLOSET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CONTACT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CONTACT_AM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CONTACT_PM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_DAY;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_DESPOSIT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_DSTORE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_ELEVA;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_EMAIL;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_FIRE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_GENDER;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_HOSPITAL;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_HOUSETYPE;

import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_IMAGE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_LIVINGROOM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_MONTH;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_MRT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_NAME;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_NIGHT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PARK;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PHONE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PING;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_REGION;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_RENT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_ROOM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_ROOMTYPE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_SCHOOL;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_SHORTRENT;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_SOFA;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_STORE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TABLE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TITLE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TOILET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TRAIN;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_YEAR;

public class Showhousedetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhousedetail);

        //compare main_recommend
        Intent intent = getIntent();
        String image = intent.getStringExtra(EXTRA_IMAGE);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String roomtype = intent.getStringExtra(EXTRA_ROOMTYPE);
        String housetype = intent.getStringExtra(EXTRA_HOUSETYPE);
        String city = intent.getStringExtra(EXTRA_CITY);
        String region = intent.getStringExtra(EXTRA_REGION);
        String address = intent.getStringExtra(EXTRA_ADDRESS);
        String livingroom = intent.getStringExtra(EXTRA_LIVINGROOM);
        String room = intent.getStringExtra(EXTRA_ROOM);
        String toilet = intent.getStringExtra(EXTRA_TOILET);
        String balcony = intent.getStringExtra(EXTRA_BALCONY);
        String ping = intent.getStringExtra(EXTRA_PING);
        String checkrefrig = intent.getStringExtra(EXTRA_CHECKREFRIG);
        String checkrewash = intent.getStringExtra(EXTRA_CHECKWASH);
        String checktv = intent.getStringExtra(EXTRA_CHECKTV);
        String checkair = intent.getStringExtra(EXTRA_CHECKAIR);
        String checkhot = intent.getStringExtra(EXTRA_CHECKHOT);
        String checknet = intent.getStringExtra(EXTRA_CHECKNET);
        String checkfour = intent.getStringExtra(EXTRA_CHECKFOUR);
        String checkgas = intent.getStringExtra(EXTRA_CHECKGAS);
        String bed = intent.getStringExtra(EXTRA_BED);
        String closet = intent.getStringExtra(EXTRA_CLOSET);
        String sofa = intent.getStringExtra(EXTRA_SOFA);
        String table = intent.getStringExtra(EXTRA_TABLE);
        String chair = intent.getStringExtra(EXTRA_CHAIR);
        String car = intent.getStringExtra(EXTRA_CAR);
        String eleva = intent.getStringExtra(EXTRA_ELEVA);
        String rent = intent.getStringExtra(EXTRA_RENT);
        String desposit = intent.getStringExtra(EXTRA_DESPOSIT);
        String shortrent = intent.getStringExtra(EXTRA_SHORTRENT);
        String year = intent.getStringExtra(EXTRA_YEAR);
        String month = intent.getStringExtra(EXTRA_MONTH);
        String day = intent.getStringExtra(EXTRA_DAY);
        String gender = intent.getStringExtra(EXTRA_GENDER);
        String fire = intent.getStringExtra(EXTRA_FIRE);
        String pet = intent.getStringExtra(EXTRA_PET);
        String store = intent.getStringExtra(EXTRA_STORE);
        String dstore = intent.getStringExtra(EXTRA_DSTORE);
        String park = intent.getStringExtra(EXTRA_PARK);
        String school = intent.getStringExtra(EXTRA_SCHOOL);
        String night = intent.getStringExtra(EXTRA_NIGHT);
        String hospital = intent.getStringExtra(EXTRA_HOSPITAL);
        String MRT = intent.getStringExtra(EXTRA_MRT);
        String train = intent.getStringExtra(EXTRA_TRAIN);
        String contact = intent.getStringExtra(EXTRA_CONTACT);
        String phone = intent.getStringExtra(EXTRA_PHONE);
        String contact_am = intent.getStringExtra(EXTRA_CONTACT_AM);
        String contact_pm = intent.getStringExtra(EXTRA_CONTACT_PM);
        String email = intent.getStringExtra(EXTRA_EMAIL);
        String name = intent.getStringExtra(EXTRA_NAME);

        //compare text
        ImageView imageView = findViewById(R.id.image);
        TextView textViewCity = findViewById(R.id.city);
        TextView textViewAddress = findViewById(R.id.address);
        TextView textViewRegion = findViewById(R.id.region);
        TextView textViewTitle = findViewById(R.id.title);
        TextView textViewRentprice = findViewById(R.id.price);
        TextView textViewHousetype = findViewById(R.id.textViewRoomtype);
        TextView textViewPing = findViewById(R.id.ping);
        TextView textViewCar = findViewById(R.id.car);
        TextView textViewGender = findViewById(R.id.boygirl);
        TextView textViewFire = findViewById(R.id.fire);
        TextView textViewPet = findViewById(R.id.pet);
        TextView textViewContact = findViewById(R.id.name);
        TextView textViewPhone = findViewById(R.id.phone);
        TextView textViewLivingroom = findViewById(R.id.livingroomdata);
        TextView textViewRoom = findViewById(R.id.roomdata);
        TextView textViewToilet = findViewById(R.id.toiletdata);
        TextView textViewBalcony = findViewById(R.id.balconydata);

        //get data
        Glide.with(this)
                .load(image)
                .into(imageView);
        textViewCity.setText(city);
        textViewAddress.setText(address);
        textViewRegion.setText(region);
        textViewTitle.setText(title);
        textViewPing.setText(ping);
        textViewCar.setText(car);
        textViewRentprice.setText(rent);
        textViewHousetype.setText(housetype);
        textViewGender.setText(gender);
        textViewFire.setText(fire);
        textViewPet.setText(pet);
        textViewContact.setText(email);//name
        textViewPhone.setText(phone);
        textViewLivingroom.setText(livingroom);
        textViewRoom.setText(room);
        textViewToilet.setText(toilet);
        textViewBalcony.setText(balcony);
    }
}
