package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    /*
     * RecyclerView
     *
     * -- 장점
     * -- ListView 개선판
     * -- ViewHolder 포함 (findViewId)
     * -- 유연하다.
     * -- LayoutManager, Adapter 클래스
     *
     * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodAdapter foodAdapter = new FoodAdapter(Food.getSampleData(), this, new OnFoodItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
//                여기가 호출되어 진다.
                Log.d("TAG", "넘겨받은 포지션" + position);
                Intent intent = new Intent(getApplication(), DetailActivity.class); //getApplication -> this대신에 씀
                intent.putExtra("obj", Food.getSampleData().get(position)); // 오브젝트 단위로 넘겨줄 수 없음.
                startActivity(intent);

            }
        });

        // 통신 Json 받는 부분
        ArrayList<Food> listSample = Food.getSampleData();
//        리사이클러뷰를 사용하기 위해서
//        1. Adapter 클래스를 직접 생성해야 한다.
//        2. LayoutManager 생성해서 Adapter 클래스와 연결해야 한다.

//        1.
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(new FoodAdapter(Food.getSampleData(), this)); 밑에 것으로 바꿔줌
        recyclerView.setAdapter(foodAdapter);
//        2.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView 를 사용하면 화면에 올라오는 순간 랜더링함.
//        addView 방식은 모든 데이터가 올라올 때까지 기다려야 함.
        
        recyclerView.hasFixedSize(); // 성능개선을 위한 코드.


    }
}