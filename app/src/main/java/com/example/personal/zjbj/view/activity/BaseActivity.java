package com.example.personal.zjbj.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.personal.zjbj.R;
import com.example.personal.zjbj.util.AppManager;

/**
 * Created by aersas on 2016/10/4.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        AppManager.getInstance().addActivity(this);

    }

    @Override
    protected void onDestroy() {
        AppManager.getInstance().finishActivity(this);
        super.onDestroy();
    }

    protected <T extends View>T getView(int id){
        try {
            return (T)findViewById(id);
        } catch (Exception e) {
            Log.e("findView", "getView: type error!");
            e.printStackTrace();
            return null;
        }
    }

    public Toolbar getToolBar(){
        Toolbar toolbar = getView(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }
}
