package com.udacity.movie.udacity_movies.listing;



import com.udacity.movie.udacity_movies.Movie;

import java.util.List;

import io.reactivex.Observable;


public interface MoviesListingInteractor
{
    boolean isPaginationSupported();
    Observable<List<Movie>> fetchMovies(int page);
    Observable<List<Movie>> searchMovie(String searchQuery);
}
