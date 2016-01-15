package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

import butterknife.OnClick;

/**
 * Created by ChenYu
 * 功能：注册时的身份验证页面
 */
public class SigninIdentifyCheckAct extends BasicAct {
    public SigninIdentifyCheckAct(){
        super(R.layout.act_signin_identify_check,R.string.act_signin_identify_check_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,SigninIdentifyCheckAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }

    /**
     * 注册-->设置密码
     */
    @OnClick(R.id.act_signin_identify_btn_next)
    public void settingPsw(){
        SettingPswAct.startActivity(SigninIdentifyCheckAct.this);
    }
}
