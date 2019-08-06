package com.lsy.androidutils.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;

/**
 * @author lsy
 * @create 2019/8/6 21:39
 * @Describe 基础Activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ARouter.getInstance().inject(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    public abstract int getLayoutId();

    public abstract void init();
}
