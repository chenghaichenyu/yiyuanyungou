package com.chenyu.yiyuangou.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chenyu.R;

/**
 * Created by ChenYu on 2016/1/14.
 * 功能：自定义View，主要用于“我的云购”-->“设置”界面的item设置上
 */
public class SettingView extends LinearLayout {

    private TextView textName;
    private TextView subTextName;

    private View viewTopLineFull;
    private View viewBottomLineFull;

    private ImageView image;

    public SettingView(Context context){
        super(context);
        init(context,null);
    }

    public SettingView(Context context,AttributeSet attrs){
        super(context);
        init(context,attrs);
    }

    /**
     * 初始化SettingView
     * @param context
     * @param attrs
     */
    public void init(Context context,AttributeSet attrs){

        initView(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.SettingView);

        boolean showViewTopLineFull = false;
        boolean showViewBottomLineFull = false;

        if(typedArray.hasValue(R.styleable.SettingView_show_view_top_full)){
            showViewTopLineFull = typedArray.getBoolean(R.styleable.SettingView_show_view_top_full,false);
        }

        if(typedArray.hasValue(R.styleable.SettingView_show_view_bottom_full)){
            showViewBottomLineFull = typedArray.getBoolean(R.styleable.SettingView_show_view_bottom_full,false);
        }

        if(typedArray.hasValue(R.styleable.SettingView_image_src)){
            int imageId = typedArray.getResourceId(R.styleable.SettingView_image_src,0);
            image.setImageResource(imageId);
            image.setVisibility(VISIBLE);
        }else{
            image.setVisibility(GONE);
        }

        if(showViewTopLineFull){
            viewTopLineFull.setVisibility(VISIBLE);
        }else{
            viewTopLineFull.setVisibility(GONE);
        }

        if(showViewBottomLineFull){
            viewBottomLineFull.setVisibility(VISIBLE);
        }else{
            viewBottomLineFull.setVisibility(GONE);
        }

        textName.setText(typedArray.getString(R.styleable.SettingView_text));
        subTextName.setText(typedArray.getString(R.styleable.SettingView_sub_text));

    }

    /**
     * 绑定组件
     * @param context
     */
    public void initView(Context context){
        View view = View.inflate(context, R.layout.c_setting_view,this);
        textName = (TextView)view.findViewById(R.id.item_setting_text);
        subTextName = (TextView)view.findViewById(R.id.item_setting_sub_text);
        viewTopLineFull = (View)view.findViewById(R.id.view_top_line_full);
        viewBottomLineFull = (View)view.findViewById(R.id.view_bottom_line_full);
        image = (ImageView)view.findViewById(R.id.item_setting_image);
    }

}
