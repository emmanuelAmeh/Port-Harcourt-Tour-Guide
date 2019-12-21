package com.example.android.tourguideapp;

/**
 * Fragment to handle companies list
 * Sources: https://bpe.gov.ng/eleme-petrochemical-limited/, wikipedia, companies websites
 */
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompaniesFragment extends Fragment {

    public CompaniesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //creating and inflating View
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //adding companies
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.nlng), R.drawable.nlng, getString(R.string.about_nlng), getString(R.string.web_presidential)));
        places.add(new Place(getString(R.string.phrc), R.drawable.phrc, getString(R.string.about_phrc), getString(R.string.web_presidential)));
        places.add(new Place(getString(R.string.shell), R.drawable.shell, getString(R.string.about_shell), getString(R.string.web_presidential)));
        places.add(new Place(getString(R.string.epcl), R.drawable.epcl, getString(R.string.about_epcl), getString(R.string.web_presidential)));

        //using the custom adapter created for places
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places, R.color.company);

        //using listview to show the places. linking it to the list xml
        ListView listView = rootView.findViewById(R.id.list);

        //setting the listview to use the custom adapter
        listView.setAdapter(adapter);

        return rootView;
    }

}
