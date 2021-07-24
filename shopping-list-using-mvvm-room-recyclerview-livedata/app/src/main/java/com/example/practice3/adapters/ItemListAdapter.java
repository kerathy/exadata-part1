package com.example.practice3.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice3.R;
import com.example.practice3.db.Item;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder>{

    private Context context;
    private List<Item> itemsList;
    private HandleItemClick handleItemClick;

    public ItemListAdapter(Context context, HandleItemClick handleItemClick) {
        this.context = context;
        this.handleItemClick = handleItemClick;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.MyViewHolder holder, int position) {
        holder.textViewItemName.setText(itemsList.get(position).getItemName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick.clickItem(itemsList.get(position));
            }
        });

        holder.imageViewEditItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick.editItem(itemsList.get(position));
            }
        });

        holder.imageViewRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick.removeItem(itemsList.get(position));
            }
        });

        holder.textViewItemName.setPaintFlags(itemsList.get(position).isCompleted() ? (holder.textViewItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG) : 0);
    }

    @Override
    public int getItemCount() {
        return (itemsList == null || itemsList.size() == 0) ? 0 : itemsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemName;
        ImageView imageViewRemoveItem;
        ImageView imageViewEditItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.categoryName);
            imageViewRemoveItem = itemView.findViewById(R.id.removeCategory);
            imageViewEditItem = itemView.findViewById(R.id.editCategory);
        }
    }

    public interface HandleItemClick {
        void clickItem(Item item);
        void removeItem(Item item);
        void editItem(Item item);
    }
}
