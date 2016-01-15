package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;
import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

/**
 * Created by ChenYu
 * 功能：个人中心的设置页面
 */
public class PersonalCenterSettingAct extends BasicAct {
    public PersonalCenterSettingAct(){
        super(R.layout.act_personal_center_setting,R.string.act_personal_center_setting);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,PersonalCenterSettingAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }
}