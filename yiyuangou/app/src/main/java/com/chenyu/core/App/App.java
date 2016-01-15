package com.chenyu.core.App;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.chenyu.yiyuangou.model.bean.User;

/**
 * Created by Chenyu on 2015/12/31.
 */
public class App extends Application{
    public static Context context;

    public static Context getContext() {
        return context;
    }

    public static RequestQueue queue;

    public User user;

    public static App app;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogin(){
        return user != null;
    }

    public static App getApp(){
        if(app == null){
            synchronized (App.class){
                if(app == null){
                    app = new App();
                }
            }
        }
        return app;
    }

    /**
     * 获取网络请求的消息队列
     * @return
     */
    public static RequestQueue getQueue(){
        if(queue == null){
            synchronized(RequestQueue.class){
                if(queue == null){
                    queue = Volley.newRequestQueue(context);
                }
            }
        }
        return queue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
