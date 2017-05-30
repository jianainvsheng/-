package com.lesports.recycle.viewaction;

/**
 * Created by yangjian on 2017/5/25.
 */

public interface BaseChildAction  {

    /**
     * childView 是否已经滑动到底部
     * @return
     */
    public boolean isScrollBottom();

    /**
     * childView 是否已经滑动到顶部
     * @return
     */
    public boolean isScrollTop();
}
