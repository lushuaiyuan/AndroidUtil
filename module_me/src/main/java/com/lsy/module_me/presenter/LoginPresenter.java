package com.lsy.module_me.presenter;

import com.lsy.lib_base.base.BasePresenter;
import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_base.exception.ApiException;
import com.lsy.lib_base.utils.UIUtils;
import com.lsy.lib_net.response.ResponseTransformer;
import com.lsy.lib_net.schedulers.SchedulerProvider;
import com.lsy.module_me.contract.LoginContract;
import com.lsy.module_me.model.LoginModel;

import io.reactivex.functions.Consumer;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Model model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    @Override
    public void login(String username, String password) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password).compose(ResponseTransformer.<LoginBean>handleResult())
                .compose(SchedulerProvider.getInstance().<Optional<LoginBean>>applySchedulers())
                .subscribe(new Consumer<Optional<LoginBean>>() {
                    @Override
                    public void accept(Optional<LoginBean> loginBean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });

    }
}
