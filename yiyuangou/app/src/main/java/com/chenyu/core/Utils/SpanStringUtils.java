package com.chenyu.core.Utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;

/**
 * Created by ChenYu on 2016/1/12.
 */
public class SpanStringUtils {

    public static int start;
    public static int end;

    /**
     * 将传入的字符串中的某一部分转化为高亮
     * @param color 高亮的颜色
     * @param message 传入的字符串
     * @param hightValues 欲高亮的字符串
     * @return
     */
    public static SpannableString getHightLightText(int color,String message,String hightValues){
        if(TextUtils.isEmpty(message)){
            return null;
        }
        if(TextUtils.isEmpty(hightValues)){
            return null;
        }
        start = message.indexOf(hightValues);
        end = hightValues.length() + start;

        start = start > 0 ? start : 0 ;
        end = end < message.length() ? end : message.length() ;
        SpannableString spannableString = new SpannableString(message);
        spannableString.setSpan(new ForegroundColorSpan(color),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    public static CharSequence getHightLightTextClickable(int color,String message,String hightValues){
        if(TextUtils.isEmpty(message)){
            return "";
        }
        if(TextUtils.isEmpty(hightValues)){
            return "";
        }
        start = message.indexOf(hightValues);
        end = hightValues.length() + start;

        start = start > 0 ? start : 0 ;
        end = end < message.length() ? end : message.length() ;
        SpannableString spannableString = new SpannableString(message);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                TipUtils.showTip("您点击了用户协议");
            }
        },start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }


}
