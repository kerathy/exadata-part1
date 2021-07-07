package com.example.apipractice.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.apipractice.api.TopCitiesService;
import com.example.apipractice.models.TopCitiesResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopCitiesRepository {

    private static final String BaseUrl = "http://dataservice.accuweather.com/";
    private TopCitiesService topCitiesService;
    private MutableLiveData<List<TopCitiesResponse>> topCitiesResponseMutableLiveData;

    public TopCitiesRepository() {
        topCitiesResponseMutableLiveData = new MutableLiveData<>();

        topCitiesService = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TopCitiesService.class);
    }

    public void searchTopCities(String apikey) {
        topCitiesService.getTopCitiesInfo(apikey)
                .enqueue(new Callback<List<TopCitiesResponse>>() {
            @Override
            public void onResponse(Call<List<TopCitiesResponse>> call, Response<List<TopCitiesResponse>> response) {
                if (response.body() != null) {
                    topCitiesResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TopCitiesResponse>> call, Throwable t) {
                topCitiesResponseMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<List<TopCitiesResponse>> getTopCitiesResponseLiveData() {
        return topCitiesResponseMutableLiveData;
    }

}
