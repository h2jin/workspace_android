package com.example.movie_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movie_2.databinding.ActivityMainBinding;
import com.example.movie_2.utils.FragmentType;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();
    }

    // Fragment 교체시켜줄 메서드 생성
    public void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.newInstance();
        } else {
            fragment = InfoFragment.newInstance();
        }
        transaction.replace(binding.mainContainer.getId(), fragment); //type.toString 없이 해봄
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavi.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.moviePage:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.infoPage:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }

}