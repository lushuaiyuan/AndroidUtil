package com.lsy.lib_base.utils;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.RouterApplication;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public class ProgressDialog {
    private static volatile ProgressDialog instance;

    private ProgressDialog() {
    }

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private QMUITipDialog qmuiTipDialog;

    public void show(Context mContext) {
        qmuiTipDialog = new QMUITipDialog.Builder(mContext)
                .setTipWord("正在加载")
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .create();
        qmuiTipDialog.setCancelable(false);
        qmuiTipDialog.show();

    }

    public void dismiss() {
        qmuiTipDialog.dismiss();
    }
}
