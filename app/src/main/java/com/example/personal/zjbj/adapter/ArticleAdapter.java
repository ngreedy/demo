package com.example.personal.zjbj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.personal.zjbj.view.fragment.ArticleFragment;

import java.util.List;

public class ArticleAdapter extends FragmentStatePagerAdapter {

    public ArticleAdapter(FragmentManager fm, List<String> strings) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new ArticleFragment();
    }

    @Override
    public int getCount() {
        return 0;
    }
}
