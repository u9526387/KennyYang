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
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_IMAGE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_PRICE;
import static com.example.u9526.myapplication.recommend.main_recommend.EXTRA_TITLE;

public class Showhousedetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhousedetail);

        Intent intent = getIntent();
        String image = intent.getStringExtra(EXTRA_IMAGE);
        String title = intent.getStringExtra(EXTRA_TITLE);
        int price = intent.getIntExtra(EXTRA_PRICE,0);
        String address = intent.getStringExtra(EXTRA_ADDRESS);

        ImageView imageView = findViewById(R.id.image);
        TextView textViewTitle = findViewById(R.id.title);
        TextView textViewPrice = findViewById(R.id.price);
        TextView textViewAddess = findViewById(R.id.address);

        Glide.with(this)
                .load(image)
                .into(imageView);
        textViewTitle.setText(title);
        textViewPrice.setText(""+price);
        textViewAddess.setText(address);
    }
}
