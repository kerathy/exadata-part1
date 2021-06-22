package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private List<MovieModel> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter = new MovieAdapter(movieList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);

        addData();
        insertData();
//        updateData();
//        removeData();
    }

    private void addData() {
        String[] titles = {"Mad Max: Fury Road", "Inside Out", "Star Wars: Episode VII - The Force Awakens",
                "Shaun the Sheep", "The Martian", "Mission: Impossible Rogue Nation", "Up",
                "Star Trek", "The LEGO MovieModel", "Aliens", "Chicken Run", "Back to the Future",
                "Raiders of the Lost Ark", "Goldfinger", "Guardians of the Galaxy"};

        String[] genres = {"Action & Adventure", "Animation, Kids & Family", "Action",
                "Animation", "Science Fiction & Fantasy", "Action", "Animation",
                "Science Fiction", "Animation", "Action & Adventure", "Science Fiction", "Animation",
                "Action & Adventure", "Action & Adventure", "Science Fiction & Fantasy"};

        String[] years = {"2015", "2015", "2015", "2015", "2015", "2015", "2009",
            "2009", "2014", "2008", "1986", "2000", "1985", "1981", "1965", "2014"};

        for (int i = 0; i < titles.length; i++) {
            movieList.add(new MovieModel(titles[i], genres[i], years[i]));
        }
        movieAdapter.notifyDataSetChanged();
    }


    public void insertData() {
        MovieModel movie = new MovieModel("insert movie title", "insert movie genre", "insert movie year");
        movieList.add(movie);
        movieAdapter.notifyDataSetChanged();
    }

    public void updateData() {
        movieList.clear();

        MovieModel movieModel = new MovieModel("update movie title1", "update movie genre1", "update movie year1");
        MovieModel movieModel2 = new MovieModel("update movie title2", "update movie genre2", "update movie year2");
        movieList.add(movieModel);
        movieList.add(movieModel2);

        movieList.add(movieModel);
        movieAdapter.notifyDataSetChanged();
    }

    public void removeData() {
        movieList.clear();
        movieAdapter.notifyDataSetChanged();
    }

}