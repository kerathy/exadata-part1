package com.example.srsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookedRoom extends AppCompatActivity {

    private HotelApi hotelApi;
    TextView textViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_room);

        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        hotelApi = retrofit.create(HotelApi.class);

        textViewBook = findViewById(R.id.textview_book);

        textViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecords();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BookedRoom.this, BookedRoomEditing.class));
            }
        }, 5000);
    }

    private void getRecords() {
        Call<List<HotelModel>> records = hotelApi.getRecords();

        records.enqueue(new Callback<List<HotelModel>>() {
            @Override
            public void onResponse(Call<List<HotelModel>> call, Response<List<HotelModel>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("code: " + response.code());
                    return;
                }

                List<HotelModel> records = response.body();
                for (HotelModel hotelModel : records) {
                    String content = "id: " + hotelModel.getId() + "\n"
                            + "availableRooms: " + hotelModel.getAvailableRooms() + "\n"
                            + "price: "  + hotelModel.getPrice() + "\n"
                            + "resid: " + hotelModel.getResid() + "\n\n";
                    System.out.println(content);
                }
            }

            @Override
            public void onFailure(Call<List<HotelModel>> call, Throwable t) {
                System.out.println("failureMessage: " + t.getMessage());
            }
        });

    }
}





