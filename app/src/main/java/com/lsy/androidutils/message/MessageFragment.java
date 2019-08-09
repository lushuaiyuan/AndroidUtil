package com.lsy.androidutils.message;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

/**
 * 消息
 */
public class MessageFragment extends BaseFragment {
    private QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
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
        qmuiTopBarLayout.setTitle("消息");
        qmuiTopBarLayout.setTitleGravity(Gravity.CENTER);
        qmuiTopBarLayout.setSubTitle("");
        qmuiTopBarLayout.addRightImageButton(R.mipmap.icon_search, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "查询", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
