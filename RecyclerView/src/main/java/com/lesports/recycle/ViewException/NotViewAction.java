package com.lesports.recycle.ViewException;

/**
 * Created by yangjian on 2017/5/25.
 */

public class NotViewAction extends Exception{


    public NotViewAction(){

        this("添加了一个没有动作的view");
    }
    public NotViewAction(String msg){

        super(msg);
    }
}
