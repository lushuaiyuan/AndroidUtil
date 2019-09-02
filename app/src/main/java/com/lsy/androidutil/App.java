package com.lsy.androidutil;

import android.app.Application;
import android.content.Context;

import com.lsy.lib_base.IComponentApplication;

public class App extends Application {
    private static final String[] MODULESLIST =
            {"com.lsy.lib_base.RouterApplication",
                    "com.lsy.lib_net.NetApplication"};


    private static App instance;
    private static Context mContext;

    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
        //Module类的APP初始化
        modulesApplicationInit();
    }

    private void modulesApplicationInit() {
        for (String moduleImpl : MODULESLIST) {
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof IComponentApplication) {
                    ((IComponentApplication) obj).init(getInstance());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
