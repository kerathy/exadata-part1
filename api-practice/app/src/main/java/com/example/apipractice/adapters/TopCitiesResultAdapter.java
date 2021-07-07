package com.example.apipractice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.apipractice.R;
import com.example.apipractice.models.TopCitiesResponse;
import java.util.ArrayList;
import java.util.List;

public class TopCitiesResultAdapter extends RecyclerView.Adapter<TopCitiesResultAdapter.TopCitiesResultHolder>{
    private List<TopCitiesResponse> results = new ArrayList<>();

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public TopCitiesResultHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new TopCitiesResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TopCitiesResultAdapter.TopCitiesResultHolder holder, int position) {
        holder.cityTextView.setText(results.get(position).getLocalizedName());
        holder.countryTextView.setText(results.get(position).country.getLocalizedName());
        holder.latitudeTextView.setText(String.valueOf(results.get(position).geoPosition.getLatitude()));
        holder.longitudeTextView.setText(String.valueOf(results.get(position).geoPosition.getLongitude()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<TopCitiesResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class TopCitiesResultHolder extends RecyclerView.ViewHolder {
        private TextView cityTextView;
        private TextView countryTextView;
        private TextView latitudeTextView;
        private TextView longitudeTextView;

        public TopCitiesResultHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.item_city);
            countryTextView = itemView.findViewById(R.id.item_country);
            latitudeTextView = itemView.findViewById(R.id.item_latitude);
            longitudeTextView = itemView.findViewById(R.id.item_longitude);
        }
    }
}
