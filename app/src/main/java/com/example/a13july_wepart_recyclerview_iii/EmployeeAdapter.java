package com.example.a13july_wepart_recyclerview_iii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    private ArrayList<Employee> employeelist;
    private ItemClickListener itemClickListener;

    public EmployeeAdapter(ArrayList<Employee> employeelist, ItemClickListener itemClickListener) {
        this.employeelist = employeelist;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new EmployeeViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeelist.get(position);
        holder.setData(employee);
    }


    @Override
    public int getItemCount() {
        return employeelist.size();
    }
}