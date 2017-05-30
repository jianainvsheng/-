package com.lesports.recycle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.lesports.recycle.viewaction.BaseChildAction;

/**
 * Created by yangjian on 2017/5/26.
 */

public class TopScrollView extends ScrollView implements BaseChildAction{

    /**
     * 添加view的布局
     */
    private RelativeLayout mLayout;

    public TopScrollView(Context context) {
        this(context,null);
    }

    public TopScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    private void initLayout(){

        mLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        mLayout.setLayoutParams(params);
        addView(mLayout);
    }

    public void addViewToLayout(View view){

        if(mLayout == null){

            throw new NullPointerException("layout is null");
        }
        mLayout.addView(view);
    }

    public void removeAll(){

        if(mLayout == null){

            throw new NullPointerException("layout is null");
        }
        mLayout.removeAllViews();
    }

    public void remove(View view){

        if(mLayout == null){

            throw new NullPointerException("layout is null");
        }
        mLayout.removeView(view);
    }

    @Override
    public boolean isScrollBottom() {
        return false;
    }

    @Override
    public boolean isScrollTop() {
        return false;
    }
}
