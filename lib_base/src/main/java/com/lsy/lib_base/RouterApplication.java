package com.lsy.lib_base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.lib_base.utils.UIUtils;
//import com.lsy.lib_net.NetWorkManager;

public class RouterApplication implements IComponentApplication {


    private void initRouter(Application mApplication) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (UIUtils.isApkInDebug(mApplication)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(mApplication);
    }

    private static Context mContext;


    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void init(Application application) {
        initRouter(application);
        mContext = application.getApplicationContext();
    }
}
