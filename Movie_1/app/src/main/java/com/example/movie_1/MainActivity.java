package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity {
    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. 객체 초기화. 
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. 연결
        setContentView(binding.getRoot());
        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();


    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.newInstance(); // MOVIE TAG


        } else {
            fragment = InfoFragment.newInstance(); // INFO TAG
        }
        // 문자열로 이름 지어서 구분해 놓는 녀석 -> TAG
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.page1:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.page2:
                    replaceFragment(FragmentType.INFO);
                    break;

            }
            return true;
        });

    }

    @Override
    public void onBackPressed() {
        // info Fragment라면 한 번은 movie Fragment로 갔다가 처리하기
        // movie Fragment면 원래대로 종료
        // main container에 올라와있는 녀석이 현재 movie fragment인지 info fragment인지 구분할 수 있다면
        // 아래의 기능 완성할 수 있음.
        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();
        if (fragmentTag.equals(FragmentType.INFO.toString())) {
            replaceFragment(FragmentType.MOVIE);
        } else {
            super.onBackPressed();
        }

    }
}