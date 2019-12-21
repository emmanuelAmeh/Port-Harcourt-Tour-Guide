package com.example.android.tourguideapp;

public class Place {

    //declaring member variables
    private String mName;
    private int mPicture;
    private String mAboutLocation;
    private String mWebResource;

    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Place(String name, int picture, String aboutLocation, String webResource) {
        mName = name;
        mPicture = picture;
        mAboutLocation = aboutLocation;
        mWebResource = webResource;
    }

    //setting getters
    public String getName() {
        return mName;
    }

    public int getPicture() {
        return mPicture;
    }

    public String getAboutLocation() {
        return mAboutLocation;
    }

    public String getWebResource() {
        return mWebResource;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mPicture != NO_IMAGE_PROVIDED;
    }
}
