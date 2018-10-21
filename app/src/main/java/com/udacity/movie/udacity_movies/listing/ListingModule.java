package com.udacity.movie.udacity_movies.listing;



import com.udacity.movie.udacity_movies.favorites.FavoritesInteractor;
import com.udacity.movie.udacity_movies.sorting.SortingOptionStore;
import com.udacity.movie.udacity_movies.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService,
                                                          SortingOptionStore sortingOptionStore) {
        return new MoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
