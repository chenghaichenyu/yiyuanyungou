package com.chenyu.core.net;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by ChenYu on 2016/1/6.
 */
public class BasicRequest extends JsonObjectRequest {

    public BasicApi basicApi;

    public BasicRequest(BasicApi basicApi,Response.Listener<JSONObject> successListener,Response.ErrorListener errorListener){
        super(basicApi.getHttpType(),basicApi.getURL(),null,successListener,errorListener);
        this.basicApi = basicApi;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return basicApi.getHeader();
    }

    @Override
    public byte[] getBody() {
        if(basicApi.getBody() == null){
            return super.getBody();
        }
        return basicApi.getBody();
    }

    /**
     * 将返回数据格式化为UTF-8
     * @param response
     * @return
     */
    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String je = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            String temp = new String(response.data,"UTF-8");
            return Response.success(new JSONObject(temp), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException var3) {
            return Response.error(new ParseError(var3));
        } catch (JSONException var4) {
            return Response.error(new ParseError(var4));
        }
    }
}
