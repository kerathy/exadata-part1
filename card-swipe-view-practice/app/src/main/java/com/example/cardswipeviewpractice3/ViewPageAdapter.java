package com.example.cardswipeviewpractice3;

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
            return new Item1();
        } else if (position == 1) {
            return new Item2();
        } else if (position == 2) {
            return new Item3();
        } else if (position == 3) {
            return new Item4();
        } else if (position == 4) {
            return new Item5();
        } else {
            return new Item6();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "--";
    }

}
