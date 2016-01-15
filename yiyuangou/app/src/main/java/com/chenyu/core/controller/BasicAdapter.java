package com.chenyu.core.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import java.util.List;
/**
 * Created by Chenyu on 2016/1/4.
 */
public abstract class BasicAdapter extends RecyclerView.Adapter<BasicHolder>{

    /**
     * 返回的数据
     */
    private List<?> data;

    /**
     * item的布局文件
     */
    private int itemLayoutId;

    private Context context;

    private View itemView;

    private AdapterView.OnItemClickListener onItemClickListener;
    private AdapterView.OnItemLongClickListener onItemLongClickListener;

    public BasicAdapter(List<?> data,int itemLayoutId){
        this.data = data;
        this.itemLayoutId = itemLayoutId;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }


    @Override
    public BasicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        itemView = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        return new BasicHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BasicHolder holder, int position) {
        if(data == null){
            return;
        }

        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(new BasicItemClickListener(onItemClickListener,holder));
        }
        if(onItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new BasicItemLongClickListener(onItemLongClickListener,holder));
        }

        bind(holder.getViewHolder(), position);


    }

    public abstract void bind(ViewHolder viewHolder,int position);
}
