package com.example.bdfinance.adaptar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private static List<Fragment> fragmentList=new ArrayList<>();
    private static List<String> tabTitle=new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void addFragment(Fragment fragment,String title)
    {
        fragmentList.add(fragment);
        tabTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }
}
