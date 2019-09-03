package com.lsy.module_home.view;


import androidx.fragment.app.FragmentManager;

import com.lsy.lib_base.base.BaseActivity;
import com.lsy.module_home.R;
import com.lsy.module_home.view.HomeFragment;


public class MainActivity extends BaseActivity {
    private FragmentManager fragmentManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, new HomeFragment())
                .commitAllowingStateLoss();
    }
}
