package com.lsy.lib_net;


import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 配置基本提交参数
 */
public class HttpBaseParamsLoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        FormBody formBody = new FormBody.Builder()
                .add("userId", "10000")
                .add("sessionToken", "E34343RDFDRGRT43RFERGFRE")
                .add("q_version", "1.1")
                .add("device_id", "android-344365")
                .add("device_os", "android")
                .add("device_osversion", "6.0")
                .add("req_timestamp", System.currentTimeMillis() + "")
                .add("app_name", "forums")
                .add("sign", "md5")
                .build();
        String postBodyString = bodyToString(request.body());
        postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
        request = requestBuilder
                .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
                        postBodyString))
                .build();
        return chain.proceed(request);
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
