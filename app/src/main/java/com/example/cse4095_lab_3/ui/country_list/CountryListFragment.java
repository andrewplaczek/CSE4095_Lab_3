package com.example.cse4095_lab_3.ui.country_list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cse4095_lab_3.R;
import com.example.cse4095_lab_3.controller.ItemRecycleView;
import com.example.cse4095_lab_3.model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class CountryListFragment extends Fragment {

    private CountryListViewModel CountryListViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Country> countryList;
    private ItemRecycleView itemRecycleView;
    private RequestQueue queue;

    private String URL = "https://restcountries.eu/rest/v1/all";

    public void onCreate(Bundle myBundle) {
        super.onCreate(myBundle);

        CountryListViewModel =
                new ViewModelProvider(this).get(CountryListViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CountryListViewModel =
                new ViewModelProvider(this).get(CountryListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);

        queue = Volley.newRequestQueue(getContext());
        countryList = new ArrayList<>();

        recyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);
        itemRecycleView = new ItemRecycleView(R.layout.cardview_layout, countryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemRecycleView);

        loadCountryData();

        return root;
    }

    private void loadCountryData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonData = array.getJSONObject(i);

                        String name = jsonData.getString("name");
                        String capital = jsonData.getString("capital");
                        String region = jsonData.getString("region");
                        String subregion = jsonData.getString("subregion");
                        int population = jsonData.getInt("population");
                        double area = 0;
                        if (jsonData.get("area") != JSONObject.NULL){
                            area = jsonData.getDouble("area");
                        }

                        JSONArray borders = jsonData.getJSONArray("borders");
                        ArrayList<String> borderList = new ArrayList();
                        for (int j = 0; j < borders.length(); j++){
                            borderList.add(borders.getString(j));
                        }

                        JSONArray languages = jsonData.getJSONArray("languages");
                        ArrayList<String> languagesList = new ArrayList();
                        for (int j = 0; j < languages.length(); j++){
                            languagesList.add(languages.getString(j));
                        }

                        Country country = new Country(name, capital, region, subregion, population, area, borderList, languagesList);
                        countryList.add(country);

                    }

                    recyclerView.setAdapter(itemRecycleView);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        });
        queue.add(stringRequest);
    }
}