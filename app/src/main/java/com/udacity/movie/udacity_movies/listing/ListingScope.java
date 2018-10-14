package com.udacity.movie.udacity_movies.listing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author arunsasidharan
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ListingScope
{
}
