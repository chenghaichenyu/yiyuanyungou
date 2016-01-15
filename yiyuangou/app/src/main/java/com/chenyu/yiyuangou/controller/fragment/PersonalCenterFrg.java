package com.chenyu.yiyuangou.controller.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenyu.R;
import com.chenyu.core.App.App;
import com.chenyu.core.Utils.ResUtils;
import com.chenyu.core.controller.BasicFrg;
import com.chenyu.yiyuangou.controller.activity.AddressAct;
import com.chenyu.yiyuangou.controller.activity.LoginAct;
import com.chenyu.yiyuangou.controller.activity.PersonalCenterSettingAct;
import com.chenyu.yiyuangou.model.bean.User;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ChenYu on 2016/1/1.
 * 功能：“个人中心”的标签页
 */
public class PersonalCenterFrg extends BasicFrg{

//    @Bind(R.id.frg_personal_center_rl_userinfos)
//    RelativeLayout rl_userinfos;
    @Bind(R.id.frg_personal_center_text_welcome)
    TextView text_welcome;
    @Bind(R.id.frg_personal_center_btn_login)
    Button btn_login;

    public PersonalCenterFrg(){
        super(R.layout.frg_personal_center);
    }

    @Override
    public void initView(View view) {
//        if(App.getApp().isLogin(

        initUserInfos();
    }


    public void initUserInfos() {
//        rl_userinfos.removeView(text_welcome);
//        rl_userinfos.removeView(btn_login);
//        rl_userinfos.setBackgroundColor(ResUtils.getColor(R.color.bg_layout));
//
//        ImageView picImage = new ImageView(context);
//        picImage.setImageResource(R.drawable.account_pic_bg_default);
//        picImage.setBackgroundResource(R.drawable.image_account_bg);
//        picImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT);
//        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        lp.setMargins(12,12,12,12);
//        picImage.setLayoutParams(lp);
//        rl_userinfos.addView(picImage);
    }

    /**
     * 登录
     */
    @OnClick(R.id.frg_personal_center_btn_login)
    public void login(){
        LoginAct.startActivity(context);
    }

    /**
     * 设置
     */
    @OnClick(R.id.tool_bar_btn_setting)
    public void setting(){
        PersonalCenterSettingAct.startActivity(context);
    }

    /**
     * 收货地址管理
     */
    @OnClick(R.id.frg_personal_center_rl_address)
    public void address(){
        AddressAct.startActivity(context);
    }
}