package com.udacity.movie.udacity_movies.listing;



import com.udacity.movie.udacity_movies.sorting.SortingDialogFragment;
import com.udacity.movie.udacity_movies.sorting.SortingModule;

import dagger.Subcomponent;


@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
