package com.lesports.recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lesports.recycle.adapter.RecyclerAdapter;
import com.lesports.recycle.application.LeApplication;
import com.lesports.recycle.stack.BaseStack;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) this.findViewById(R.id.demo_recycler);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        mAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(mAdapter);
        initData(100);
        //测试
        BaseStack<String> baseStack1 = new BaseStack<>();
        for(int i = 0 ; i < 5 ; i++){

            baseStack1.add("你好" + i);
        }

        int size = baseStack1.getLength();
        for(int i = 0 ; i < size; i++){

            String str = baseStack1.pop();
            Log.i("main","str : " + str);
        }


    }

    public void initData(int size){

        List<String> data = new ArrayList<>();
        for(int i = 0 ; i < size ; i ++){

            data.add("你好 ： "+ i );
        }
        mAdapter.setData(data);
    }
}
