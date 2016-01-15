package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

/**
 * Created by ChenYu
 * 功能：注册时，设置密码页面
 */
public class SettingPswAct extends BasicAct {
    public SettingPswAct(){
        super(R.layout.act_setting_psw,R.string.act_setting_psw_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,SettingPswAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }
}
