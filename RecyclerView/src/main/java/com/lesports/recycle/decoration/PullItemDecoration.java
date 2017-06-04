package com.lesports.recycle.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yangjian on 2017/6/4.
 */

public class PullItemDecoration extends RecyclerView.ItemDecoration{

    private int offectSize;
    public PullItemDecoration(int offectSize){

        this.offectSize = offectSize;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super.getItemOffsets(outRect, view, parent, state);

        outRect.left = offectSize;
        outRect.right = offectSize;
        outRect.bottom = offectSize;
        if(parent.getChildLayoutPosition(view) == 0 ){

            outRect.top = offectSize;
        }
    }
}
