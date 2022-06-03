package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.movie_1.databinding.ActivityMovieDetailBinding;
import com.example.movie_1.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    // detail Activity를 만들 때 두가지 방법
    // 1. 데이터를 전달 받아서 화면을 구성
    // 2. 여기서 통신을 요청해서 화면을 구성

    private Movie movie;
    public static final String PARAM_NAME_1 = "movie_obj";

    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(PARAM_NAME_1); // 그냥 오브젝트로 오기 때문에다운캐스팅
            initData();
            addEventListener();
        }
    }

    private void initData() {

        binding.titleTextView.setText(movie.getTitle());
        binding.yearTextView.setText("제작년도 : " + movie.getYear() + "년");
        binding.runtimeTextView.setText("상영시간 : " + movie.getRuntime() + "분");
        Glide.with(this).load(movie.getMediumCoverImage()).into(binding.moviesPoster);
        Glide.with(this).load(movie.getBackgroundImage()).into(binding.backgroundImageView);

    }

    private void addEventListener() {
    }
}