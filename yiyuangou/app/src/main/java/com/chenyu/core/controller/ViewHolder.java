package com.chenyu.core.controller;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ChenYu on 2016/1/4.
 */
public class ViewHolder {
    /**
     * 用稀疏数组存放view
     */
    private SparseArray<View> viewHolder;
    private View view;

    /**
     * 私有构造方法，初始化ViewHolder，并将其设置为view的tag
     * @param view
     */
    private ViewHolder(View view){
        this.view = view;
        viewHolder = new SparseArray<View>();
        view.setTag(viewHolder);
    }

    public static ViewHolder getViewHolder(View view){
        ViewHolder viewHolder = (ViewHolder)view.getTag();
        if(viewHolder == null){
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        return viewHolder;
    }

    /**
     * 根据资源ID查找ViewHolder中的组件，如果没有在viewholder里面，则在view里面查找并放入viewholder数组里
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T get(int id){
        View childView = viewHolder.get(id);
        if(childView == null){
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    /**
     * 根据资源ID获取TextView组件
     * @param id
     * @return
     */
    public TextView getTextView(int id){
        return get(id);
    }

    /**
     * 根据资源ID获取ImageView组件
     * @param id
     * @return
     */
    public ImageView getImageView(int id){
        return get(id);
    }

    /**
     * 根据资源ID获取Button组件
     * @param id
     * @return
     */
    public Button getButton(int id){
        return get(id);
    }
}
