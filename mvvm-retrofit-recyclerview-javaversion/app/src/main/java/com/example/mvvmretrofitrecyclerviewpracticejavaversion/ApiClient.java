package com.example.mvvmretrofitrecyclerviewpracticejavaversion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private RetrofitService retrofitService;

    public RetrofitService getInstance() {
        if (retrofitService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            retrofitService = retrofit.create(RetrofitService.class);
        }
        return retrofitService;
    }
}
