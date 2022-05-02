package com.leo.oscarapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leo.oscarapp.R;
import com.leo.oscarapp.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private List<Movie> movies;

    public MovieAdapter(List<Movie> list) {this.movies = list;}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView movieName, movieGenre;
        ImageView movieImage;

        public MyViewHolder(View view) {
            super(view);
            movieName = view.findViewById(R.id.movieName);
            movieGenre = view.findViewById(R.id.movieGenre);
            movieImage = view.findViewById(R.id.movieImage);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieName.setText(movie.getName());
        holder.movieGenre.setText(movie.getGenre());
        holder.movieImage.setImageResource(movie.getPhoto());
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }
}
