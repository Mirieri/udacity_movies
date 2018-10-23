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

/**
 * Resources Used for Research
 * https://medium.com/@diprochowdhury/developing-a-movies-app-with-picasso-and-themoviedb-org-api-using-fragments-eb1bd19cf572
 * http://square.github.io/picasso/
 * https://www.androidhive.info/2017/10/android-working-with-butterknife-viewbinding-library/
 * http://jakewharton.github.io/butterknife/
 **/
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
