package com.udacity.movie.udacity_movies.sorting;


public interface SortingDialogPresenter
{
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void onNewestMoviesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
