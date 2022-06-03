package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.interfaces.OnPassWebView;
import com.example.movie_1.utils.Define;
import com.example.movie_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnChangeToolbarType, OnPassWebView {
    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    ActivityMainBinding binding;
    WebView webView; // InfoFragment에서 생성하는 webview 객체 주소를 전달 받을 예정


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
            fragment = MovieFragment.getInstance(this); // MOVIE TAG


        } else {
            fragment = InfoFragment.getInstance(this); // INFO TAG
//            InfoFragment infoFragment = InfoFragment.newInstance();
//            infoFragment.setOnChangeToolbarType(this);
//            InfoFragment.newInstance().setOnChangeToolbarType(this);
            if(fragment != null) {
                InfoFragment infoFragment = (InfoFragment) fragment;
                infoFragment.setOnPassWebView(this); // 주소 연결
            }
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
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                // replace 대신에 버튼클릭을 활성화 시켜서 구현할 수 있음.
                View view = binding.bottomNavigation.findViewById(R.id.page1);
                view.callOnClick();
            }
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onSetupType(String title) {
        // 플래그먼트에서 호출하면 (onSetupType) 여기로 돌아온다.
        if (title.equals(Define.PAGE_TITLE_MOVIE)) {
            binding.topAppbar.setTitle(title);
            binding.topAppbar.setVisibility(View.VISIBLE);
        } else if (title.equals(Define.PAGE_TITLE_INFO)) {
            binding.topAppbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPassWebViewObj(WebView webView) {
        this.webView = webView;
    }
}