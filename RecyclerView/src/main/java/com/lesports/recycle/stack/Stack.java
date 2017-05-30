package com.lesports.recycle.stack;

/**
 * Created by yangjian on 2017/5/11.
 */

public interface  Stack <T>{

    /**
     * 添加元素
     * @param t
     */
    public void add(T t);


    /**
     * 获取栈顶元素 但是不移除栈
     * @return
     */
    public T peek();


    /**
     * 获取栈顶元素，移除出栈
     * @return
     */
    public T pop();
}
