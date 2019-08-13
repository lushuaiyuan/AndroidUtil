package com.lsy.module_find;

import androidx.fragment.app.FragmentManager;

import com.lsy.lib_base.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, new FindFragment())
                .commitAllowingStateLoss();
    }
}
