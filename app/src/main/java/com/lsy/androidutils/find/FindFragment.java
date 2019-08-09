package com.lsy.androidutils.find;

import android.util.Log;
import android.view.Gravity;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

/**
 * @author lsy
 * @create 2019/8/6 23:02
 * @Describe
 */
public class FindFragment extends BaseFragment {
    @BindView(R.id.topbar)
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
