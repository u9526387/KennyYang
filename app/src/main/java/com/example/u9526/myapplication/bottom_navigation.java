package com.example.u9526.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.u9526.myapplication.Fragment.Rent_collectionFragment;
import com.example.u9526.myapplication.Rent.Rent_homepageFragment;
import com.example.u9526.myapplication.Fragment.Rent_messageFragment;
import com.example.u9526.myapplication.Fragment.Rent_personalDataFragment;

public class bottom_navigation extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private BottomNavigationMenuView menuView;
    private ActionBar toolbar;
    private View item;//每一個fragment 都需要宣告一個view來 顯示layout內容
    private SharedPreferences user_data;//SharedPreferences所存入的資料檔
    private int fragment_status;
    private TextView U_Username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        toolbar = getSupportActionBar();//上方tittle bar 工具列

        //--------------------------------------------------------------------------------------------------下方按鈕bottomNavigationView
        toolbar.setTitle(R.string.title_personaldata);//第一頁 title 設定為首頁
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        U_Username=findViewById(R.id.profile_user_name);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        toolbar.setTitle(R.string.title_home);
                        fragment = Rent_homepageFragment.newInstance();
                        break;

                    case R.id.navigation_collection:
                        toolbar.setTitle(R.string.title_collection);
                        fragment = Rent_collectionFragment.newInstance();
                        break;
                    case R.id.navigation_message:
                        toolbar.setTitle(R.string.title_message);
                        fragment = Rent_messageFragment.newInstance();
                        break;
                    case R.id.navigation_personaldata:
                        toolbar.setTitle(R.string.title_personaldata);
                        fragment = Rent_personalDataFragment.newInstance();
                        break;

                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_rent, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });

        if (fragment_status == 1) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        } else if (fragment_status == 2) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_collection);
        } else if (fragment_status == 3) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_message);
        } else if (fragment_status == 4) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_personaldata);

        } else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        }



    }


}
