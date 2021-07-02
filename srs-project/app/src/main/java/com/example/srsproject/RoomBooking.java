package com.example.srsproject.ui.roombooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.srsproject.ui.roombooking.*;

import android.os.Bundle;

import com.example.srsproject.R;

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
        hotelsList.add(new HotelModel(2, 330));
        hotelsList.add(new HotelModel(3, 540));
        hotelsList.add(new HotelModel(5, 1000));
        hotelAdapter.notifyDataSetChanged();
    }
}