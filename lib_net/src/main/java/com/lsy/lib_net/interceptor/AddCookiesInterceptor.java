package com.lsy.lib_net.interceptor;


import com.heima.easysp.SharedPreferencesUtils;
import com.lsy.lib_base.RouterApplication;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 非首次请求
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

//        Log.e("context1的值", "intercept: " + RouterApplication.getContext());
//        Log.e("context2的值", "intercept: " + RouterApplication.getInstance());
//
//        SharedPreferences sharedPreferences = RouterApplication.getContext().getSharedPreferences("config", Context.MODE_PRIVATE);
//        HashSet<String> cookies = (HashSet<String>) sharedPreferences.getStringSet("cookie", null);
        HashSet<String> cookies = (HashSet<String>) SharedPreferencesUtils.init(RouterApplication.getmContext()).getStringSet("cookie");


        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
