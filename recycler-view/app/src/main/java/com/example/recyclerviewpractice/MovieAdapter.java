package com.example.recyclerviewpractice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<MovieModel> moviesList;

    public MovieAdapter(List<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MovieAdapter.MyViewHolder holder, int position) {
        holder.title.setText(moviesList.get(position).getTitle());
        holder.genre.setText(moviesList.get(position).getGenre());
        holder.year.setText(moviesList.get(position).getYear());
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView year;
        TextView genre;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            year = view.findViewById(R.id.year);
            genre = view.findViewById(R.id.genre);
        }
    }
}

