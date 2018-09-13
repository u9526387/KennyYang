package com.example.u9526.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.u9526.myapplication.R;

public class Rent_personalDataFragment extends Fragment {

    private View v;//每一個fragment 都需要宣告一個view來 顯示layout內容


    public Rent_personalDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_rent_personal_data, container, false);
//-------------------------------------------------------------------------------讀取代入判斷的資料
        return v;

    }


    public static Fragment newInstance() {
        Rent_personalDataFragment fragment = new Rent_personalDataFragment();

        return fragment;


    }
}
