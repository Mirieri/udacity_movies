package com.udacity.movie.udacity_movies.details;



import com.udacity.movie.udacity_movies.Movie;
import com.udacity.movie.udacity_movies.Review;
import com.udacity.movie.udacity_movies.Video;

import java.util.List;

interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
