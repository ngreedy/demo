package com.example.personal.zjbj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aersas on 2016/10/4.
 */
public class BaseFragment extends Fragment {
    int mType;
    private View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView!=null){
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        }else {
            mView = inflater.inflate(getContentLayout(),container,false);
        }

        return mView;
    }

    @Nullable
    @Override
    public View getView() {
        return mView;
    }

    public void setType(int type){
        mType=type;
    }

    public  int getContentLayout(){
        return 0;
    }

    public <T extends View>T getContentView(int id){
        try {
            return (T)mView.findViewById(id);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

}
