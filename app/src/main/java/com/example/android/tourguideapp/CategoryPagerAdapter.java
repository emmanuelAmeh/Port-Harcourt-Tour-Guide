package com.example.android.tourguideapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Context;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    private  Context mContext;

    public CategoryPagerAdapter(@NonNull Context context, FragmentManager fm, int behavior) {
        super(fm, behavior);
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantsFragment();
        } else if (position == 1) {
            return new ChurchesFragment();
        } else if (position == 2) {
            return new CompaniesFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_restaurant);
        } else if (position == 1) {
            return mContext.getString(R.string.category_churches);
        } else if (position == 2) {
            return mContext.getString(R.string.category_companies);
        } else {
            return mContext.getString(R.string.category_hotel);
        }
    }
}
