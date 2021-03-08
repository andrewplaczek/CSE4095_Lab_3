package com.example.cse4095_lab_3.model;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse4095_lab_3.R;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private String TAG = "VIEW_HOLDER";

    public TextView name;
    public TextView capital;
    public TextView region;
    public ArrayList<Country> countryList;
    public int position = 0;

    public ViewHolder(View itemView, ArrayList<Country> countryList){
        super(itemView);

        this.countryList = countryList;

        //Goes to onclick (below) when specific view is clicked
        itemView.setOnClickListener(this);

        //Set up textviews from card
        name = itemView.findViewById(R.id.text_name);
        capital = itemView.findViewById(R.id.d_text_capital);
        region = itemView.findViewById(R.id.text_region);
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "clicked");

        final Bundle bundle = new Bundle();
        bundle.putString("name", countryList.get(position).getName());
        bundle.putString("capital", countryList.get(position).getCapital());
        bundle.putString("region", countryList.get(position).getRegion());
        bundle.putString("subregion", countryList.get(position).getSubregion());
        bundle.putInt("population", countryList.get(position).getPopulation());
        bundle.putDouble("area", countryList.get(position).getArea());
        bundle.putStringArrayList("borders", countryList.get(position).getBorders());
        bundle.putStringArrayList("languages", countryList.get(position).getLanguages());

        Navigation.findNavController(itemView).navigate(R.id.action_navigation_countries_to_detailsFragment, bundle);
    }

    public void setPosition(int position){
        this.position = position;
    }
}
