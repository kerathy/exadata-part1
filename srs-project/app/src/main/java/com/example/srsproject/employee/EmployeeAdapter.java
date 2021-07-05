package com.example.srsproject.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.srsproject.R;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    private List<EmployeeModel> employeesList;

    public EmployeeAdapter(List<EmployeeModel> employeesList) {
        this.employeesList = employeesList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manager_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.name.setText(employeesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textview_name);
        }
    }

}

