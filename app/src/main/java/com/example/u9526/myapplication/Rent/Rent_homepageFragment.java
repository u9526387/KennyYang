package com.example.u9526.myapplication.Rent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.u9526.myapplication.HouseInfo.FillRentInfo1;
import com.example.u9526.myapplication.R;
import com.example.u9526.myapplication.recommend.main_recommend;

public class Rent_homepageFragment extends Fragment {

    private View v;//每一個fragment 都需要宣告一個view來 顯示layout內容
    private ImageButton Rent;
    private ImageButton Search;

    public Rent_homepageFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        Rent_homepageFragment fragment = new Rent_homepageFragment();

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_rent_homepage, container, false);
//-------------------------------------------------------------------------------讀取代入判斷的資料
        Rent = (ImageButton) v.findViewById(R.id.Rent);
        Search = (ImageButton) v.findViewById(R.id.Search);
        Rent_click();
        Search_click();


        return v;

    }

    private void Rent_click() {
        Rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rent = new Intent(getActivity(), FillRentInfo1.class);
                startActivity(rent);
                getActivity();
            }
        });


    }

    private void Search_click() {
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(getActivity(), main_recommend.class);
                startActivity(search);
                getActivity();
            }
        });


    }


}
