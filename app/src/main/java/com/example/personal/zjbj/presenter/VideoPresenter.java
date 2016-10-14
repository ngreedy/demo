package com.example.personal.zjbj.presenter;

import android.util.Log;
import android.view.View;

import com.example.personal.zjbj.Constants;
import com.example.personal.zjbj.bean.Anime;
import com.example.personal.zjbj.bean.Videos;
import com.example.personal.zjbj.model.VideoModel;
import com.example.personal.zjbj.view.fragment.VideoFragment;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by aersas on 2016/10/7.
 */
public class VideoPresenter {
    private  VideoModel videoModel;
    private VideoFragment mFragment;

    public VideoPresenter(View view){
    }

    public VideoPresenter(VideoFragment videoFragment) {
        mFragment = videoFragment;
        videoModel = new VideoModel();
    }


    public void getVideos(Map<String,String> params){
        videoModel.loadVideoInfo(Constants.AT_URL, params, new Callback<Videos>() {
            @Override
            public void onResponse(Response<Videos> response, Retrofit retrofit) {
                Log.d("Video", "onResponse: " + response);
                List<Anime> list=  response.body().data.list.anime;
                mFragment.loadVideo(list);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Video", "onResponse: " );
            }
        });
    }
}
