package com.lsy.androidutils;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class App extends Application {
    public static App App;

    public static App getInstance() {
        return App;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App = this;
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

    private boolean isDebug = true;
}
