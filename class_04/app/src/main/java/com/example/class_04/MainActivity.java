package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    
    // 액티비티 생명 주기 알아보기

    private static final String LIFE_CICLE = "life_cicle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 상속 객체의 onCreate 메서드 호출
        super.onCreate(savedInstanceState);
        // 화면을 이 xml 파일로 그려준다.(activity)
        // 처음에 화면을 그리는 것은 단 한번만 그려준다.
        setContentView(R.layout.activity_main);

        Log.d(LIFE_CICLE,"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LIFE_CICLE, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LIFE_CICLE, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LIFE_CICLE, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LIFE_CICLE, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LIFE_CICLE, "onDestroy");
    }
}