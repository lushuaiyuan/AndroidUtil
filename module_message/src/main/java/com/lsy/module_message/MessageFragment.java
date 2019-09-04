package com.lsy.module_message;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.utils.RouterUtils;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

@Route(path = RouterUtils.MESSAGE_FRAGMENT_MAIN)
public class MessageFragment extends BaseFragment {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    public void initData() {
        initTopBar();
    }
    private void initTopBar() {
        qmuiTopBarLayout.setTitle("消息");
        qmuiTopBarLayout.setTitleGravity(Gravity.CENTER);
        qmuiTopBarLayout.addRightImageButton(R.mipmap.ic_search, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "查询", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
