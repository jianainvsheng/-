package com.lesports.recycle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yangjian on 2017/5/12.
 */

public class PathView extends View {

    private Paint mPaint;

    private Path mPath;

    private final int count = 3;

    private final int countWidth = 100;

    private boolean isLoop = true;

    private Handler handler = new Handler();

    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        looperDraw(canvas);
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(3);
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    private void looperDraw(Canvas canvas){

        int widht = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size = (widht - (countWidth) * count)/count;
        canvas.drawLine(0,height/2,widht, height/2,mPaint);
        mPath.moveTo(0,height/2);
        for(int i = 0 ; i < count ; i ++){
            mPath.lineTo(size * (i + 1), height/2);
            mPath.lineTo(size * (i + 1) + countWidth /2, height/2 + 100);
            mPath.lineTo(size * (i + 1) + countWidth, height/2);
        }
        canvas.drawPath(mPath,mPaint);
    }
}
