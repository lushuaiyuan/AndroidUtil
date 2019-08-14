package com.lsy.lib_net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Retrofit请求头拦截器
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .header("platform", "platform")//平台
                .header("sysVersion", "sysVersion")//系统版本号
                .header("device", "device")//设备信息
                .header("screen", "screen")//屏幕大小
                .header("uuid", "uuid")//设备唯一码
                .header("version", "version")//app版本
                .header("apiVersion", "apiVersion")//api版本
                .header("token", "token")//令牌
                .header("channelId", "channelId")//渠道
                .header("networkType", "networkType");//网络类型
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}

