package com.lsy.androidutils;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.utils.Constant;

import butterknife.BindView;


@Route(path = Constant.URL_TEST)
public class TestActivity extends BaseActivity {
    @BindView(R.id.tv_content)
    TextView tvContent;
    @Autowired
    long key1;
    @Autowired
    String key2;
    @Autowired
    Test key3;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void init() {
        tvContent.setText("参数是： " + "key1: " + key1 + "  key2: " + key2 + " key3：" + key3.toString());
    }
}
