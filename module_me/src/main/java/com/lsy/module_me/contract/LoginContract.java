package com.lsy.module_me.contract;

import com.lsy.lib_base.base.BaseView;
import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_net.NetWorkManager;
import com.lsy.lib_net.response.ResponseData;

import io.reactivex.Observable;

public interface LoginContract {
    interface Model {
        Observable<ResponseData<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
        void onSuccess(Optional<LoginBean> loginResponseData);
    }

    interface Presenter {
        void login(String username, String password);
    }
}
