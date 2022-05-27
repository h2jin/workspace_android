package com.example.tablayout_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    /*
    pager
    - 화면 (종이 넘기듯이 화면을 넘겨주는 역할)
    - Adapter

    TabLayout
    - tab을 담당하는 역할
    - 보통 같이 작성을 하지만 따로 따로 만들어도 상관이 없다.

    두개를 만들면 연결해야함.
    리스너
    - pager와 TabLayout 을 연결해주기 위해 필요하다.

     */

    private static final String TAG = MainActivity.class.getName();
    static final int TAB_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // addTab(Tab을 넣어야 하는데, tabLayout안의 newTab으로 탭 생성 후, 텍스트 설정)
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREE"));

        // 1번 탭에서 2번 탭으로 진행 했을 때 1번 탭이 사라질 때 뭔가 해야할 일이 있다면,
        // onUnselected에서 코드 작성, 새로운 탭이 선택되었을 때 onTabSelected에서 코드 작성
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); //몇번째 탭이 눌러졌는지 알 수 있음.

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            // 눌러져있는 상태에서 다시 누르면 호출
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }
        });

        ViewPager viewPager = findViewById(R.id.viewPager);
        // 어뎁터 생성
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), TAB_COUNT);
        // 어텝터 셋팅
        viewPager.setAdapter(myPagerAdapter);

    }
}

class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentOne();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }
}