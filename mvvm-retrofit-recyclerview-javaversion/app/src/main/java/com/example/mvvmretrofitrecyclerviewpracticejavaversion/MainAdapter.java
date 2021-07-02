//package com.example.mvvmretrofitrecyclerviewpracticejavaversion;
//
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.mvvmretrofitrecyclerviewpracticejavaversion.databinding.AdapterMovieBinding;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    List<Movie> movies;
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @NotNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
////        return null;
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        AdapterMovieBinding adapterMovieBinding = AdapterMovieBinding.inflate(inflater, parent, false);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return movies.size();
//    }
//}
//
//
////class MainViewHolder extends RecyclerView.ViewHolder {
////
////}