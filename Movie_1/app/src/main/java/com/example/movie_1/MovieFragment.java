package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.databinding.FragmentMovieBinding;


public class MovieFragment extends Fragment {

    // 안드로이드에서 만들어 준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 불변성 유지, 한번 올라가면 데이터를 변경하지 못하게 하도록. 성능에도 좋음.
    
    public MovieFragment() {
        // Required empty public constructor
    }
    
    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체 (뷰 바인딩 활용)
        // inflater.inflate(R.layout.fragment_movie, container, false)
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}