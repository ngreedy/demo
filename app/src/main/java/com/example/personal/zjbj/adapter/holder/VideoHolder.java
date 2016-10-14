package com.example.personal.zjbj.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.example.personal.zjbj.R;
import com.example.personal.zjbj.bean.Anime;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;

/**
 * Created by aersas on 2016/10/12.
 */
public class VideoHolder extends BaseHolder<Anime> {
    @Bind(R.id.iv_pic)
    SimpleDraweeView simpleDraweeView;

    @Bind(R.id.tv_title)
    TextView title;

    public VideoHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Anime data) {
        super.setData(data);
        title.setText(data.getVideoTitle());
        simpleDraweeView.setImageURI(data.getVideoThumbnail());
//        PipelineDraweeControllerBuilder draweeControllerBuilder = Fresco.newDraweeControllerBuilder();
//        draweeControllerBuilder.setUri(data.getVideoThumbnail());
    }

    @Override
    protected void init() {
        super.init();
    }
}
