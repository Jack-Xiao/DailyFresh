package com.tianye.dailyfresh.util;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2015/4/28.
 */
public class OkHttpUtil {
    private static final OkHttpClient mOkHttpUtil = new OkHttpClient();
    static{
        mOkHttpUtil.setConnectTimeout(10, TimeUnit.SECONDS);
    }
    public static Response execute(Request request) throws IOException {
        return mOkHttpUtil.newCall(request).execute();
    }
    /**
     */
    public static void enqueue(Request request,Callback responseCallback){
        mOkHttpUtil.newCall(request).enqueue(responseCallback);
    }

    /*
     */
    public static void enqueue(Request request){
        mOkHttpUtil.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if(response.isSuccessful()){
            String responseUrl = response.body().string();
            return responseUrl;
        }else{
            throw  new IOException("Unexcepted code " +response);
        }
    }

    public static InputStream byteStream(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if(response.isSuccessful()){
            InputStream responseStream = response.body().byteStream();
            return responseStream;
        }else {
            throw new IOException("Unexcepted code " + response);
        }
    }

    private static final String CHARSET_NAME = "UTF-8";

    public static String formatParams(List<BasicNameValuePair> params){
        return URLEncodedUtils.format(params,CHARSET_NAME);
    }
    /**
     */
    public static String attachHttpGetParams(String url,List<BasicNameValuePair> params){
        return url + "?" + formatParams(params);
    }
    /*
     */
    public static String attachHttpGetParam(String url,String name,String value){
        return url + "?" + name + "=" + value;
    }
}
