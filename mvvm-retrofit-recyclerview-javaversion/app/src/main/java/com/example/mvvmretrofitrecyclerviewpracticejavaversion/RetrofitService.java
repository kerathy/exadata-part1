package com.example.mvvmretrofitrecyclerviewpracticejavaversion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("movielist.json")
    Call<List<Movie>> getAllMovies();


}
