package com.example.personal.zjbj.util;

import android.app.Activity;

import java.util.Stack;

/**
 *
 * Created by aersas on 2016/10/4.
 */
public class AppManager {

    private static Stack<Activity> stacks;
    private static AppManager instance;

    private AppManager(){
    }

    public static synchronized AppManager getInstance(){
        if (null==instance){
            instance=new AppManager();
        }

        return instance;
    }

    public void addActivity(Activity activity){
        if (null==stacks){
            stacks=new Stack<>();
        }
        stacks.add(activity);
    }

    public void finishActivity(Activity activity) {
        if (null!=stacks&&activity != null) {
            stacks.remove(activity);
            activity.finish();
        }
    }

    public Activity currentActibity(){
        if (stacks!=null){
            return stacks.lastElement();
        }
        return null;
    }

    public void finishAll(){
        int size =stacks.size();
        if (null!=stacks){
            for (int i =0;i<size;i++){
                stacks.get(i).finish();
            }
        }
        stacks.clear();
    }
}
