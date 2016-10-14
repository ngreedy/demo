package com.example.personal.zjbj.model;


import com.example.personal.zjbj.bean.Videos;
import com.example.personal.zjbj.network.NetService;

import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by aersas on 2016/10/7.
 */
public class BaseModel {

    public void loadVideoInfo(String url,Map<String,String> params, Callback<Videos> callback){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        NetService netService = retrofit.create(NetService.class);
        Call<Videos> call = netService.repoATVideos(params.get("api_key"), params.get("timestamp"), params.get("page"), params.get("access_token"));
        call.enqueue(callback);
    }
}
