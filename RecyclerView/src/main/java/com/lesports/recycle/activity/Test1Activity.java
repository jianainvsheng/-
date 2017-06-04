package com.lesports.recycle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.lesports.recycle.R;
import com.lesports.recycle.adapter.RecyclerAdapter;
import com.lesports.recycle.decoration.SelectorItemDecoration;
import com.lesports.recycle.widget.BottomRecycleView;
import com.lesports.recycle.widget.CenterLayoutView;
import com.lesports.recycle.widget.ParentScrollView;
import com.lesports.recycle.widget.TopScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 2017/5/26.
 */

public class Test1Activity extends Activity{


    private ParentScrollView mParentView;

    private TopScrollView mTopView;

    private CenterLayoutView mCenterView;

    private BottomRecycleView mBottomView;

    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        mParentView = (ParentScrollView) this.findViewById(R.id.parent_view);
        mTopView = new TopScrollView(this);
        mCenterView = new CenterLayoutView(this);
        mBottomView = new BottomRecycleView(this);
        mParentView.setTopView(mTopView);
        mParentView.setCenterView(mCenterView);
        mAdapter = new RecyclerAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mBottomView.setLayoutManager(manager);
        mBottomView.addItemDecoration(new SelectorItemDecoration(15));
        mBottomView.setAdapter(mAdapter);
        mParentView.setBottomView(mBottomView);
        init();
    }

    private void init(){

        //初始化顶部
        View view = LayoutInflater.from(this).inflate(R.layout.top_layout,null);
        mTopView.addViewToLayout(view);

        //初始化中间部分
        View centerView = LayoutInflater.from(this).inflate(R.layout.center_layout,null);
        mCenterView.addView(centerView);

        //初始化底部部分
        List<String> data = new ArrayList<>();
        for(int i = 0 ; i < 40 ; i ++){

            data.add("你好 ： "+ i );
        }
        mAdapter.setData(data);
    }
}
