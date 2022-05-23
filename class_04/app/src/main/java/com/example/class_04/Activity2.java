package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // 값을 받는 방법
//        값이 없다면 기본값을 0으로 세팅
        // 방어적 코드
        view1 = findViewById(R.id.nameTextView);
        if (getIntent() != null) {
            String getData = getIntent().getStringExtra(Activity1.KEY_NAME);
            view1.setText(getData);

        }

        // 값을 전달받아서 화면에 뿌려주기
//            int numberTemp = getIntent().getIntExtra("number", 0);
//        String은 디폴트값 없음. 자동으로 초기화.
//            String nameTemp = getIntent().getStringExtra("name");
//            String phoneTemp = getIntent().getStringExtra("phone");
//            String addressTemp = getIntent().getStringExtra("address");
//            view1.setText(numberTemp + "\n" + myStringTemp + "\n"
//                    + nameTemp + "\n" + phoneTemp + "\n" + addressTemp);



    }
}