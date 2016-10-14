package com.example.personal.zjbj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.personal.zjbj.view.fragment.VideoFragment;

import java.util.List;

/**
 * Created by aersas on 2016/10/4.
 */
public class VideoAdapter extends FragmentStatePagerAdapter {
    List<String> titles;

    public VideoAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return new VideoFragment();
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
