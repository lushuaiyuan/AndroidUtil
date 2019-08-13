package com.lsy.lib_base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this);
        init();
    }
    public abstract int getLayoutId();
    public abstract void init();
}
