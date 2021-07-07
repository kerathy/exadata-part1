package com.example.apipractice.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apipractice.R;
import com.example.apipractice.adapters.TopCitiesResultAdapter;
import com.example.apipractice.models.TopCitiesResponse;
import com.example.apipractice.viewmodels.TopCitiesViewModel;

import java.util.List;

public class TopCitiesFragment extends Fragment {

    private TopCitiesViewModel topCitiesViewModel;
    private TopCitiesResultAdapter topCitiesResultAdapter;

    private EditText editText;
    private Button button;
    private String apikey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topCitiesResultAdapter = new TopCitiesResultAdapter();
        topCitiesViewModel = ViewModelProviders.of(this).get(TopCitiesViewModel.class);
        topCitiesViewModel.init();
        topCitiesViewModel.getTopCitiesResponseLiveData().observe(this, new Observer<List<TopCitiesResponse>>() {
            @Override
            public void onChanged(List<TopCitiesResponse> topCitiesResponses) {
                if (topCitiesResponses != null) {
                    topCitiesResultAdapter.setResults(topCitiesResponses);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_cities, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));;
        recyclerView.setAdapter(topCitiesResultAdapter);

        editText = view.findViewById(R.id.edittext_apikey);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apikey = editText.getText().toString();
                performSearch(apikey);
            }
        });

        return view;
    }

    public void performSearch(String apikey) {
        topCitiesViewModel.searchTopCities(apikey);
    }

}