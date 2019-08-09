package com.lsy.androidutils.mine;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author lsy
 * @create 2019/8/6 23:04
 * @Describe 我的
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.collapsing_topbar_layout)
    QMUICollapsingTopBarLayout qmuiCollapsingTopBarLayout;
    @BindView(R.id.topbar)
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


    @OnClick(R.id.ll_changeSkin)
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.ll_changeSkin:

                break;
        }
    }
}
