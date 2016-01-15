package com.chenyu.core.controller;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Chenyu on 2016/1/4.
 */
public class BasicItemLongClickListener implements View.OnLongClickListener{

    private AdapterView.OnItemLongClickListener onItemLongClickListener;

    private BasicHolder basicHolder;

    public BasicItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener,BasicHolder basicHolder){
        this.onItemLongClickListener = onItemLongClickListener;
        this.basicHolder = basicHolder;
    }

    @Override
    public boolean onLongClick(View v) {
        return this.onItemLongClickListener.onItemLongClick(null,v,basicHolder.getPosition(),basicHolder.getItemId());
    }
}
