package com.example.dependencyinjectionwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitNetworkInterface {

//    @GET("/dagger")
    @GET("users")
    Call<List<Songs>> allSongs();
}
