package com.example.movie_1.adapter;

// 내부클래스 먼저 만들기

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_1.R;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemClicked movieItemClicked;

    // 콜백메서드 메서드를 이용하여 연결하는 방식
    public void setMovieItemClicked(OnMovieItemClicked movieItemClicked) {
        this.movieItemClicked = movieItemClicked;
    }

    // 통신 배우기 전에는 생성자에서 데이터를 전달받아서 화면을 구성
    // 통신이기 때문에 화면을 그리는 시점보다 더 늦게 데이터가 도달할 수 있음.
    // 메서드로 만들어서 연결해주면 됨
    public void addItemList(List<Movie> list) {
        this.list = list; // 덮어쓰지 않고 변경해줬음..
        notifyDataSetChanged(); // 데이터가 변경되었으면 바뀌었다고 알려줌. 그럼 안드로이드가 다시 그려줌
    }

    public void addItem(List<Movie> addList) {
        this.list.addAll(list.size(), addList); //마지막에 추가해줘야 하기 때문에, list.size
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 인플레이터 써서 메모리에 올리고, xml 파일 메모리에 올려서 전달
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);
        holder.itemView.setOnClickListener(view -> {
            movieItemClicked.selectedItem(movie);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner static class
    // findViewById 때문에 뷰 홀더 생성. view Binding 결합 안됨. 직접 해야 함.
    // view Binding은 단방향. data Binding -> 마찬가지로 뷰 결합인데, 양방향임.
    // findViewById가 메모리에 영향을 너무 많이 끼치기 때문에 뷰 홀더로 성능 개선을 위해 코드를 짠 것.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // itemView에 선언한 데이터 타입들을 선언하고 생성시점에 R.id.xxx 연결 해주면 된다.
        private View itemView;
        private ImageView posterImageView;
        private TextView titleTextView;
        private TextView ratingTextView;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie) {
            titleTextView.setText(movie.getTitle());
            ratingTextView.setText(String.valueOf(movie.getRating())); // or +""
            // 9.312 () 이런식으로 데이터가 들어온다면--> Math.floor 를 써서 처리해주면 됨.
            ratingBar.setRating((float) movie.getRating());
            Glide.with(posterImageView.getContext())
                    .load(movie.getMediumCoverImage()).placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterImageView);
            // view Holder 안에서 세팅 : 뷰 홀더 안에 메서드 만들어서 (movie) 데이터 타입 넘겨주면 됨

            // 콜백메서드 만드는 방법

        }

    }// end of class

}
