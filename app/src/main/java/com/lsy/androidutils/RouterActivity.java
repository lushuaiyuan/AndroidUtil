package com.lsy.androidutils;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.utils.Constant;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

@Route(path = Constant.URL_TEST)
public class RouterActivity extends BaseActivity {
    @BindView(R.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @Autowired
    Long key1;
    @Autowired
    String key2;


    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void init() {
        initTopBar();
        tvContent.setText(key1 + key2);
    }

    private void initTopBar() {
        qmuiTopBarLayout.setTitle("RouterActivity");
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
