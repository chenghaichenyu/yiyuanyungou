package com.chenyu.core.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenyu.R;
import com.chenyu.core.Utils.ResUtils;
import butterknife.ButterKnife;

/**
 * Created by ChenYu on 2015/12/31.
 * 功能： Activity的父类
 */
public abstract class BasicAct extends AppCompatActivity {

    public Bundle savedInstanceState;
    public int contentResId;
    public int titleResId;
    public boolean hasBackButton = true;
    public int toolbarType = TOOLBAR_TYPE_DEFAULT;

    public Toolbar toolbar;
    public TextView textTitle;
    public RelativeLayout imageBackBtn;

    public static final int NO_CONTENT = 0;
    public static final int NO_TITLE = 0;
    public static final int TOOLBAR_TYPE_DEFAULT = 0;
    public static final int TOOLBAR_TYPR_FULL_SCREEN = 1;
    public static final int TOOLBAR_TYPE_NO_TOOLBAR = 2;

    public BasicAct(int contentResId,int titleResId){
        this(contentResId,titleResId,true,TOOLBAR_TYPE_DEFAULT);
    }

    public BasicAct(int contentResId,int titleResId,boolean hasBackButton){
        this(contentResId,titleResId,hasBackButton,TOOLBAR_TYPE_DEFAULT);
    }
    public BasicAct(int contentResId,int titleResId,boolean hasBackButton,int toolbarType){
        this.contentResId = contentResId;
        this.titleResId = titleResId;
        this.hasBackButton = hasBackButton;
        this.toolbarType = toolbarType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        initToolBar();
        initButterKnife();
        initView();
    }

    /**
     * 初始化布局文件
     */
    private void initContent(){
        if(NO_CONTENT != contentResId){
            setContentView(contentResId);
        }
    }

    /**
     * 初始化Toolbar
     */
    private void initToolBar(){
        switch(toolbarType){
            case TOOLBAR_TYPR_FULL_SCREEN:
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                break;
            case TOOLBAR_TYPE_NO_TOOLBAR:
                initContent();
                break;
            default:
                initContent();
                toolbar = (Toolbar)findViewById(R.id.toolbar);
                textTitle = (TextView) toolbar.findViewById(R.id.tool_bar_title);
                imageBackBtn = (RelativeLayout) toolbar.findViewById(R.id.tool_bar_btn_back);

                if(hasBackButton){
                    imageBackBtn.setVisibility(View.VISIBLE);
                    imageBackBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                }else{
                    if(imageBackBtn != null){
                        imageBackBtn.setVisibility(View.GONE);
                    }
                }

                if(titleResId != NO_TITLE && textTitle != null){
                    if(titleResId == NO_TITLE){
                        textTitle.setText(ResUtils.getString(R.string.default_toolbar_title));
                    }else{
                        textTitle.setText(ResUtils.getString(titleResId));
                    }
                }
                break;
        }
    }

    /**
     * 初始化注解式框架
     */
    private void initButterKnife(){
        ButterKnife.bind(this);
    }

    public abstract void initView();
}
