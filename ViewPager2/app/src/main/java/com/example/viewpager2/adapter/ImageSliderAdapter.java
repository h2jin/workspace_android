package com.example.viewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 뷰 홀더 생성
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHorder> {

    private Context context;
    private ArrayList<String> slideImage;

    public ImageSliderAdapter(Context context, ArrayList<String> slideImage) {
        this.context = context;
        this.slideImage = slideImage;
    }

    // 리턴타입 내가 먼저 만들어놓은 ViewHorder로 자동으로 설정됨. 그래서 내부클래스 먼저 생성
    @NonNull
    @Override
    public ViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_image_slider, parent, false);

        return new ViewHorder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHorder holder, int position) {
        holder.bindSliderImage(slideImage.get(position));
    }

    @Override
    public int getItemCount() {
        return slideImage.size();
    }


    //내부클래스
    public class ViewHorder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHorder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSliderImage(String imageURL) {
            Glide.with(context).load(imageURL).centerCrop().into(imageView);
        }
    } // end of inner class

}
