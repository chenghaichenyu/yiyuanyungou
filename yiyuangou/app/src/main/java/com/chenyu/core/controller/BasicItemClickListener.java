package com.chenyu.core.controller;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Chenyu on 2016/1/4.
 */
public class BasicItemClickListener implements View.OnClickListener{

    private AdapterView.OnItemClickListener onItemClickListener;
    private BasicHolder basicHolder;

    public BasicItemClickListener(AdapterView.OnItemClickListener onItemClickListener,BasicHolder basicHolder){
        this.onItemClickListener = onItemClickListener;
        this.basicHolder = basicHolder;
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(null,v,basicHolder.getPosition(),basicHolder.getItemId());
    }
}
