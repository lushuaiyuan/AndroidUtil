package com.lsy.module_me.presenter;

import com.lsy.lib_base.base.BasePresenter;
import com.lsy.lib_base.bean.LogOutBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_net.response.ResponseTransformer;
import com.lsy.lib_net.schedulers.SchedulerProvider;
import com.lsy.module_me.contract.SettingContract;
import com.lsy.module_me.model.SettingModel;

import io.reactivex.functions.Consumer;

public class SettingPresenter extends BasePresenter<SettingContract.View> implements SettingContract.Presenter {
    protected SettingContract.Model model;

    public SettingPresenter() {
        this.model = new SettingModel();
    }

    @Override
    public void logOut() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.logOut().compose(ResponseTransformer.<LogOutBean>handleResult())
                .compose(SchedulerProvider.getInstance().<Optional<LogOutBean>>applySchedulers())
                .as(mView.<Optional<LogOutBean>>bindAutoDispose())
                .subscribe(new Consumer<Optional<LogOutBean>>() {
                    @Override
                    public void accept(Optional<LogOutBean> logOutBeanOptional) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(logOutBeanOptional);
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
