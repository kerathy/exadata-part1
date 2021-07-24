package com.example.practice3.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice3.R;
import com.example.practice3.adapters.CategoryListAdapter;
import com.example.practice3.db.Category;
import com.example.practice3.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryListAdapter.HandleCategory{

    private MainActivityViewModel mainActivityViewModel;
    private CategoryListAdapter categoryListAdapter;
    private Category category;
    private RecyclerView recyclerView;
    private TextView noResultTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Shopping List");

        noResultTextView = findViewById(R.id.noResultTextView);
        recyclerView = findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.addNewCategoryImageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddCategoryDialog(false);
            }
        });

        initViewModel();
        mainActivityViewModel.getAllCategories();
    }

    private void initViewModel() {
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getMutableLiveData().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if (categories == null) {
                    noResultTextView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    categoryListAdapter.setCategoryList(categories);
                    noResultTextView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryListAdapter = new CategoryListAdapter(this, this);
        recyclerView.setAdapter(categoryListAdapter);
    }

    private void showAddCategoryDialog(boolean isForEdit) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        View view = getLayoutInflater().inflate(R.layout.add_category_layout, null);

        EditText editText = view.findViewById(R.id.enterCategoryInput);
        TextView createButton = view.findViewById(R.id.createButton);
        TextView cancelButton = view.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(MainActivity.this, "Enter Category Name", Toast.LENGTH_LONG).show();
                    return;
                }

                if (isForEdit) {
                    category.setCategoryName(s);
                    mainActivityViewModel.updateCategory(category);
                } else {
                    mainActivityViewModel.insertCategory(s);
                }
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(view);
        alertDialog.show();
    }

    @Override
    public void clickCategory(Category category) {
        Intent intent = new Intent(MainActivity.this, ShowItemListActivity.class);
        intent.putExtra("category_id", category.getUid());
        intent.putExtra("category_name", category.getCategoryName());
        startActivity(intent);
    }

    @Override
    public void removeCategory(Category category) {
        mainActivityViewModel.deleteCategory(category);
    }

    @Override
    public void editCategory(Category category) {
        this.category = category;
        showAddCategoryDialog(true);
    }
}