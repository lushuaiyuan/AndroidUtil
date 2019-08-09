package com.lsy.androidutils.message;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

/**
 * 消息
 */
public class MessageFragment extends BaseFragment {
    @BindView(R.id.topbar)
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
        qmuiTopBarLayout.addRightImageButton(R.mipmap.icon_search, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "查询", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
