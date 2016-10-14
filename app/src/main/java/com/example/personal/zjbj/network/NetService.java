package com.example.personal.zjbj.network;

import com.example.personal.zjbj.bean.Videos;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by aersas on 2016/10/7.
 */
public interface NetService  {
    /**
     * 加载AT资源
     *
     * @param api_key
     * @param timestamp
     * @param page
     * @param access_token
     * @return
     */
    @GET("animelist_v4")
    Call<Videos> repoATVideos(
            @Query("api_key") String api_key,
            @Query("timestamp") String timestamp,
            @Query("page") String page,
            @Query("access_token") String access_token);
}
