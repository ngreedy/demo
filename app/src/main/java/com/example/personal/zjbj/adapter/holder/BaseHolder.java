package com.example.personal.zjbj.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by aersas on 2016/10/12.
 */
public class BaseHolder<T> extends RecyclerView.ViewHolder{
    private T data;
    private View mView;
    public BaseHolder(View itemView)
    {
        super(itemView);
        mView=itemView;
        ButterKnife.bind(this,mView);
        init();
    }

    protected void init() {

    }

    public void setData(T data) {
        this.data = data;
    }

    public View getView(){
        return mView;
    }


}
