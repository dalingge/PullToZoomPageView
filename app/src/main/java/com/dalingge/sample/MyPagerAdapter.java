package com.dalingge.sample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * FileName: PagerAdapter.java
 * description:
 * Author: dingby(445850053@qq.com)
 * Date: 2016/4/14
 */
public class MyPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<View> views;

    public MyPagerAdapter(Context context, ArrayList<View> views) {
        this.context=context;
        this.views=views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
