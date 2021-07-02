package com.example.mvvmretrofitrecyclerviewpracticejavaversion;


import java.util.List;

import retrofit2.Call;

public class MainRepository {

    private RetrofitService retrofitService;

    public Call<List<Movie>> getAllMovies() {
        return retrofitService.getAllMovies();
    }

}
