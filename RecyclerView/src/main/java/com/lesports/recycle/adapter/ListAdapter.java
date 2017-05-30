package com.lesports.recycle.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lesports.recycle.viewholder.DemoHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 2017/5/26.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;

    private List<String> mData;

    public ListAdapter(Context mContext){

        this.mContext = mContext;
        this.mData = new ArrayList<>();
    }

    public ListAdapter(Context mContext,List<String> mData){

        this(mContext);
        this.mData.addAll(mData);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DemoHolder holder = null;
        if(convertView != null){

            holder = (DemoHolder) convertView.getTag();
        }else{

        }
        return null;
    }
}
