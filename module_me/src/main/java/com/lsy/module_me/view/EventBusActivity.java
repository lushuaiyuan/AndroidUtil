package com.lsy.module_me.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.bean.EventBusBean;
import com.lsy.lib_base.data.EvenBusMsg;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;


@Route(path = RouterUtils.ME_EVENTBUS)
public class EventBusActivity extends BaseActivity {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.textView)
    TextView mTextView;
    @BindView(R2.id.btn_back_data)
    Button mBtnBackData;

    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired
    EventBusBean eventbus;

    @Override
    public int getLayoutId() {
        return R.layout.activity_event_bus;
    }

    @Override
    public void init() {
        initTopBar();
        mTextView.setText("name=" + name + ",\tage=" + age + ",\tproject=" + eventbus.toString());
    }

    private void initTopBar() {
        qmuiTopBarLayout.setTitle("EventBus跨模块通信");
    }

    @OnClick(R2.id.btn_back_data)
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_back_data) {
            EvenBusMsg evenBusMsg = new EvenBusMsg();
            evenBusMsg.setName(name);
            evenBusMsg.setAge(age);
            EventBus.getDefault().post(evenBusMsg);
            finish();
        } else {
        }
    }
}
