package com.udacity.movie.udacity_movies.favorites;



import com.udacity.movie.udacity_movies.Movie;

import java.util.List;


public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
