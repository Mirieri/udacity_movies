package com.udacity.movie.udacity_movies;

import com.squareup.moshi.Json;

import java.util.List;

public class MoviesWraper {
    @Json(name = "results")
    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movies) {
        this.movies = movies;
    }


}
