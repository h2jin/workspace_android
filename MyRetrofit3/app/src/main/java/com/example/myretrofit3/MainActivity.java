package com.example.myretrofit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myretrofit3.models.reponse.ResponsePostDto;
import com.example.myretrofit3.models.request.ReqPostDto;
import com.example.myretrofit3.service.JPHService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

// 버튼에 이번트 리스너 처리하여 누르면 인터넷과 통신 처리

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private JPHService service;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();
    }

    private void initData() {
        // 서비스를 초기화
        service = JPHService.retrofit.create(JPHService.class);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }

    private void addEventListener() {
        btn1.setOnClickListener(view -> {
            // get 방식
            service.post(2).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if (response.isSuccessful()) {
                        // 자동 파싱 json --> Object로 변환 처리
                        ResponsePostDto dto = response.body();
                        Log.d(TAG, dto + "");
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });
        btn2.setOnClickListener(view -> {
            service.postList().enqueue(new Callback<List<ResponsePostDto>>() {
                @Override
                public void onResponse(Call<List<ResponsePostDto>> call, Response<List<ResponsePostDto>> response) {
                    Log.d(TAG, response.code() + "<--- code ");
                    ArrayList<ResponsePostDto> list = (ArrayList<ResponsePostDto>) response.body();
                    Log.d(TAG, list.toString());

                }

                @Override
                public void onFailure(Call<List<ResponsePostDto>> call, Throwable t) {

                }
            });
        });
        btn3.setOnClickListener(view -> {
            // 보통 userId는 회원이 로그인했을 때 값을 받아 놓고, shared Preference(or SQL Lite)에 저장하거나 꺼내서 쓴다.
            // 메모리에 저장하고 싶다면 메모리 변수에 저장할 수도 있음.
            ReqPostDto reqPostDto = new ReqPostDto("회의", "DB설계", 10);
            service.createPost(reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, response.body().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    Log.d(TAG, t.toString());
                }
            });

        });
        btn4.setOnClickListener(view -> {
            Log.d("TAG", "btn4 click");
            ReqPostDto reqPostDto = new ReqPostDto("제목 수정 성공", "DB 설계 수정", 10);
            // TODO

            service.updatePost(100, reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()) {
                        Log.d(TAG, response.body().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "수정 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });

        });

        btn5.setOnClickListener(view -> {
            Log.d("TAG", "btn5 click");
            service.deletePost(100).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        });
        btn6.setOnClickListener(view -> {
            Log.d("TAG", "btn6 click");
//            service.searchByUserId()
        });
    }

}