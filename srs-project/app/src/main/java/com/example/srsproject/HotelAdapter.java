package com.example.srsproject.ui.roombooking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srsproject.R;

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

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.availableRoom.setText("1");
        holder.price.setText("2");
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView availableRoom;
        TextView price;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            availableRoom = itemView.findViewById(R.id.available_room);
            price = itemView.findViewById(R.id.price);

        }
    }
}


