package com.lesports.recycle.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lesports.recycle.viewaction.BaseChildAction;

/**
 * Created by yangjian on 2017/5/26.
 */

public class BottomRecycleView extends RecyclerView implements BaseChildAction {

    public BottomRecycleView(Context context) {
        this(context, null);
    }

    public BottomRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout();
    }

    private void initLayout() {

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(params);
        setBackgroundColor(Color.GRAY);
    }


    @Override
    public boolean isScrollBottom() {
        return false;
    }

    @Override
    public boolean isScrollTop() {

        LinearLayoutManager manager = (LinearLayoutManager) getLayoutManager();
        if (manager.findFirstVisibleItemPosition() == 0) {
            Log.d("BottomRecycleView", "topVisitionItem : " + manager.findFirstVisibleItemPosition());
            View view = getChildAt(manager.findFirstVisibleItemPosition());
            Log.d("BottomRecycleView", "topVisitionItem  Y : " + view.getY());
            Log.d("BottomRecycleView", "topVisitionItem  height : " + view.getMeasuredHeight());
            Log.d("BottomRecycleView", "topVisitionItem  top : " + view.getTop());
            Log.d("BottomRecycleView", "topVisitionItem  bottom : " + view.getBottom());
            RecyclerView.LayoutParams params = (LayoutParams) view.getLayoutParams();
            Log.d("BottomRecycleView", "topVisitionItem  padding : " + params.topMargin);
            if (view.getTop() == params.topMargin)
                return true;
        }
        return false;
    }
}
