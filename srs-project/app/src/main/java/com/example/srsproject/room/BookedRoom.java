package com.example.srsproject.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.srsproject.employee.Manager;
import com.example.srsproject.R;

public class BookedRoom extends AppCompatActivity {

    TextView textViewAailableRooms;
    TextView textViewPrice;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_room);
        Intent intent = getIntent();

        textViewAailableRooms = findViewById(R.id.available_room);
        textViewPrice = findViewById(R.id.price);
        relativeLayout = findViewById(R.id.relative_layout);

        int availableRooms = intent.getIntExtra("availableRooms", 0);
        int price = intent.getIntExtra("price", 0);
        int resid = intent.getIntExtra("resid", 0);

        textViewAailableRooms.setText(String.valueOf(availableRooms));
        textViewPrice.setText(String.valueOf(price));
        relativeLayout.setBackgroundResource(resid);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BookedRoom.this, BookedRoomEditing.class));
            }
        }, 5000);

    }

    public static class BookedRoomEditing extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booked_room_editing);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(BookedRoomEditing.this, Manager.class));
                }
            }, 5000);
        }
    }
}





