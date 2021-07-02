package com.example.srsproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RoomBooking extends AppCompatActivity {

    private List<HotelModel> hotelsList = new ArrayList<>();
    private HotelAdapter hotelAdapter = new HotelAdapter(hotelsList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_booking);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(hotelAdapter);

        addData();
    }

    public void addData() {
        hotelsList.add(new HotelModel(2, 330, R.drawable.room_image1));
        hotelsList.add(new HotelModel(3, 540, R.drawable.room_image2));
        hotelsList.add(new HotelModel(5, 1000, R.drawable.room_image3));
        hotelAdapter.notifyDataSetChanged();
    }
}