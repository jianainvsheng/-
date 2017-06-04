package com.lesports.recycle.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesports.recycle.R;
import com.lesports.recycle.viewholder.DemoHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 2017/5/7.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<DemoHolder> {

    private Context mContext;

    private List<String> mData;

    public RecyclerAdapter(Context mContext){

        this.mContext = mContext;
        this.mData = new ArrayList<>();
    }

    public RecyclerAdapter(Context mContext,List<String> mData){

        this(mContext);
        this.mData.addAll(mData);
    }

    public void setData(List<String> mData){

        if(mData == null || mData.size() <= 0)
            return;
        this.mData.clear();
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }
    @Override
    public DemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View baseView = LayoutInflater.from(mContext).inflate(R.layout.demo_recycle_item,parent,false);
//        baseView.setFocusable(true);
//        baseView.setFocusableInTouchMode(true);
        DemoHolder demoHolder = new DemoHolder(baseView);
        return demoHolder;
    }

    @Override
    public void onBindViewHolder(DemoHolder holder, int position) {

        String mText = mData.get(position);
        holder.getmDemoText().setText(mText);

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
