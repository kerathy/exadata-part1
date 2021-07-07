package com.example.apipractice.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.apipractice.models.TopCitiesResponse;
import com.example.apipractice.repositories.TopCitiesRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopCitiesViewModel extends AndroidViewModel {

    private TopCitiesRepository topCitiesRepository;
    private LiveData<List<TopCitiesResponse>> topCitiesResponseLiveData;

    public TopCitiesViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    public void init() {
        topCitiesRepository = new TopCitiesRepository();
        topCitiesResponseLiveData = topCitiesRepository.getTopCitiesResponseLiveData();
    }

    public void searchTopCities(String apikey) {
        topCitiesRepository.searchTopCities(apikey);
    }

    public LiveData<List<TopCitiesResponse>> getTopCitiesResponseLiveData() {
        return topCitiesResponseLiveData;
    }
}
