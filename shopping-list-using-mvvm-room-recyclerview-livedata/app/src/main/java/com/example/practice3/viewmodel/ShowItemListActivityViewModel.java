package com.example.practice3.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.practice3.db.AppDatabase;
import com.example.practice3.db.Item;

import java.util.List;

public class ShowItemListActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Item>> mutableLiveData;
    private AppDatabase appDatabase;

    public ShowItemListActivityViewModel(@NonNull Application application) {
        super(application);
        mutableLiveData = new MutableLiveData<>();
        appDatabase = AppDatabase.getDbInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Item>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void getAllItems(int categoryId) {
        List<Item> list = appDatabase.shoppingListDao().getAllItemsList(categoryId);
        mutableLiveData.postValue(list.size() > 0 ? list : null);
    }

    public void insertItem(Item item) {
        appDatabase.shoppingListDao().insertItem(item);
        getAllItems(item.getCategoryId());
    }

    public void updateItem(Item item) {
        appDatabase.shoppingListDao().updateItem(item);
        getAllItems(item.getCategoryId());
    }

    public void deleteItem(Item item) {
        appDatabase.shoppingListDao().deleteItem(item);
        getAllItems(item.getCategoryId());
    }
}
