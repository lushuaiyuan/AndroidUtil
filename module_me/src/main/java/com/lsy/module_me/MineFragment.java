package com.lsy.module_me;

import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.utils.UIUtils;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的模块
 */
@Route(path = RouterUtils.ME_FRAGMENT_MAIN)
public class MineFragment extends BaseFragment {
    @BindView(R2.id.collapsing_topbar_layout)
    QMUICollapsingTopBarLayout qmuiCollapsingTopBarLayout;
    @BindView(R2.id.topbar)
    QMUITopBar qmuiTopBar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData() {
        initTopBar();
    }


    private void initTopBar() {
        qmuiCollapsingTopBarLayout.setTitle("路远天阔");
        qmuiTopBar.addRightImageButton(R.mipmap.icon_setting, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "设置", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick(R2.id.ll_changeSkin)
    public void viewClick(View view) {
        if (view.getId() == R.id.ll_changeSkin) {
            UIUtils.ToastMsg("设置");
        }
    }
}