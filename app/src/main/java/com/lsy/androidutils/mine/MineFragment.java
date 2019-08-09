package com.lsy.androidutils.mine;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.OnClick;

/**
 * @author lsy
 * @create 2019/8/6 23:04
 * @Describe 我的
 */
public class MineFragment extends BaseFragment {
    private QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initTopBar();
    }

    private void initTopBar() {
        qmuiTopBarLayout = mActivity.findViewById(R.id.topbar);
        qmuiTopBarLayout.removeAllLeftViews();
        qmuiTopBarLayout.removeAllRightViews();
        qmuiTopBarLayout.setTitle("我的");
        qmuiTopBarLayout.setTitleGravity(Gravity.CENTER);
        qmuiTopBarLayout.setSubTitle("");
    }

    @OnClick(R.id.ll_changeSkin)
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.ll_changeSkin:

                break;
        }
    }
}
