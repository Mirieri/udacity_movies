package com.udacity.movie.udacity_movies;



import com.udacity.movie.udacity_movies.details.DetailsComponent;
import com.udacity.movie.udacity_movies.details.DetailsModule;
import com.udacity.movie.udacity_movies.favorites.FavoritesModule;
import com.udacity.movie.udacity_movies.listing.ListingComponent;
import com.udacity.movie.udacity_movies.listing.ListingModule;
import com.udacity.movie.udacity_movies.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
