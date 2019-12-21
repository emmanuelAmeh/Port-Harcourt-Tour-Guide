package com.example.android.tourguideapp;
/*
* This fragment handles Restaurants in port harcourt
* image sources for restaurants https://hotels.ng/travel/top-15-restaurants-in-port-harcourt/
* */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragment to handle restaurants
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //creating and inflating View
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //adding restaurants
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.spice_route), R.drawable.asiantown, getString(R.string.about_spice_route), getString(R.string.web_spice_route)));
        places.add(new Place(getString(R.string.charcoal), R.drawable.charcoal_spice, getString(R.string.about_charcoal), getString(R.string.web_charcoal)));
        places.add(new Place(getString(R.string.asian_town), R.drawable.asian, getString(R.string.about_asian_town), getString(R.string.web_asian)));
        places.add(new Place(getString(R.string.cravings), R.drawable.cravings, getString(R.string.about_cravings), getString(R.string.web_craving)));

        //using the custom adapter created for places
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places, R.color.restaurant);

        //using listview to show the places. linking it to the list xml
        ListView listView = rootView.findViewById(R.id.list);

        //setting the listview to use the custom adapter
        listView.setAdapter(adapter);

        return rootView;
    }

}
