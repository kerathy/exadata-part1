package com.example.srsproject.room;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srsproject.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {

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
        int itemAvailableRooms = hotelsList.get(position).getAvailableRooms();
        int itemPrice = hotelsList.get(position).getPrice();
        int itemResid = hotelsList.get(position).getResid();

        holder.availableRoom.setText(String.valueOf(itemAvailableRooms));
        holder.price.setText(String.valueOf(itemPrice));
        holder.relativeLayout.setBackgroundResource(itemResid);
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView availableRoom;
        TextView price;
        RelativeLayout relativeLayout;
        TextView textViewBook;
        HotelApi hotelApi;
        int itemAvailableRooms;
        int itemPrice;
        int itemResid;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            availableRoom = itemView.findViewById(R.id.available_room);
            price = itemView.findViewById(R.id.price);
            relativeLayout = itemView.findViewById(R.id.relative_layout);

            textViewBook = itemView.findViewById(R.id.textview_book);

            textViewBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    itemAvailableRooms= hotelsList.get(itemPosition).getAvailableRooms();
                    itemPrice = hotelsList.get(itemPosition).getPrice();
                    itemResid = hotelsList.get(itemPosition).getResid();

                    Intent intent = new Intent(v.getContext(), BookedRoom.class);
                    intent.putExtra("availableRooms", itemAvailableRooms);
                    intent.putExtra("price", itemPrice);
                    intent.putExtra("resid", itemResid);

                    v.getContext().startActivity(intent);
                    create();
                }

                public void create() {
                    Gson gson = new GsonBuilder().serializeNulls().create();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                    hotelApi = retrofit.create(HotelApi.class);

                    Map<String, String> fields = new HashMap<>();
                    fields.put("availableRooms", String.valueOf(itemAvailableRooms));
                    fields.put("price", String.valueOf(itemPrice));
                    fields.put("resid", String.valueOf(itemResid));

                    Call<HotelModel> call = hotelApi.createRecord(fields);

                    call.enqueue(new Callback<HotelModel>() {
                        @Override
                        public void onResponse(Call<HotelModel> call, Response<HotelModel> response) {
                            if (!response.isSuccessful()) {
                                System.out.println("code" + response.code());
                                return;
                            }
                            HotelModel body = response.body();
                            String content = response.code() + "\n"
                                    + "id: " + body.getId() + "\n"
                                    + "availableRooms: " + body.getAvailableRooms() + "\n"
                                    + "price: " + body.getPrice() + "\n"
                                    + "resid: " + body.getResid() + "\n\n";

                            System.out.println(content);
                        }

                        @Override
                        public void onFailure(Call<HotelModel> call, Throwable t) {
                            System.out.println("failureMessage: " + t.getMessage());
                        }
                    });
                }
            });
        }
    }
}


