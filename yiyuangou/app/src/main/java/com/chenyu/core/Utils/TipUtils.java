package com.chenyu.core.Utils;

import android.widget.Toast;

import com.chenyu.core.App.App;

/**
 * Created by Chenyu on 2016/1/4.
 */
public class TipUtils {

    public static void showTip(String msg){
        Toast.makeText(App.getContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
