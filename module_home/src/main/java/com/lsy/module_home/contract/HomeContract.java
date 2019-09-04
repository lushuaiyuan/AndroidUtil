package com.lsy.module_home.contract;


import com.lsy.lib_base.base.BaseView;
import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.HomeBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.lib_base.bean.FriendBean;
import com.lsy.lib_base.bean.HotkeyBean;

import java.util.List;

import io.reactivex.Observable;

public interface HomeContract {
    interface Model {
        /**
         * 首页banner列表
         *
         * @return
         */
        Observable<ResponseData<List<BannerBean>>> bannerList();

        /**
         * 首页文章列表
         *
         * @return
         */
        Observable<ResponseData<ArticleBean>> articleList(int pageIndex);

        /**
         * 搜索热词
         *
         * @return
         */
        Observable<ResponseData<List<HotkeyBean>>> hotkeyList();

        /**
         * 常用网站
         *
         * @return
         */
        Observable<ResponseData<List<FriendBean>>> friendList();


        /**
         * 置顶文章
         *
         * @return
         */
        Observable<ResponseData<List<ArticleBean.Article>>> topArticleList();
    }

    interface View extends BaseView {
        void onSuccess(Optional<HomeBean> homeBeanResponseData);

//        void onSuccess1(Optional<List<BannerBean>> bannerResponseData);

        void onSuccess2(Optional<ArticleBean> articleResponseData);

//        void onSuccess3(Optional<List<HotkeyBean>> hotKeyResponseData);
//
//        void onSuccess4(Optional<List<FriendBean>> friendResponseData);
//
//        void onSuccess5(Optional<List<ArticleBean.Article>> topArticleResponseData);

    }

    interface Presenter {
//        void bannerList();

        void articleList(int pageIndex);

//        void hotKeyList();
//
//        void friendList();
//
        void getHomeData();
    }
}
