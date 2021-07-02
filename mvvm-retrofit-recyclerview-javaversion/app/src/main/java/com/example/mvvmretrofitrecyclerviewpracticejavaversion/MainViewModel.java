package com.example.mvvmretrofitrecyclerviewpracticejavaversion;

import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MainRepository mainRepository;
    private List<Movie> movieList;
    private String errorMessage;

    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void getAllMovies() {
        Call<List<Movie>> call = mainRepository.getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                errorMessage = t.getMessage();
            }
        });
    }
}
