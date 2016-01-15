package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAct;

import butterknife.OnClick;

/**
 * Created by ChenYu
 * 功能：登录页面
 */
public class LoginAct extends BasicAct {

    public LoginAct(){
        super(R.layout.act_login,R.string.act_login_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,LoginAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.act_login_text_forgive_psw)
    public void forgivePsw(){
        ForgivePswAct.startActivity(LoginAct.this);
    }

    /**
     * 新用户注册
     */
    @OnClick(R.id.act_login_text_signin)
    public void signin(){
        SigninAct.startActivity(LoginAct.this);
    }
}
