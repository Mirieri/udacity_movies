package com.udacity.movie.udacity_movies.details;

import dagger.Subcomponent;


@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent
{
    void inject(MovieDetailsFragment target);
}
