package com.lsy.lib_net.request;


import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.CollectBean;
import com.lsy.lib_base.bean.LogOutBean;
import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_base.bean.RegistBean;
import com.lsy.lib_net.response.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    public static final String HOST = "https://www.wanandroid.com/";

    @FormUrlEncoded
    @POST("user/register")
    Observable<ResponseData<RegistBean>> regist(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseData<LoginBean>> login(@Field("username") String username, @Field("password") String password);

    /**
     * 轮播图
     *
     * @return
     */
    @GET("banner/json")
    Observable<ResponseData<List<BannerBean>>> getBannerList();

    /**
     * 退出
     *
     * @return
     */
    @GET("user/logout/json")
    Observable<ResponseData<LogOutBean>> logout();

    /**
     * 收藏列表
     *
     * @return
     */
    @GET("lg/collect/list/0/json")
    Observable<ResponseData<List<CollectBean>>> getCollectBeans();
}
