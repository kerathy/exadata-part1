package com.example.apipractice.network;

import com.example.apipractice.models.TopCitiesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitNetworkInterface {

    int groupSize = 50;
    String url = groupSize + "?";

    @GET(url)
    Call<List<TopCitiesResponse>> getTopCitiesInfo(@Query("apikey") String apikey);
}
