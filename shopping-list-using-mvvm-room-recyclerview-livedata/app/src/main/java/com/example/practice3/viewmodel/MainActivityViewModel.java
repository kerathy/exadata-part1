package com.example.practice3.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.practice3.db.AppDatabase;
import com.example.practice3.db.Category;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Category>> mutableLiveData;
    private AppDatabase appDatabase;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mutableLiveData = new MutableLiveData<>();
        appDatabase = AppDatabase.getDbInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Category>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void getAllCategories() {
        List<Category> list = appDatabase.shoppingListDao().getAllCategoriesList();
        mutableLiveData.postValue(list.size() > 0 ? list : null);
    }

    public void insertCategory(String categoryName) {
        Category category = new Category(categoryName);
        appDatabase.shoppingListDao().insertCategory(category);
        getAllCategories();
    }

    public void updateCategory(Category category) {
        appDatabase.shoppingListDao().updateCategory(category);
        getAllCategories();
    }

    public void deleteCategory(Category category) {
        appDatabase.shoppingListDao().deleteCategory(category);
        getAllCategories();
    }
}
