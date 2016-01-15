package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

import butterknife.OnClick;

/**
 * Created by ChenYu
 * 功能：忘记密码页面
 */
public class ForgivePswAct extends BasicAct{

    public ForgivePswAct(){
        super(R.layout.act_forgive_psw,R.string.act_forgive_psw_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,ForgivePswAct.class);
        context.startActivity(intent);
    }
    @Override
    public void initView() {

    }

    @OnClick(R.id.act_forgive_psw_btn)
    public void identifyCheck(){
        ForgiveIdentifyCheckAct.startActivity(ForgivePswAct.this);
    }
}