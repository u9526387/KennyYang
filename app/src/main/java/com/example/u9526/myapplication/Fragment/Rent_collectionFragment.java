package com.example.u9526.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.u9526.myapplication.R;


public class Rent_collectionFragment extends Fragment {

    private View v;//每一個fragment 都需要宣告一個view來 顯示layout內容


    public Rent_collectionFragment() {
        // Required empty public constructor
    }

    public static Rent_collectionFragment newInstance() {
        Rent_collectionFragment fragment = new Rent_collectionFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_rent_collection, container, false);
//-------------------------------------------------------------------------------讀取代入判斷的資料
        return v;

    }


}
