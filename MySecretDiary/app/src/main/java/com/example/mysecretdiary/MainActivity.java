package com.example.mysecretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPk1;
    private NumberPicker numberPk2;
    private NumberPicker numberPk3;

    private Button openBtn;
    private Button modifyBtn;
    SharedPreferences passwordPreference;

    // 프로그램 흐름상, 두가지 모드가 있음
    // frag 변수
    private boolean changePasswordMode = false;
    private final static String KEY_PWD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPk1 = findViewById(R.id.numberPk1);
        numberPk2 = findViewById(R.id.numberPk2);
        numberPk3 = findViewById(R.id.numberPk3);
        numberPk1.setMaxValue(9);
        numberPk1.setMinValue(0);
        numberPk2.setMaxValue(9);
        numberPk2.setMinValue(0);
        numberPk3.setMaxValue(9);
        numberPk3.setMinValue(0);
        openBtn = findViewById(R.id.openBtn);
        modifyBtn = findViewById(R.id.modifyBtn);

        passwordPreference = getSharedPreferences(KEY_PWD, Context.MODE_PRIVATE);

    }

    private void addEventListener() {
        // 비밀 다이어리 오픈버튼 눌렀을 때 동작 처리
        openBtn.setOnClickListener(view -> {
            if (changePasswordMode) {
                // 작은 버튼 눌러서 색상 변경되었을 때 진행시키면 안됨.
                Toast.makeText(this, "비밀번호 변경 중입니다.", Toast.LENGTH_SHORT).show();
                return; // 실행의 흐름 막기
            }

            // 저장되어있는 비밀번호 데이터를 불러와서 확인해야 함.
            // 비밀번호 저장하는 방식 - 로컬 DB (SQL Lite) or SharedPreference
            // DB나 SharedPreference 는 영속성을 가지기 때문에 앱을 껐을 때도 이 데이터는 영구적으로 남아있음.
//            passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE);
            // 사용자가 입력한 번호 문자열로 담김
            String passwordFromUser = getUserNumber();
            // 비밀번호를 세팅하지 않았을 경우, 초기값 세팅으로 처리
            // 000 <--> 000 : OK
            // 333 <---> 333 : OK
            // 333 <---> 123 : X
            if (passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)) {
                // 패스워드 확인 성공
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            } else {
                // 사용자에게 비밀번호 틀렸다고 알려줌.
                showErrorAlertDialog();
            }

        });

        // 비밀번호 변경버튼 눌렀을 때 동작 처리
        modifyBtn.setOnClickListener(view -> {
//            passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE);
            String passwordFromUser = getUserNumber();
            // 비밀번호를 변경 중인 경우, 처음 변경하겠다고 누르는 경우
            if (changePasswordMode) {
                SharedPreferences.Editor editor = passwordPreference.edit();
                editor.putString(KEY_PWD, getUserNumber());
                editor.apply();
                changePasswordMode = false;
                modifyBtn.setBackgroundColor(Color.WHITE);
                // 비밀번호 변경하는 경우 --> 저장처리
            } else {
                // 비밀번호 변경 모드 활성화 시키기
                // 단, 현재 넘버피커 숫자가 내가 정한 비밀번호와 일치해야 변경모드로 만들어줘야 한다.
                if (passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)) {
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 알려주세요", Toast.LENGTH_SHORT).show();
                    modifyBtn.setBackgroundColor(Color.RED);
                } else {
                    showErrorAlertDialog();
                }
            }
        });

    }

    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다.")
                .setPositiveButton("닫기", (dialog, which) -> {
                    // 동작 정의 하지 않을 것임.
                    Log.d("TAG", "1111");
                });
        builder.show();
    }

    private String getUserNumber() {
        String passwordFromUser = ""
                + numberPk1.getValue()
                + numberPk2.getValue()
                + numberPk3.getValue();
        return passwordFromUser;
    }

}