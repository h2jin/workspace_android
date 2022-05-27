package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.recyclerview.models.Food;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent() != null) {
            Food food = (Food) getIntent().getSerializableExtra("obj"); //다운캐스팅처리
            Log.d("TAG", food.toString());
        }

    }
}