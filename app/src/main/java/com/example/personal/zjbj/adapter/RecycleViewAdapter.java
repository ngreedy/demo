package com.example.personal.zjbj.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.personal.zjbj.adapter.holder.BaseHolder;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by aersas on 2016/10/12.
 */
public class RecycleViewAdapter<T> extends RecyclerView.Adapter<BaseHolder<T>> {

    private final List<T> mDatas;
    private final int mLayout;
    private final Class<? extends BaseHolder<T>> mClazz;

    public RecycleViewAdapter(List<T> datas,int resLayout,Class<? extends BaseHolder<T>> clazz){
        mDatas = datas;
        mLayout=resLayout;
        mClazz = clazz;
    }


    @Override
    public BaseHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(),mLayout,null);
        try {
            Constructor<? extends BaseHolder<T>> constructor = mClazz.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.setData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
