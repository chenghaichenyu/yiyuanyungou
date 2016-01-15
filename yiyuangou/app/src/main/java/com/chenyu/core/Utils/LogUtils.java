package com.chenyu.core.Utils;

import android.util.Log;

/**
 * Created by ChenYu on 2016/1/6.
 */
public class LogUtils {
    /**
     * 定义输出日志的TAG
     */
    public static final String TAG = "Tomato";

    /**
     * Verbose级别的日志
     * @param msg
     */
    public static void v(String msg){
        Log.v(TAG,msg);
    }

    /**
     * Debug级别的日志
     * @param msg
     */
    public static void d(String msg){
        Log.d(TAG,msg);
    }

    /**
     * Info级别的日志
     * @param msg
     */
    public static void i(String msg){
        Log.i(TAG,msg);
    }

    /**
     * Warn级别的日志
     * @param msg
     */
    public static void w(String msg){
        Log.w(TAG,msg);
    }

    /**
     * Error级别的日志
     * @param msg
     */
    public static void e(String msg){
        Log.e(TAG,msg);
    }
}
