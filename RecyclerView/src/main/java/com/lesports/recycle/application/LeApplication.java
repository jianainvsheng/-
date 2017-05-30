package com.lesports.recycle.application;

import android.app.Application;

/**
 * Created by yangjian on 2017/5/26.
 */

public class LeApplication extends Application {

    private static LeApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    synchronized public static LeApplication getAppLication() {

        if (sApp == null) {
            throw new NullPointerException("sApp is null!");
        }
        return sApp;
    }
}
