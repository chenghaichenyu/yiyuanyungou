package com.chenyu.core.Utils;


import com.chenyu.core.App.App;

/**
 * Created by Chenyu on 2015/12/31.
 *
 * 功能：根据资源ID，快捷获取资源
 */
public class ResUtils {
    public static String getString(int resId){
        return App.getContext().getResources().getString(resId);
    }

    public static int getColor(int resId){
        return App.getContext().getResources().getColor(resId);
    }
}
