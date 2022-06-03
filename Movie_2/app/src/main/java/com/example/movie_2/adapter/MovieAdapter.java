package com.example.movie_2.adapter;

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
import com.example.movie_2.R;
import com.example.movie_2.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    // 내부클래스
    public class MyViewHolder extends RecyclerView.ViewHolder {

        //??
        private View itemView;
        private ImageView posterImageView;
        private TextView titleTextView;
        private TextView ratingTextView;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            posterImageView = itemView.findViewById(R.id.moviePosterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie) {
            titleTextView.setText(movie.getTitle());
            ratingTextView.setText(String.valueOf(movie.getRating()));
            ratingBar.setRating((float) movie.getRating());
            Glide.with(posterImageView.getContext()).load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterImageView);
        }
    } // end of inner class


}
