package com.lsy.androidutils.home;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.androidutils.R;
import com.lsy.androidutils.Test;
import com.lsy.androidutils.base.BaseFragment;
import com.lsy.androidutils.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author lsy
 * @create 2019/8/6 22:56
 * @Describe 首页
 */
public class HomeFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.btn)
    public void viewClick() {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//        ARouter.getInstance().build("/test/activity").navigation(this, 100);

        // 2. 跳转并携带参数
        ARouter.getInstance().build(Constant.URL_TEST)
                .withLong("key1", 666L)
                .withString("key2", "888")
                .withParcelable("key3", new Test("Jack", "Rose"))
                .navigation(mActivity, 100);
    }


}
