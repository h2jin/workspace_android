package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);



//        프래그 먼트를 생성하는 두가지 방법
//        fragmentBanner = new FragmentBanner();
//        fragmentBanner = FragmentBanner.newInstance("", ""); 

        btnCreate.setOnClickListener(view -> {
            fragmentBanner = new FragmentBanner();

            // 프래그먼트를 동적으로 만들기 위한 준비물
            // 1. fragmentManager (프래그먼트 트랜젝션 객체를 가져올 수 있다.)
            // 2. FragmentTransaction - transaction -> 작업의 단위(시작과 끝이 있다.)
            // 여러개 부분 부분 작업들을 한 단위로 만들어 준다.

            FragmentManager manager = getSupportFragmentManager();
//            FragmentManager manager1 = new FragmentManager();
//            FragmentManager manager2 = new FragmentManager();
//            이렇게 하는 경우 래퍼런스 변수 다 달라짐. 그러나 프래그먼트는 여러 곳에서 사용하는데
//            래퍼런스 변수가 다 다를 경우 사용하기가 불편하다. 그래서 new 하지 않고, 같은 클래스라는 것을 알려주는 것.

            FragmentTransaction transaction = manager.beginTransaction();
//             지금부터 트랜젝션 처리를 할 것이다.

//            실행 코드 -> zml 파일에 만들어 둔 영역(view Component)에 올려라
            transaction.replace(R.id.container, fragmentBanner);


            transaction.commit(); // 시스템이 시간이 될 때 완료하라 (권장사항)
            // transaction.commitNow(); // 시스템에게 지금 당장하라
            // transaction.commitAllowingStateLoss(); // 위험 (커밋이 없어질 수 있다.) 쓰면 안됨.

        });


//        프래그먼트 제거방법
        btnDelete.setOnClickListener(view -> {

            // remove 메서드 쓰면 됨.
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.remove(fragmentBanner);
//            transaction.detach(fragmentBanner);
            transaction.commit();


        });

    }
}