package com.lsy.module_me.model;

import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_net.NetWorkManager;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.module_me.contract.LoginContract;

import io.reactivex.Observable;

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<ResponseData<LoginBean>> login(String username, String password) {
        return NetWorkManager.getApiService().login(username, password);
    }
}
