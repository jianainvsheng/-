package com.lesports.recycle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.lesports.recycle.ViewException.NotViewAction;
import com.lesports.recycle.viewaction.BaseChildAction;

/**
 * Created by yangjian on 2017/5/26.
 */

public class ParentScrollView extends ViewGroup {

    /**
     * 头部的View
     */
    private ViewGroup mTopView;

    /**
     * 中间的view
     */
    private ViewGroup mCenterView;

    /**
     * 底部的view
     */
    private ViewGroup mBottomView;

    private Scroller mScroller;

    private float mScrollerY;//一共移动的坐标
    private float mLastY;//记录上次移动的坐标
    private float downY;// 记录点击下的坐标

    public ParentScrollView(Context context) {
        this(context,null);
    }

    public ParentScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ParentScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mScroller = new Scroller(getContext());
    }


    public void setTopView(ViewGroup topView){

        if(getChildCount() > -1){

            try {
                AddToView(topView,0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCenterView(ViewGroup topView){

        if(getChildCount() > 0){

            try {
                AddToView(topView,1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        if(event.getPointerCount() > 1 || !mScroller.isFinished()){

            event.setAction(MotionEvent.ACTION_CANCEL);
        }
        float y = event.getY();
        mScrollerY = getScrollY();
        switch (event.getActionMasked()){

            case MotionEvent.ACTION_DOWN:
                downY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaY = y - mLastY;
                float newScrollY = mScrollerY - deltaY;
                if(newScrollY > getChildAt(0).getMeasuredHeight()){
                    newScrollY = getChildAt(0).getMeasuredHeight();
                }else if(newScrollY < 0){
                    newScrollY = 0;
                }

                BaseChildAction action = (BaseChildAction) getChildAt(2);
                Log.d("ParentSrollview"," **************start************");
                Log.d("ParentSrollview"," mScrollerY: " + mScrollerY);
                Log.d("ParentSrollview"," downY: " + downY);
                Log.d("ParentSrollview"," getY(): " + event.getY());
                Log.d("ParentSrollview"," newScrollY: " + newScrollY);
                Log.d("ParentSrollview"," Height(): " + getChildAt(0).getMeasuredHeight());
                Log.d("ParentSrollview"," **************end************");
                if(mScrollerY == getChildAt(0).getMeasuredHeight()){
                    Log.d("ParentSrollview", " action");
                    this.scrollTo(0, getChildAt(0).getMeasuredHeight());
                    //控件活动到了顶部最大距离
                    if (!action.isScrollTop()) {
                        Log.d("ParentSrollview", " isScrollTop: ");
                        mLastY = y;
                        return super.dispatchTouchEvent(event);
                    }
                }
                this.scrollTo(0, (int)newScrollY);
                break;
        }

        mLastY = y;
        super.dispatchTouchEvent(event);
        return true;
    }

    public void setBottomView(ViewGroup bottomView){

        if(getChildCount() > 1){

            try {
                AddToView(bottomView,2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 添加view
     * @param view
     * @return
     * @throws Exception
     */
    private boolean AddToView(ViewGroup view,int index) throws Exception {

        if(view == null){

            throw new NullPointerException("设置的view为空");
        }else{

           if(!(view instanceof BaseChildAction)) {
               throw new NotViewAction();
           }else{
               if(this.getChildCount() > 3){
                   throw new NotViewAction("添加的view大于三个了");
               }else{

                   this.addView(view,index);
                   return true;
               }
           }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heiht = 0;
        for(int i = 0 ; i < getChildCount() ; i ++){

            if(i == getChildCount() - 1 && getChildCount() == 3){
                getChildAt(i).measure(widthMeasureSpec,heightMeasureSpec);
                heiht = heiht + getMeasuredHeight() - getChildAt(i - 1).getMeasuredHeight();
            }else{
                getChildAt(i).measure(widthMeasureSpec,0);
                heiht = heiht + getChildAt(i).getMeasuredHeight();
            }

        }
        this.setMeasuredDimension(widthMeasureSpec,heiht);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        Log.i("parentView","onLayout");
        int top = 0;
        for(int i = 0 ; i < getChildCount() ; i ++){

            View view = getChildAt(i);
            if(i == 2){

                view.layout(0,top,getMeasuredWidth(),
                        top + view.getMeasuredHeight());
            }else{
                view.layout(0,top,getMeasuredWidth(),
                        top + view.getMeasuredHeight());
            }

            top = top + view.getMeasuredHeight();
        }
    }
}
