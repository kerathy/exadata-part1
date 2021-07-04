package com.example.srsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Manager extends AppCompatActivity {

    private List<EmployeeModel> employeesList = new ArrayList<>();
    private EmployeeAdapter employeeAdapter = new EmployeeAdapter(employeesList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(employeeAdapter);

        addData();
    }

    private void addData() {
        employeesList.add(new EmployeeModel("Samir Ali"));
        employeesList.add(new EmployeeModel("Alaa alaa"));
        employeesList.add(new EmployeeModel("Rana abdo"));
    }
}