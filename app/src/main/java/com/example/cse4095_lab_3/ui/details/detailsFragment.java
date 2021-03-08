package com.example.cse4095_lab_3.ui.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cse4095_lab_3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public detailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment detailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static detailsFragment newInstance(String param1, String param2) {
        detailsFragment fragment = new detailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Bundle bundle = getArguments();
        //Get Information from bundle to display in textviews
        String name = bundle.getString("name");
        String capital = bundle.getString("capital");
        String region = bundle.getString("region");
        String subregion = bundle.getString("subregion");
        int population = bundle.getInt("population");
        double area = bundle.getInt("area");
        ArrayList<String> borders = bundle.getStringArrayList("borders");
        ArrayList<String> languages = bundle.getStringArrayList("languages");

        //Find TextViews
        TextView name_text = view.findViewById(R.id.d_text_name);
        TextView capital_text = view.findViewById(R.id.d_text_capital);
        TextView region_text = view.findViewById(R.id.d_text_region);
        TextView subregion_text = view.findViewById(R.id.subregion_text);
        TextView population_text = view.findViewById(R.id.population_text);
        TextView area_text = view.findViewById(R.id.area_text);
        TextView borders_text = view.findViewById(R.id.borders_text);
        TextView languages_text = view.findViewById(R.id.languages_text);

        //Set Text for non-list textviews
        name_text.setText("Country: " + name);
        capital_text.setText("Capital: " + capital);
        region_text.setText("Region: " + region);
        subregion_text.setText("Subregion: " + subregion);
        population_text.setText("Population: " + Integer.toString(population));
        if (area == 0){
            area_text.setText("Area not available");
        }
        else{
            area_text.setText("Area: " + Double.toString(area) + " km²");
        }

        //Set up string to store list textview text
        String borderstr = "Borders: ";
        String languagestr = "Languages: ";

        for(int i = 0; i < borders.size(); i++){
            if (i == 0){
                borderstr = borderstr + borders.get(i);
            }
            else{
                borderstr = borderstr + ", " + borders.get(i);
            }
        }

        for(int i = 0; i < languages.size(); i++){
            if (i == 0){
                languagestr = languagestr + languages.get(i);
            }
            else{
                languagestr = languagestr + ", " + languages.get(i);
            }
        }

        borders_text.setText(borderstr);
        languages_text.setText(languagestr);

    }

}