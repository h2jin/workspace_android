package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

//        SharedPreference
//        생성 방법
        SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
//        Mode
//        - MODE_PRIVATE : 생성한 어플리케이션에서만 사용가능
//        - MODE_WORLD_READABLE : 다른앱에서 사용가능하지만 읽을수만 있다.
//        - MODE_WORLD_WRITEABLE : 다른 앱에서 사용 가능 기록도 가능하다.

//        데이터를 입력해보기
//        데이터를 넣기 위해 수정모드 먼저 만들어야 한다.
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("name", "홍길동");
//        이까지는 저장 안됨.
        editor.apply(); // <--저장됨.
//        editor.apply(); 

//        apply 와 commit 의 차이점
//        apply() --> 스레드를 블록 시키지 않는다. 비동기 방식. 저장의 성공 여부 true, false 값을 주지 않음.
//        commit() --> 스레드가 블록된다. 동기 방식. commit은 저장을 성공하면 boolean 타입인 true 값을 반환한다.
//        때에 따라 다르지만, commit은 스레드가 다른 일을 하는 경우, 알 수 없는 오류가 발생할 수 있기 때문에 apply 사용
    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }

    private void addEventListener() {
        btnSave.setOnClickListener(view -> {
//            name, age, isMarried 데이터를 저장하는 기능을 만들어보기
//            1. sharedPreference 객체를 불러 온다. (이름, 모드 설정)
//            2. 수정모드로 만들기
//            3. 저장할 데이터를 입력한다.
//            4. 비동기 방식으로 데이터를 완전히 저장한다.
//            name(String), age(int), isMarried(boolean) 데이터를 저장하는 기능 만들기.
            SharedPreferences sp2 = getSharedPreferences("sp1", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp2.edit();
            editor.putString("name", "이순신");
            editor.putInt("age", 30);
            editor.putBoolean("isMarried", true);
            editor.apply();

        });

        btnLoad.setOnClickListener(view -> {
//            stack 메모리에 올림 (올라왔다가 사라지도록)
//            SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE);
//            데이터를 읽어 보기
//            String name = preferences.getString("name", "");


//            SharedPreferences preferences1 = getSharedPreferences("sp1", MODE_PRIVATE);
            String name = getShared("sp1").getString("name", "");
            int age = getShared("sp1").getInt("age", 0);
            boolean isMarried = getShared("sp1").getBoolean("isMarried", false);

            Log.d("TAG", "name 값 확인 : " + name);
            Log.d("TAG", "age 값 확인 : " + age);
            Log.d("TAG", "isMarried 값 확인 : " + isMarried);

        });

        btnDelete.setOnClickListener(view -> {
//            메서드 체이닝 방식으로 코드 작성해보기
//            age 값만 삭제
            getShared("sp1").edit().remove("age").apply();
//            잘 삭제가 되었는지 확인하기
//            코드 상으로 버튼을 눌렀다 명령하기
            btnLoad.callOnClick();


        });

        btnDeleteAll.setOnClickListener(view -> {
            getShared("sp1").edit().clear().apply();
//            코드상으로 버튼 누르기
            btnLoad.callOnClick();
        });
    }

    // 메서드로 만들어주기
    private SharedPreferences getShared(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }

}