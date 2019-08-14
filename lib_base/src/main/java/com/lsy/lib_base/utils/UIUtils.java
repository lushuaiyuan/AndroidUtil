package com.lsy.lib_base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.widget.Toast;

import com.lsy.lib_base.App;

public class UIUtils {
    /**
     * 判断当前应用是否是debug状态
     */

    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Toast 提示消息
     *
     * @param msg
     */
    public static void showToast(String msg) {
        Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}
