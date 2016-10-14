package com.example.personal.zjbj.view.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.personal.zjbj.R;
import com.example.personal.zjbj.adapter.RecycleViewAdapter;
import com.example.personal.zjbj.adapter.holder.VideoHolder;
import com.example.personal.zjbj.bean.Anime;
import com.example.personal.zjbj.presenter.VideoPresenter;
import com.example.personal.zjbj.util.MD5Utils;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by aersas on 2016/10/6.
 */
public class VideoFragment extends BaseFragment{

    @Override
    public int getContentLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VideoPresenter presenter=new VideoPresenter(this);
        TreeMap<String,String> params=new TreeMap();
        params.put("api_key", "android");
        params.put("timestamp", String.valueOf(SystemClock.currentThreadTimeMillis()));
        params.put("page", String.valueOf(1));
        String str = MD5Utils.getAccessToken(params);
        params.put("access_token", str);
        presenter.getVideos(params);
    }

    public void loadVideo(List<Anime> videos) {
        RecyclerView recyclerView=getContentView(R.id.video_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecycleViewAdapter adapter=new RecycleViewAdapter(videos,R.layout.video_item,VideoHolder.class);
        recyclerView.setAdapter(adapter);

    }

}
