package com.example.tablayout_page;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    //    페이저를 넘길 때 getItem이 호출됨
    //    디버깅 - 메모리에 올릴 때 하나만 정해서 올릴 수 있는데, 자연스럼게 올리려면 메모리에 미리 올라와있어야 자연스럽기 때문에
    //    1과2 같이 생성함 2번으로 넘기면 3번 프래그먼트를 생성.
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
