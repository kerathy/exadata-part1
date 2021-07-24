package com.example.practice3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice3.R;
import com.example.practice3.db.Category;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {

    private Context context;
    private List<Category> categoryList;
    private HandleCategory handleCategory;

    public CategoryListAdapter(Context context, HandleCategory handleCategory) {
        this.context = context;
        this.handleCategory = handleCategory;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.MyViewHolder holder, int position) {
        holder.textViewCategoryName.setText(categoryList.get(position).getCategoryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCategory.clickCategory(categoryList.get(position));
            }
        });

        holder.imageViewEditCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCategory.editCategory(categoryList.get(position));
            }
        });

        holder.imageViewRemoveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCategory.removeCategory(categoryList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (categoryList == null || categoryList.size() == 0) ? 0 : categoryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCategoryName;
        ImageView imageViewRemoveCategory;
        ImageView imageViewEditCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCategoryName = itemView.findViewById(R.id.categoryName);
            imageViewRemoveCategory = itemView.findViewById(R.id.removeCategory);
            imageViewEditCategory = itemView.findViewById(R.id.editCategory);
        }
    }

    public interface HandleCategory {
        void clickCategory(Category category);
        void removeCategory(Category category);
        void editCategory(Category category);
    }
}
