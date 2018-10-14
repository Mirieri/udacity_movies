package com.udacity.movie.udacity_movies.details;



import com.udacity.movie.udacity_movies.favorites.FavoritesInteractor;
import com.udacity.movie.udacity_movies.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
