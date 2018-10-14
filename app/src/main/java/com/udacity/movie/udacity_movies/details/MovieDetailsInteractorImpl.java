package com.udacity.movie.udacity_movies.details;



import com.udacity.movie.udacity_movies.Review;
import com.udacity.movie.udacity_movies.ReviewsWrapper;
import com.udacity.movie.udacity_movies.Video;
import com.udacity.movie.udacity_movies.VideoWrapper;
import com.udacity.movie.udacity_movies.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;


class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
