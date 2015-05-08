package com.tianye.dailyfresh.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by lenovo on 2015/5/8.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext(){
        return sContext;
    }
}
