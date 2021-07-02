package com.example.srsproject;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder>{

    private List<HotelModel> hotelsList;

    public HotelAdapter(List<HotelModel> hotelsList) {
        this.hotelsList = hotelsList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.availableRoom.setText(hotelsList.get(position).getAvailableRooms() + "");
        holder.price.setText(hotelsList.get(position).getPrice() + "");
        holder.relativeLayout.setBackgroundResource(hotelsList.get(position).getResid());
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView availableRoom;
        TextView price;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            availableRoom = itemView.findViewById(R.id.available_room);
            price = itemView.findViewById(R.id.price);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}


