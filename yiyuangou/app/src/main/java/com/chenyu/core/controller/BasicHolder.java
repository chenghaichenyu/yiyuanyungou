package com.chenyu.core.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Chenyu on 2016/1/4.
 */
public class BasicHolder extends RecyclerView.ViewHolder{

    public View itemView;
    public ViewHolder viewHolder;

    public ViewHolder getViewHolder(){
        return viewHolder;
    }
    public BasicHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemView = itemView;
        viewHolder = ViewHolder.getViewHolder(itemView);
    }
}
