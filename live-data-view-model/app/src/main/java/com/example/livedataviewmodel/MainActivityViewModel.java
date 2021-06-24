package com.example.livedataviewmodel;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<List<String>> fruitList;


    LiveData<List<String>> getFruitList() {
        if (fruitList == null) {
            fruitList = new MutableLiveData<>();
            loadFruits();
        }
        return fruitList;
    }

    private void loadFruits() {
        // do async operation to fetch users
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            String[] data = {"Mango", "Apple", "Orange", "Banana", "Grapes"};
            List<String> fruitsStringList = new ArrayList<>(Arrays.asList(data));

            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            fruitList.setValue(fruitsStringList);
        }, 500);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        System.out.println("tag" + TAG);
        Log.d(TAG, "on cleared called");
    }
}
