package com.lsy.module_home.model;


import com.lsy.lib_net.NetWorkManager;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.FriendBean;
import com.lsy.lib_base.bean.HotkeyBean;
import com.lsy.module_home.contract.HomeContract;

import java.util.List;

import io.reactivex.Observable;

public class HomeModel implements HomeContract.Model {
    @Override
    public Observable<ResponseData<List<BannerBean>>> bannerList() {
        return NetWorkManager.getApiService().getBannerList();
    }

    @Override
    public Observable<ResponseData<ArticleBean>> articleList(int pageIndex) {
        return NetWorkManager.getApiService().getArticleList(pageIndex);
    }

    @Override
    public Observable<ResponseData<List<HotkeyBean>>> hotkeyList() {
        return NetWorkManager.getApiService().getHotKeyList();
    }

    @Override
    public Observable<ResponseData<List<FriendBean>>> friendList() {
        return NetWorkManager.getApiService().getFriendList();
    }

}
