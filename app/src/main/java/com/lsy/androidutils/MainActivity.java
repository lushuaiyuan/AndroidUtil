package com.lsy.androidutils;

import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.home.HomeFragment;
import com.lsy.androidutils.mine.MineFragment;
import com.lsy.androidutils.order.OrderFragment;
import com.lsy.androidutils.view.BottomBar;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindString;
import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    @BindString(R.string.app_name)
    String app_name;
    @BindString(R.string.home)
    String home;
    @BindString(R.string.order)
    String order;
    @BindString(R.string.mine)
    String mine;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(HomeFragment.class,
                        home,
                        R.mipmap.home_normal,
                        R.mipmap.home_press)
                .addItem(OrderFragment.class,
                        order,
                        R.mipmap.order_normal,
                        R.mipmap.order_press)
                .addItem(MineFragment.class,
                        mine,
                        R.mipmap.mine_normal,
                        R.mipmap.mine_press)
                .build();
    }

}

