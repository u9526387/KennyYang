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
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_CAR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_FLOOR;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_GENDER;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_HOUSENUMBER;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_IMAGE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_LIVINGROOM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_NONG;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PING;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PRICE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_ROOM;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TITLE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TOILET;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_VALLEY;

public class Showhousedetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhousedetail);

        //compare main_recommend
        Intent intent = getIntent();
        String image = intent.getStringExtra(EXTRA_IMAGE);
        String title = intent.getStringExtra(EXTRA_TITLE);
        int price = intent.getIntExtra(EXTRA_PRICE,0);
        String address = intent.getStringExtra(EXTRA_ADDRESS);
        String car = intent.getStringExtra(EXTRA_CAR);
        String gender = intent.getStringExtra(EXTRA_GENDER);
        String pet = intent.getStringExtra(EXTRA_PET);
        String valley =intent.getStringExtra(EXTRA_VALLEY);
        String nong = intent.getStringExtra(EXTRA_NONG);
        String housenumber = intent.getStringExtra(EXTRA_HOUSENUMBER);
        String floor = intent.getStringExtra(EXTRA_FLOOR);
        String livingroom = intent.getStringExtra(EXTRA_LIVINGROOM);
        String room = intent.getStringExtra(EXTRA_ROOM);
        String toilet = intent.getStringExtra(EXTRA_TOILET);
        String balcony = intent.getStringExtra(EXTRA_BALCONY);
        String ping = intent.getStringExtra(EXTRA_PING);

        //compare text
        ImageView imageView = findViewById(R.id.image);
        TextView textViewTitle = findViewById(R.id.title);
        TextView textViewPrice = findViewById(R.id.price);
        TextView textViewAddess = findViewById(R.id.address);
        TextView textViewCar = findViewById(R.id.car);
        TextView textViewGender = findViewById(R.id.boygirl);
        TextView textViewPet = findViewById(R.id.pet);
        TextView textViewValley = findViewById(R.id.valley);
        TextView textViewNong = findViewById(R.id.nong);
        TextView textViewHousenumber = findViewById(R.id.number);
        TextView textViewFloor = findViewById(R.id.floor);
        TextView textViewLivingroom = findViewById(R.id.livingroomdata);
        TextView textViewRoom = findViewById(R.id.roomdata);
        TextView textViewToilet = findViewById(R.id.toiletdata);
        TextView textViewBalcony = findViewById(R.id.balconydata);
        TextView textViewPing = findViewById(R.id.plain);

        //get data
        Glide.with(this)
                .load(image)
                .into(imageView);
        textViewTitle.setText(title);
        textViewPrice.setText(""+price);
        textViewAddess.setText(address);
        textViewCar.setText(car);
        textViewGender.setText(gender);
        textViewPet.setText(pet);
        textViewValley.setText(valley);
        textViewNong.setText(nong);
        textViewHousenumber.setText(housenumber);
        textViewFloor.setText(floor);
        textViewLivingroom.setText(livingroom);
        textViewRoom.setText(room);
        textViewToilet.setText(toilet);
        textViewBalcony.setText(balcony);
        textViewPing.setText(ping);
    }
}
