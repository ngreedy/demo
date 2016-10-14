package com.example.personal.zjbj.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.personal.zjbj.R;
import com.example.personal.zjbj.adapter.ArticleAdapter;
import com.example.personal.zjbj.adapter.PhotoAdpater;
import com.example.personal.zjbj.adapter.VideoAdapter;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Arrays;

public class MainActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    MainActivity mAct;
    AccountHeader header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mAct=this;
    }

    private void initView() {
        viewPager=getView(R.id.vp);
        tabLayout=getView(R.id.tabs);
        setVideoContent();
        initSlideMenu();
    }

    private void initSlideMenu() {
        header= new AccountHeaderBuilder().withOnlyMainProfileImageVisible(true).withSelectionListEnabled(false)
                .withActivity(this).withHeightDp(230)
                .withHeaderBackground(R.mipmap.slider_bg)
                .build();

        new DrawerBuilder()
                .withActivity(this)
                .withHasStableIds(true)
                .withAccountHeader(header)
                .withToolbar(getToolBar())
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("看视频").withIcon(GoogleMaterial.Icon.gmd_videocam).withSelectable(true),
                        new PrimaryDrawerItem().withName("看图片").withIcon(FontAwesome.Icon.faw_picture_o).withSelectable(true).withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700)),
                        new PrimaryDrawerItem().withName("看小说").withIcon(GoogleMaterial.Icon.gmd_text_format).withSelectable(true),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("设置").withIcon(GoogleMaterial.Icon.gmd_settings).withSelectable(false))
                                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                    @Override
                                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                        if (position == 1) {
                                            tabLayout.removeAllTabs();
                                            viewPager.removeAllViews();
                                            setVideoContent();
                                        } else if (position == 2) {
                                            tabLayout.removeAllTabs();
                                            viewPager.removeAllViews();
                                            setPhotoContent();
                                        } else if (position == 3) {
                                            tabLayout.removeAllTabs();
                                            viewPager.removeAllViews();
                                            setArticleContent();
                                        } else if (position == 5) {
                                        }
                                        return false;
                                    }
                                })
                .withShowDrawerOnFirstLaunch(true).build();
    }

    private void setArticleContent() {
        String[] titles= getResources().getStringArray(R.array.videos);
        ArticleAdapter adapter=new ArticleAdapter(getSupportFragmentManager(), Arrays.asList(titles));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setVideoContent() {
        String[] titles= getResources().getStringArray(R.array.videos);
        VideoAdapter adapter=new VideoAdapter(getSupportFragmentManager(), Arrays.asList(titles));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setPhotoContent(){
        String[] titles= getResources().getStringArray(R.array.photos);
        PhotoAdpater adapter=new PhotoAdpater(getSupportFragmentManager(), Arrays.asList(titles));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tool_games:
                startActivity(new Intent(this,GamesActivity.class));
                break;
            case R.id.tool_news:
                startActivity(new Intent(this,NewsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
