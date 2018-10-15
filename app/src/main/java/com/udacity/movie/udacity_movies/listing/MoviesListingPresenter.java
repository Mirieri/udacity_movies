package com.udacity.movie.udacity_movies.listing;


public interface MoviesListingPresenter
{
    void firstPage();

    void nextPage();

    void setView(MoviesListingView view);

    void searchMovie(String searchText);

    void searchMovieBackPressed();

    void destroy();
}
