package com.example.mysecretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    // 핸들러와 루퍼
    Handler handler = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        // 사용자가 이전에 적었던 비밀 일기장 불러와야 한다.
        SharedPreferences notePreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreferences.getString("detail", ""));

        // Thread 기능 구현 (새로운 스레드 생성)
        // 새로운 스레드의 작업 영역
        Runnable runnable = () -> {
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };


        // 사용자가 한글자 한글자 입력할 때 마다 이벤트 리스너를 등록해서 변경사항을 가지고 오기
        // 이벤트 핸들러 처리
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG", "char : " + s);
                Log.d("TAG", "start : " + start);
                Log.d("TAG", "count : " + count);
                Log.d("TAG", "after : " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 한글자 한글자 입력이 들어올 때 마다 sharedPreferences에 저장할 예정
                // 메모리를 많이 잡아먹음. 나중에 터질 가능성 있음.
                // --> 새로운 스레드 만들어서 비동기 저장하기.
                // 여기에서 다른 스레드한테 일 해달라고 요청함
                // a : 0.5초 딜레이
                // ab : 0.5초 딜레이 --> 삭제
                // abc : 0.5초 딜레이 --> 삭제
                // 마지막에 abcd : 0.5초 딜레이 --> 마지막에 abcd 들어오기 때문에 이때 모두 저장해줌 --> removeCallback
                handler.removeCallbacks(runnable);
//                handler.post(runnable);
                handler.postDelayed(runnable, 500); // 한글자 쓰고 0.5초 기다렸다가 보냄
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

}