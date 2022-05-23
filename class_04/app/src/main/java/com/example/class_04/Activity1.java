package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "TAG";
    public static final String KEY_NAME = "key name";

    private EditText nameEditText;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initData();
        addEventListener();
    }

    private void initData() {
        nameEditText = findViewById(R.id.nameEditText);
        okBtn = findViewById(R.id.okBtn);
    }

    private void addEventListener() {
        okBtn.setOnClickListener(view -> {
//            1. 현재 nameEditText 뷰 컴포넌트에 값을 가져온다. (방어적 코드)
//            2. 화면 전환 로직 (인텐트)
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra(KEY_NAME, name);
            startActivity(intent);
        });
    }


    //        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
//
//        // start가 아닌 여기서 해도 됨
//        btn1.setOnClickListener(view -> {
//            Intent intent = new Intent(this, Activity2.class);
//            intent.putExtra("number", 300);
//            intent.putExtra("myString", "안녕");
//            // 문제 String 값 3개를 만들어서 보내기
//            intent.putExtra("name", "홍길동");
//            intent.putExtra("phone", "010-1234-1234");
//            intent.putExtra("address", "부산시 진구");
//
//            startActivity(intent); // 의사 전달(새로운 액티비티를 열 것이다)
//        });
//
//        btn2.setOnClickListener(view -> {
////            지역변수기 때문에 변수명 같아도 상관없음
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
//            startActivity(intent);
//        });
}