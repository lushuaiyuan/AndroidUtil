package com.lsy.module_me.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

@Route(path = RouterUtils.ME_TEST2, group = "needLogin")
public class TestActivity2 extends BaseActivity {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.textView)
    TextView mTextView;
    @BindView(R2.id.btn_back_data)
    Button mBtnBackData;

    @Autowired
    String extra;

    @Override
    public int getLayoutId() {
        return R.layout.activity_event_bus;
    }

    @Override
    public void init() {
        mBtnBackData.setVisibility(View.GONE);
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTextView.setText("extra==>" + extra);
    }
}
