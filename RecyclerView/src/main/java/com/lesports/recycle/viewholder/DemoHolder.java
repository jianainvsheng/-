package com.lesports.recycle.viewholder;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lesports.recycle.R;
import com.lesports.recycle.activity.Test1Activity;
import com.lesports.recycle.application.LeApplication;

/**
 * Created by yangjian on 2017/5/7.
 */

public class DemoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mDemoText;

    public DemoHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.mDemoText = (TextView) itemView.findViewById(R.id.demo_item_text);
    }

    public TextView getmDemoText() {
        return mDemoText;
    }

    @Override
    public void onClick(View v) {
        Log.d("DemoHolder","onClick");
        Activity activity = (Activity) itemView.getContext();
        if(activity instanceof Test1Activity){
            return;
        }
        int position = getLayoutPosition();
        Log.d("DemoHolder","DemoHolder position : " + position);
        Intent intent = new Intent(itemView.getContext(), Test1Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        LeApplication.getAppLication().startActivity(intent);
    }
}
