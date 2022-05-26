package com.example.recyclerview.adapter;

//뷰 홀더 만들기

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    //    멤버 변수 선언
    ArrayList<Food> list;
    Context context;
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodAdapter(ArrayList<Food> list, Context context, OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        new ViewHorder 생성하라
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        BindViewHorder 화면과 연결
//        데이터 맵핑
        Log.d("TAG", "position : " + position);
        Food food = list.get(position);

        Glide.with(context).load(food.getThumbnail())
//                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);
        holder.titleTextView.setText(food.getTitle());
        holder.subTitleView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());


    }

    @Override
    public int getItemCount() {
//        반복적인 아이템을 넣을 건데 몇개의 아이템을 넣을 건지 알려달라
        return list.size(); // 0 그대로 놔두면 생성 안됨.
    }

    //    1. 내부클래스 만들기
//    Adapter 뷰와 item_food를 연결시키려고 사용. findviewMyId 를 해주는 역할
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView titleTextView;
        TextView subTitleView;
        TextView detailTextView;
//        일관성 없음.. 변수명 수정

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleView = itemView.findViewById(R.id.subTitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);

//            통으로 잡음. 하나만 걸고 싶으면 detailTExtView 이런식으로 걸면 된다.
            itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext(),
                        "TEST" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                콜백메서드 호출 , 매게변수 세팅
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });

        }
    }// end of inner class
}
