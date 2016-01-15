package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

import butterknife.OnClick;

/**
 * Created by ChenYu
 * 功能：身份验证界面
 */
public class ForgiveIdentifyCheckAct extends BasicAct{
    public ForgiveIdentifyCheckAct(){
        super(R.layout.act_forgive_identify_check,R.string.act_signin_identify_check_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,ForgiveIdentifyCheckAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.act_identify_btn_next)
    public void settingNewPsw(){
        SettingNewPswAct.startActivity(ForgiveIdentifyCheckAct.this);
    }
}