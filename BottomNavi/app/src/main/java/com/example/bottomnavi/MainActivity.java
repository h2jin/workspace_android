package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavi.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    FragmentHome fragmentHome;
    FragmentChat fragmentChat;
    FragmentGPS fragmentGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        addBottomNavigationListener();

        replaceFragment(FragmentType.HOEM);


    }

// 타입에 따라서 분리할 수 있다. -> 이넘 사용
    private void replaceFragment(FragmentType type) {
        // 플래그먼트 3개 생성
        Fragment fragment;
        //플래그먼트 매니저
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if(type == FragmentType.HOEM) {
            fragment = new FragmentHome();
        } else if (type == FragmentType.CHAT ) {
            fragment = new FragmentChat();
        } else {
            fragment = new FragmentGPS();
        }

        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
        // 플래그먼트 트랜젝션

    }

    private void addBottomNavigationListener() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.HOEM);
                    break;
                case R.id.page_chat:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.CHAT);
                    break;
                case R.id.page_gps:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.GPS);
                    break;
            }
            return true;
        });
    }


}