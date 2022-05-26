package com.example.mymarketkurly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Food> sampleData = Food.getFoodList();

        LinearLayout container = findViewById(R.id.foodContainer);

        LayoutInflater inflater = LayoutInflater.from(this);

        sampleData.forEach(food -> {

            View itemView = inflater.inflate(R.layout.item_food, container, false);

            ImageView foodImageView = itemView.findViewById(R.id.foodImage);
            TextView foodCompany = itemView.findViewById(R.id.foodCompany);
            TextView foodName = itemView.findViewById(R.id.foodName);
            TextView foodAmount = itemView.findViewById(R.id.foodAmount);
            TextView foodPrice = itemView.findViewById(R.id.foodPrice);

            foodCompany.setText(food.company);
            foodName.setText(food.name);
            foodAmount.setText(food.amount);
            foodPrice.setText(food.price);

            Glide.with(this).load(food.imageUrl).centerCrop().into(foodImageView);

            container.addView(itemView);


        });


    }
}