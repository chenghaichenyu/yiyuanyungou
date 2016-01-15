package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.widget.TextView;

import com.chenyu.R;
import com.chenyu.core.Utils.ResUtils;
import com.chenyu.core.Utils.SpanStringUtils;
import com.chenyu.core.controller.BasicAct;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Chenyu
 * 功能：新用户注册页面
 */
public class SigninAct extends BasicAct{

    @Bind(R.id.act_signin_tv_adgree)
    TextView tv_adgree;


    public SigninAct(){
        super(R.layout.act_signin,R.string.act_signin_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,SigninAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        SpannableString cs = SpanStringUtils.getHightLightText(ResUtils.getColor(R.color.blue_text),
                ResUtils.getString(R.string.act_signin_tv_tip),
                ResUtils.getString(R.string.act_signin_tv_tip_hight_light));
        tv_adgree.setText(cs);
    }

    /**
     * 注册-->身份验证
     */
    @OnClick(R.id.act_signin_btn_next)
    public void signinIdentifyCheck(){
        SigninIdentifyCheckAct.startActivity(SigninAct.this);
    }
}
