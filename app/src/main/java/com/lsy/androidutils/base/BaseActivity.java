package com.lsy.androidutils.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.androidutils.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;

/**
 * @author lsy
 * @create 2019/8/6 21:39
 * @Describe 基础Activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this, ContextCompat.getColor(this, R.color.app_color_theme_2));
        init();
    }


    public abstract int getLayoutId();

    public abstract void init();
}
