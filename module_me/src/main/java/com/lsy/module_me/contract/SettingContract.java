package com.lsy.module_me.contract;

import com.lsy.lib_base.base.BaseView;
import com.lsy.lib_base.bean.LogOutBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_net.response.ResponseData;

import io.reactivex.Observable;


public interface SettingContract {
    interface Model {
        Observable<ResponseData<LogOutBean>> logOut();
    }

    interface View extends BaseView {
        void onSuccess(Optional<LogOutBean> logoutResponseData);
    }

    interface Presenter {
        void logOut();
    }

}
