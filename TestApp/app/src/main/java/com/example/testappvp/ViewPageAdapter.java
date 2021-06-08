package com.example.testappvp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AlgorithmFragment();
        } else if (position == 1) {
            return new CourseFragment();
        } else {
            return new LoginFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Shows";
        } else if (position == 1) {
            title = "Movies";
        } else {
            title = "Comedy";
        }
        return title;
    }
}


