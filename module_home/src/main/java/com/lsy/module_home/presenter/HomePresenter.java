package com.lsy.module_home.presenter;

import android.annotation.SuppressLint;

import com.lsy.lib_base.base.BasePresenter;
import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.FriendBean;
import com.lsy.lib_base.bean.HomeBean;
import com.lsy.lib_base.bean.HotkeyBean;
import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.lib_net.response.ResponseTransformer;
import com.lsy.lib_net.schedulers.SchedulerProvider;
import com.lsy.module_home.contract.HomeContract;
import com.lsy.module_home.model.HomeModel;
import com.lsy.module_home.view.HomeFragment;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    private HomeContract.Model model;

    public HomePresenter() {
        model = new HomeModel();
    }


//    @Override
//    public void bannerList() {
//        //View是否绑定 如果没有绑定，就不执行网络请求
//        if (!isViewAttached()) {
//            return;
//        }
//        mView.showLoading();
//        model.bannerList()
//                .compose(ResponseTransformer.handleResult())
//                .compose(SchedulerProvider.getInstance().applySchedulers())
//                .as(mView.bindAutoDispose())
//                .subscribe(new Consumer<Optional<List<BannerBean>>>() {
//                    @Override
//                    public void accept(Optional<List<BannerBean>> bannerOptional) throws Exception {
//                        mView.hideLoading();
//                        mView.onSuccess1(bannerOptional);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mView.hideLoading();
//                        mView.onError(throwable);
//                    }
//                });
//    }

//    @Override
//    public void hotKeyList() {
//        if (!isViewAttached()) {
//            return;
//        }
//        mView.showLoading();
//        model.hotkeyList()
//                .compose(ResponseTransformer.handleResult())
//                .compose(SchedulerProvider.getInstance().applySchedulers())
//                .as(mView.bindAutoDispose())
//                .subscribe(new Consumer<Optional<List<HotkeyBean>>>() {
//                    @Override
//                    public void accept(Optional<List<HotkeyBean>> hotKeyListOptional) throws Exception {
//                        mView.hideLoading();
//                        mView.onSuccess3(hotKeyListOptional);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mView.hideLoading();
//                        mView.onError(throwable);
//                    }
//                });
//
//    }

//    @Override
//    public void friendList() {
//        if (!isViewAttached()) {
//            return;
//        }
//        mView.showLoading();
//        model.friendList()
//                .compose(ResponseTransformer.handleResult())
//                .compose(SchedulerProvider.getInstance().applySchedulers())
//                .as(mView.bindAutoDispose())
//                .subscribe(new Consumer<Optional<List<FriendBean>>>() {
//                    @Override
//                    public void accept(Optional<List<FriendBean>> friendBeanListOptional) throws Exception {
//                        mView.hideLoading();
//                        mView.onSuccess4(friendBeanListOptional);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mView.hideLoading();
//                        mView.onError(throwable);
//                    }
//                });
//    }

    @Override
    public void articleList(int pageIndex) {
        if (!isViewAttached()) {
            return;
        }
        model.articleList(pageIndex)
                .compose(ResponseTransformer.handleResult())
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .as(mView.bindAutoDispose())
                .subscribe(new Consumer<Optional<ArticleBean>>() {
                    @Override
                    public void accept(Optional<ArticleBean> articleListOptional) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess2(articleListOptional);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getHomeData() {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        Observable<ResponseData<List<BannerBean>>> responseBannerObservable = model.bannerList();//轮播图
        Observable<ResponseData<List<ArticleBean.Article>>> responseTopArticleObservable = model.topArticleList();//置顶文章
        Observable<ResponseData<List<HotkeyBean>>> responseHotKeyObservable = model.hotkeyList();//搜索热词
        Observable<ResponseData<List<FriendBean>>> responseFriendObservable1 = model.friendList();//常用网站
        mView.showLoading();
        Observable.zip(responseBannerObservable, responseTopArticleObservable, responseHotKeyObservable, responseFriendObservable1, new Function4<ResponseData<List<BannerBean>>, ResponseData<List<ArticleBean.Article>>, ResponseData<List<HotkeyBean>>, ResponseData<List<FriendBean>>, ResponseData<HomeBean>>() {
            @Override
            public ResponseData<HomeBean> apply(ResponseData<List<BannerBean>> listResponseData, ResponseData<List<ArticleBean.Article>> listResponseData2, ResponseData<List<HotkeyBean>> listResponseData3, ResponseData<List<FriendBean>> listResponseData4) throws Exception {
                ResponseData<HomeBean> optionalResponseData = new ResponseData();
                optionalResponseData.setData(new HomeBean());
                HomeBean homeBean = optionalResponseData.getData().getIncludeNull();
                homeBean.setBanners(listResponseData.getData().getIncludeNull());
                homeBean.setTopArticles(listResponseData2.getData().getIncludeNull());
                homeBean.setHotkeyBeans(listResponseData3.getData().getIncludeNull());
                homeBean.setFriendBeans(listResponseData4.getData().getIncludeNull());
                return optionalResponseData;
            }
        }).compose(ResponseTransformer.handleResult())
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .as(mView.bindAutoDispose())
                .subscribe(new Consumer<Optional<HomeBean>>() {
                    @Override
                    public void accept(Optional<HomeBean> optionalOptional) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(optionalOptional);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);
                    }
                });

    }
}
