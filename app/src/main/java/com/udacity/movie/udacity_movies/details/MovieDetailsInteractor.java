package com.udacity.movie.udacity_movies.details;



import com.udacity.movie.udacity_movies.Review;
import com.udacity.movie.udacity_movies.Video;

import java.util.List;

import io.reactivex.Observable;


public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
