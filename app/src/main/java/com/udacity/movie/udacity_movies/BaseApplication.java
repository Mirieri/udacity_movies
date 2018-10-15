package com.udacity.movie.udacity_movies;

import android.app.Application;
import android.os.StrictMode;


import com.udacity.movie.udacity_movies.details.DetailsComponent;
import com.udacity.movie.udacity_movies.details.DetailsModule;
import com.udacity.movie.udacity_movies.favorites.FavoritesModule;
import com.udacity.movie.udacity_movies.listing.ListingComponent;
import com.udacity.movie.udacity_movies.listing.ListingModule;
import com.udacity.movie.udacity_movies.network.NetworkModule;
import dagger.Component;

import io.realm.Realm;


public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {

        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
