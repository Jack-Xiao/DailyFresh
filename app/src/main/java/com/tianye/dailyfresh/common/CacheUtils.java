package com.tianye.dailyfresh.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;

/**
 * Created by lenovo on 2015/3/23.
 */
public class CacheUtils {

    public static File getExternalCacheDir(final Context context){
        if(hasExternalCacheDir()){
            return context.getExternalCacheDir();
        }
        //Before Froyo we need to construct the extrnal cache dir ourselves
        final String cacheDir = "/Android/data/" + context.getPackageName() + "/catche/";
        return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
    }
    public static boolean hasExternalCacheDir(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }
}
