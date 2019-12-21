package com.example.android.tourguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Fragment to handle list of hotels
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //creating and inflating View
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //adding restaurants
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.presidential), R.drawable.presidential, getString(R.string.about_presidential), getString(R.string.web_presidential)));
        places.add(new Place(getString(R.string.novotel), R.drawable.novotel, getString(R.string.about_novotel), getString(R.string.web_novotel)));
        places.add(new Place(getString(R.string.laking), R.drawable.laking, getString(R.string.about_laking), getString(R.string.web_laking)));
        places.add(new Place(getString(R.string.golden), R.drawable.golden, getString(R.string.about_golden), getString(R.string.golden)));

        //using the custom adapter created for places
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places, R.color.hotel);

        //using listview to show the places. linking it to the list xml
        ListView listView = rootView.findViewById(R.id.list);

        //setting the listview to use the custom adapter
        listView.setAdapter(adapter);

        return rootView;
    }
}
