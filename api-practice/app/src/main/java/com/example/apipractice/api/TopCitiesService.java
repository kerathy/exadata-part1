package com.example.apipractice.api;

import com.example.apipractice.models.TopCitiesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TopCitiesService {

    int groupSize = 50;
    String url = "currentconditions/v1/topcities/" + groupSize + "?";

    @GET(url)
    Call<List<TopCitiesResponse>> getTopCitiesInfo(@Query("apikey") String apikey);
}
