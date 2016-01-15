package com.chenyu.core.net;

import android.text.TextUtils;

import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenYu on 2016/1/6.
 */
public abstract class BasicApi{
    /**
     * 在子类重写URL
     */
    public abstract String getURL();

    /**
     * 网络请求方式
     * @return
     */
    public int getHttpType(){
        return Request.Method.POST;
    }

    /**
     * 请求的body
     */
    public String body = "";

    /**
     * 请求的参数
     */
    public JSONObject params = new JSONObject();

    public Map<String,String> header = new HashMap<String,String>();

    public Map<String,String> getHeader(){
        return header;
    }

    public byte[] getBody(){
        if(TextUtils.isEmpty(body) && params.length() != 0){
            return params.toString().getBytes();
        }
        return body.getBytes();
    }

}
