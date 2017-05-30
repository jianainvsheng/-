package com.lesports.recycle.stack;

import android.util.Log;

import java.util.EmptyStackException;
import java.util.logging.Logger;

/**
 * Created by yangjian on 2017/5/11.
 */

public class BaseStack<T> implements Stack<T>{

    /**
     * 栈顶的位置
     */
    private int top = -1;

    /**
     * 栈中的元素个数
     */
    private int size = 0;

    /**
     * 默认栈中十个元素初始化
     */
    private int capacity = 3;

    private T[] array;

    public BaseStack(){

        array = (T[]) new Object[capacity];
        size = array.length;
    }

    public BaseStack(int capacity){

        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        size = array.length;
    }

    @Override
    public void add(T t) {

        if(top == array.length - 1){

            capacity(capacity *2 + 1);
        }

        array[++top] = t;
    }

    private boolean isEmpty(){

        return top == -1;
    }


    protected void capacity(int capacity){

        if(capacity < size){

            Log.i("BaseStack","不用扩容");
            return;
        }

        T[] oldArray = array;
        array = (T[]) new Object[capacity];
        for(int i = 0 ; i < oldArray.length ; i ++){

            array[i] = oldArray[i];
        }
        size = array.length;
    }
    @Override
    public T peek() {

        if(isEmpty()){
            new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public T pop() {

        if(isEmpty()){
            new EmptyStackException();
        }
        T data = array[top--];
        int size = array.length;
        T[] oldArray = array;
        array = (T[]) new Object[size -1];

        for(int i = 0 ; i < array.length ; i ++){

            array[i] = oldArray[i];
        }
        return data;
    }

    public Integer getLength(){

        return top;
    }
}
