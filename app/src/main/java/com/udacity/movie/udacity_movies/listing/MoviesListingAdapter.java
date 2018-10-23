package com.udacity.movie.udacity_movies.listing;

import android.content.Context;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.movie.udacity_movies.Api;
import com.udacity.movie.udacity_movies.Movie;
import com.udacity.movie.udacity_movies.R;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Resources Used for Research
 * https://medium.com/@diprochowdhury/developing-a-movies-app-with-picasso-and-themoviedb-org-api-using-fragments-eb1bd19cf572
 * http://square.github.io/picasso/
 * https://www.androidhive.info/2017/10/android-working-with-butterknife-viewbinding-library/
 * http://jakewharton.github.io/butterknife/
 **/
public class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    private List<Movie> movies;
    private Context context;
    private MoviesListingView view;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;

        public Movie movie;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            MoviesListingAdapter.this.view.onMovieClicked(movie);
        }
    }

    public MoviesListingAdapter(List<Movie> movies, MoviesListingView moviesView) {
        this.movies = movies;
        view = moviesView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());

        Picasso.get()
                .load(Api.getPosterPath(holder.movie.getPosterPath()))
                .fit()
                .placeholder(R.drawable.ic_music)
                .centerCrop()
                .into(holder.poster);

    }

    private void setBackgroundColor(Palette palette, ViewHolder holder) {
        holder.titleBackground.setBackgroundColor(palette.getVibrantColor(context
                .getResources().getColor(R.color.black_translucent_60)));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
