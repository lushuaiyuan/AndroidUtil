package com.lsy.module_me;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.heima.easysp.SharedPreferencesUtils;
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
public class MineFragment extends BaseFragment implements View.OnClickListener {
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
        if (SharedPreferencesUtils.init(mActivity).getStringSet("cookie").size() > 0) {
            qmuiCollapsingTopBarLayout.setTitle(SharedPreferencesUtils.init(mActivity).getString("nickName"));
        } else {
            qmuiCollapsingTopBarLayout.setTitle("注册/登录>");
            qmuiCollapsingTopBarLayout.setOnClickListener(this);
        }
        qmuiTopBar.addRightImageButton(R.mipmap.ic_setting, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterUtils.ME_SETTING)
                        .navigation();
            }
        });
    }


    @OnClick(R2.id.ll_changeSkin)
    public void viewClick(View view) {
        if (view.getId() == R.id.ll_changeSkin) {
            UIUtils.showToast("设置");
        }
    }

    @Override
    public void onClick(View view) {
        ARouter.getInstance().build(RouterUtils.ME_LOGIN).navigation();
    }
}
