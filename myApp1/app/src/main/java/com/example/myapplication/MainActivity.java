package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "TAG";
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView ca;
    private TextView plus;
    private TextView result;

    String oldValue = "0";
    String newValue = "";


//    멤버변수에 기본데이터 값이 들어가거나
//    래퍼런스 변수--> 주소값이 들어감

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator2);
        initData();
        addEventListener();
    }

    //   메서드 -> stack 메모리에 올라갔다가 사라짐
    private void initData() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one); // 주소값을 담는 의미
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);
        // 탬플릿 메서드 패턴 -> 실행의 흐름이 정해져 있고, final이기 때문에 재정의 되지 않는다.
        // r -> resource의 약자
        System.out.println("initData 메서드 호출");
    }
//    button 입력시 오류나는 이유 -> 메모리에 올라가있지 않기 때문이다..

//    변수의 활용!

    private void addEventListener() {
        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(newValue);
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "1";
                result.setText(newValue);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "2";
                result.setText(newValue);
            }
        });

//        람다 표현식

        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(newValue);
        });

        four.setOnClickListener(View -> {
            newValue = newValue + "4";
            result.setText(newValue);
        });

        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(newValue);
        });

        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(newValue);
        });

        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(newValue);
        });

        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(newValue);
        });

        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(newValue);
        });


        ca.setOnClickListener(view -> {
            oldValue = "0";
            newValue = "0";
            result.setText("0");
        });

        plus.setOnClickListener(view -> {
            // 1. newvalue = 1
            int number1 = Integer.parseInt(oldValue);
            int number2 = Integer.parseInt(newValue);
            int sum = (number1 + number2);
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);

        });



    }
}