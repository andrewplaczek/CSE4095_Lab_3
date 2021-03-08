package com.example.cse4095_lab_3.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse4095_lab_3.model.Country;
import com.example.cse4095_lab_3.model.ViewHolder;

import java.util.ArrayList;

public class ItemRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int layout_id;
    private ArrayList<Country> countryList;

    public ItemRecycleView(int id, ArrayList<Country> countryList){
        this.layout_id = id;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_id,parent,false);
        ViewHolder myViewHolder = new ViewHolder(view, countryList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).setPosition(position);

        TextView name = ((ViewHolder) holder).name;
        TextView capital = ((ViewHolder) holder).capital;
        TextView region = ((ViewHolder) holder).region;

        name.setText("Name: " + countryList.get(position).getName());
        capital.setText("Capital: " + countryList.get(position).getCapital());
        region.setText("Region: " + countryList.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
