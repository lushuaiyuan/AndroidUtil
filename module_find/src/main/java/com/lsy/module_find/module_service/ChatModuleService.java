package com.lsy.module_find.module_service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.provider.IFindModuleService;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_find.net.ChatService;

@Route(path = RouterUtils.FIND_SERVICE)
public class ChatModuleService implements IFindModuleService {
    @Override
    public String getUserName(String userId) {
        return ChatService.getUserName(userId);
    }

    @Override
    public void init(Context context) {

    }
}
