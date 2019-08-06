package com.lsy.androidutils;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.home.HomeFragment;
import com.lsy.androidutils.mine.MineFragment;
import com.lsy.androidutils.test.TestFragment;
import com.lsy.androidutils.view.BottomBar;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    @BindString(R.string.app_name)
    String app_name;
    @BindColor(R.color.colorPrimary)
    int colorPrimary;
    @BindColor(R.color.colorPrimaryDark)
    int colorPrimaryDark;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(HomeFragment.class,
                        "首页",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher)
                .addItem(TestFragment.class,
                        "订单",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher)
                .addItem(MineFragment.class,
                        "我的",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher)
                .build();
    }

}

