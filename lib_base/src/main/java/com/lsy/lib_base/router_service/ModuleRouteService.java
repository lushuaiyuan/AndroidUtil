package com.lsy.lib_base.router_service;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.lib_base.provider.IFindModuleService;

/**
 * 服务的发现
 */
public class ModuleRouteService {
    public static String getUserName(String userId) {
        IFindModuleService iFindModuleService = ARouter.getInstance().navigation(IFindModuleService.class);
        if (iFindModuleService != null) {
            return iFindModuleService.getUserName(userId);
        }
        return "";
    }
}
