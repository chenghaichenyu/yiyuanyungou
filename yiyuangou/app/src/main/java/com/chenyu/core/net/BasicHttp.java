package com.chenyu.core.net;

import com.android.volley.Response;
import com.chenyu.core.App.App;
import com.chenyu.core.Utils.LogUtils;

import org.json.JSONObject;

/**
 * Created by ChenYu on 2016/1/6.
 */
public abstract class BasicHttp implements Response.Listener<JSONObject>,Response.ErrorListener {

    public BasicApi basicApi;
    public BasicRequest basicRequest;

    public BasicHttp(BasicApi basicApi){
        this.basicApi = basicApi;
    }

    /**
     *
     */
    public void request(){
        LogUtils.d("[Url]"+basicApi.getURL());
        LogUtils.d("[header]"+basicApi.getHeader());
        LogUtils.d("[body]"+new String(basicApi.getBody()));
        basicRequest = new BasicRequest(basicApi,this,this);
        App.getQueue().add(basicRequest);
    }
}
