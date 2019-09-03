package com.lsy.lib_net.request;


import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.CollectBean;
import com.lsy.lib_base.bean.FriendBean;
import com.lsy.lib_base.bean.HotkeyBean;
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
import retrofit2.http.Path;

public interface APIService {
    public static final String HOST = "https://www.wanandroid.com/";

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<ResponseData<RegistBean>> regist(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseData<LoginBean>> login(@Field("username") String username, @Field("password") String password);


    /**
     * 退出
     *
     * @return
     */
    @GET("user/logout/json")
    Observable<ResponseData<LogOutBean>> logout();


    /**
     * 首页轮播图
     *
     * @return
     */
    @GET("banner/json")
    Observable<ResponseData<List<BannerBean>>> getBannerList();

    /**
     * 分页查询首页文章列表
     *
     * @param pageIndex
     * @return
     */
    @GET("article/list/{pageIndex}/json")
    Observable<ResponseData<ArticleBean>> getArticleList(@Path("pageIndex") int pageIndex);

    /**
     * 获取热搜列表
     *
     * @return
     */
    Observable<ResponseData<List<HotkeyBean>>> getHotKeyList();


    /**
     * 常用网站列表
     *
     * @return
     */
    Observable<ResponseData<List<FriendBean>>> getFriendList();

    /**
     * 收藏列表
     *
     * @return
     */
    @GET("lg/collect/list/0/json")
    Observable<ResponseData<List<CollectBean>>> getCollectBeans();


}
