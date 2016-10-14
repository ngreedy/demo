package com.example.personal.zjbj;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by aersas on 2016/10/4.
 */
public class EssayApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
