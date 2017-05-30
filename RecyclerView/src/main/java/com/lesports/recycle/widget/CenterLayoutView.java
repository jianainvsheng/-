package com.lesports.recycle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.lesports.recycle.viewaction.BaseChildAction;

/**
 * Created by yangjian on 2017/5/26.
 */

public class CenterLayoutView extends RelativeLayout implements BaseChildAction{

    public CenterLayoutView(Context context) {
        this(context,null);
    }

    public CenterLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CenterLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    private void initLayout(){

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(params);
    }
    @Override
    public boolean isScrollBottom() {

        return false;
    }

    @Override
    public boolean isScrollTop() {
        if(getTop() == 0){

            return true;
        }
        return false;
    }
}
