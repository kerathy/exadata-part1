package com.example.practice3.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice3.R;
import com.example.practice3.adapters.ItemListAdapter;
import com.example.practice3.db.Item;
import com.example.practice3.viewmodel.ShowItemListActivityViewModel;
import java.util.List;

public class ShowItemListActivity extends AppCompatActivity implements ItemListAdapter.HandleItemClick{

    private ShowItemListActivityViewModel showItemListActivityViewModel;
    private Item itemToUpdate;
    private ItemListAdapter itemListAdapter;

    private RecyclerView recyclerView;
    private EditText editText;
    private ImageView saveButton;
    private TextView noResultTextView;

    private int categoryId;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_list);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.addNewItemInput);
        saveButton = findViewById(R.id.saveButton);
        noResultTextView = findViewById(R.id.noResultTextView);

        categoryId = getIntent().getIntExtra("category_id", 0);
        categoryName = getIntent().getStringExtra("category_name");

        getSupportActionBar().setTitle(categoryName);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = editText.getText().toString();
                if (TextUtils.isEmpty(itemName)) {
                    Toast.makeText(ShowItemListActivity.this, "Enter item name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (itemToUpdate == null) {
                    saveItem(itemName);
                } else {
                    updateItem(itemName);
                }
                editText.setText("");
            }
        });

        initViewModel();
    }

    public void initViewModel() {
        showItemListActivityViewModel = new ViewModelProvider(this).get(ShowItemListActivityViewModel.class);
        showItemListActivityViewModel.getMutableLiveData().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                if (items == null) {
                    recyclerView.setVisibility(View.GONE);
                    noResultTextView.setVisibility(View.VISIBLE);
                } else {
                    itemListAdapter.setItemsList(items);
                    recyclerView.setVisibility(View.VISIBLE);
                    noResultTextView.setVisibility(View.GONE);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemListAdapter = new ItemListAdapter(this, this);
        recyclerView.setAdapter(itemListAdapter);

        showItemListActivityViewModel.getAllItems(categoryId);
    }


    @Override
    public void clickItem(Item item) {
        item.setCompleted(!item.isCompleted());
        showItemListActivityViewModel.updateItem(item);
    }

    @Override
    public void removeItem(Item item) {
        showItemListActivityViewModel.deleteItem(item);
    }

    @Override
    public void editItem(Item item) {
        editText.setText(item.getItemName());
        this.itemToUpdate = item;
    }

    public void updateItem(String newName) {
        itemToUpdate.setItemName(newName);
        showItemListActivityViewModel.updateItem(itemToUpdate);
        itemToUpdate = null;
    }

    public void saveItem(String itemName) {
        Item item = new Item(itemName);
        item.setCategoryId(categoryId);
        showItemListActivityViewModel.insertItem(item);
    }
}