package com.chenyu.core.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ChenYu on 2016/1/1.
 */
public abstract class BasicFrg extends Fragment{
    public Context context;
    public int layoutId;
    public View view;

    public BasicFrg(int layoutId){
        this.layoutId = layoutId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(layoutId,null);
        context = getContext();
        ButterKnife.bind(this,view);
        initView(view);
        return view;
    }

    public abstract void initView(View view);
}
