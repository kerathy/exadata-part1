package com.example.mvvmretrofitrecyclerviewpracticejavaversion;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private MainRepository mainRepository;

    @Inject
    public MyViewModelFactory(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mainRepository);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
