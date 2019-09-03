package com.lsy.module_me.model;

import com.lsy.lib_base.bean.LogOutBean;
import com.lsy.lib_net.NetWorkManager;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.module_me.contract.SettingContract;

import io.reactivex.Observable;

public class SettingModel implements SettingContract.Model {
    @Override
    public Observable<ResponseData<LogOutBean>> logOut() {
        return NetWorkManager.getApiService().logout();
    }
}
