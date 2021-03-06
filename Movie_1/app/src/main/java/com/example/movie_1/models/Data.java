package com.example.movie_1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("movie_count")
    @Expose
    private int movieCount;
    private int limit;
    private List<Movie> movies;

    public int getMovie_count() {
        return movieCount;
    }

    public void setMovie_count(int movie_count) {
        this.movieCount = movie_count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
