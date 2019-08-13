package com.lsy.module_find;

import android.util.Log;
import android.view.Gravity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.utils.RouterUtils;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

/**
 * 发现模块
 */
@Route(path = RouterUtils.FIND_FRAGMENT_MAIN)
public class FindFragment extends BaseFragment {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initData() {
        initTopBar();
    }

    private void initTopBar() {
        Log.e("FindFragment----", "initTopBar()");
        qmuiTopBarLayout.setTitle("发现好货");
        qmuiTopBarLayout.setTitleGravity(Gravity.CENTER);
    }
}
