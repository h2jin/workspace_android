package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit.repository.models.RetrofitService;
import com.example.myretrofit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 모델 분리
// 비즈니스 로직을 처리하는 부분을 분리
public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.temp);

        // retrofit 객체 초기화 해야 함.
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        new Retrofit.Builder() -> 빌더패턴으로 만들어져 있음. 순서 상관 없이 필요한 매개변수만 가지고와서 객체를 생성할 수 있는 패턴
//        baseUrl -> url 객체 만들어주는 것. !! 반드시 마지막에 / 있어야 함 !!
//        addConverterFactory -> gson 변경을 한번에 해주는 코드
//        build() -> 마지막에 호출해야 레트로핏을 리턴해줌.

//        초기화 된 레트로핏 Object와 비즈니스 로직인 interface를 연결

        service = retrofit.create(RetrofitService.class);
//        익명구현객체로 변경됨, 비동기로
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG", response.isSuccessful() + "< --");
                Log.d("TAG", response.message() + "< --");
                if (response.isSuccessful()) {

                    // Gson 타입변환코드 안하고있음.
                    Todo todo = response.body().get(0);
                    Log.d("TAG", "userId" + todo.userId);

                    textView.setText(todo.completed + "");

                }

            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Log.d("TAG", "실패" + t.getMessage());
            }
        });

//        비즈니스 로직 만들어야 함.
//        todo 데이터를 들고 오는 것
//        post 데이터를 들고 오는 것
//        users 데이터를 들고 오는 것
    }
}