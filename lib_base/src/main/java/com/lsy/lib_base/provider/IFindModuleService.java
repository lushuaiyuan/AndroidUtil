package com.lsy.lib_base.provider;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.lsy.lib_base.utils.RouterUtils;

public interface IFindModuleService extends IProvider {
    String getUserName(String userId);
}
