package com.lsy.androidutils.test;

import android.widget.TextView;

import com.lsy.androidutils.R;
import com.lsy.androidutils.base.BaseFragment;

import butterknife.BindView;

/**
 * @author lsy
 * @create 2019/8/6 23:02
 * @Describe
 */
public class TestFragment extends BaseFragment {
    @BindView(R.id.content)
    TextView tvContent;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        tvContent.setText("测试");
    }
}
