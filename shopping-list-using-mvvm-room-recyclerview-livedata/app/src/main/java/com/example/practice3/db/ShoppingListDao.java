package com.example.practice3.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Query("SELECT * FROM Category")
    List<Category> getAllCategoriesList();

    @Insert
    void insertCategory(Category... categories);

    @Update
    void updateCategory(Category category);

    @Delete
    void deleteCategory(Category category);


    @Query("SELECT * FROM Item WHERE categoryId2 = :catId")
    List<Item> getAllItemsList(int catId);

    @Insert
    void insertItem(Item... items);

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);

}

