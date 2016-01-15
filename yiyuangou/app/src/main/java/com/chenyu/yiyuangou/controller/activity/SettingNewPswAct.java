package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

public class SettingNewPswAct extends BasicAct{
    public SettingNewPswAct(){
        super(R.layout.act_setting_new_psw,R.string.act_setting_new_psw_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,SettingNewPswAct.class);
        context.startActivity(intent);
    }
    @Override
    public void initView() {

    }
}
