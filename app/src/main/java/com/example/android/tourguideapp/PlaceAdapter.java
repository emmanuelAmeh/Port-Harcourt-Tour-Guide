package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /** Resource ID for the background color for this list of places */
    private int mColorResourceId;

    public PlaceAdapter(@NonNull Context context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }

        //Get current place
        final Place places = getItem(position);

        //finding views in list item layout
        TextView tvName = listItemView.findViewById(R.id.tv_name);
        ImageView googleMap = listItemView.findViewById(R.id.iv_google_map);
        TextView tvAboutLocation = listItemView.findViewById(R.id.tv_about_location);
        TextView tvWebResource = listItemView.findViewById(R.id.web_resource);

        //setting view values
        tvName.setText(places.getName());
        tvAboutLocation.setText(places.getAboutLocation());
        //To prevent error in lower android versions that dont support this feature
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tvAboutLocation.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        tvWebResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(places.getWebResource());
            }
        });

        // Check if an image is provided for this place or not
        if (places.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            googleMap.setImageResource(places.getPicture());
            // Make sure the view is visible
            googleMap.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            googleMap.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View itemContainer = listItemView.findViewById(R.id.item_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        itemContainer.setBackgroundColor(color);

        return listItemView;
    }

    public void openWebPage(String url) {
        if(url == null){
            return;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            getContext().startActivity(intent);
        }else{
            Toast.makeText(getContext(), "No Web Browser App installed. Please visit GooglePlay Store to get one. Thanks.", Toast.LENGTH_SHORT).show();
        }
    }
}
