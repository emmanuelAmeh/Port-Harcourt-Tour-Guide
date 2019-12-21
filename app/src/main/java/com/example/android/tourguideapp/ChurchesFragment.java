package com.example.android.tourguideapp;

/*
 * This fragment handles churches in port harcourt
 * image sources and about for the churches were sourced from their facebook accounts and websites
 * */
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Fragment to handle churches list
 */
public class ChurchesFragment extends Fragment {

    public ChurchesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //creating and inflating View
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //adding churches
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.hotr), R.drawable.hotr, getString(R.string.about_hotr), getString(R.string.web_hotr)));
        places.add(new Place(getString(R.string.tka), R.drawable.tka, getString(R.string.about_tka), getString(R.string.web_tka)));
        places.add(new Place(getString(R.string.salvation), R.drawable.salvation, getString(R.string.about_salvation), getString(R.string.web_salvation)));
        places.add(new Place(getString(R.string.jesus_house), R.drawable.jesus_house, getString(R.string.about_jesus_house), getString(R.string.web_jesus_house)));

        //using the custom adapter created for places
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places, R.color.church);

        //using listview to show the places. linking it to the list xml
        ListView listView = rootView.findViewById(R.id.list);

        //setting the listview to use the custom adapter
        listView.setAdapter(adapter);

        return rootView;
    }

}
