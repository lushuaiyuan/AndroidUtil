package com.lsy.module_me.view;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.bean.EventBusBean;
import com.lsy.lib_base.data.JavaBean;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;

import java.util.List;
import java.util.Map;

import butterknife.BindView;


@Route(path = RouterUtils.ME_INJECT)
public class InjectActivity extends BaseActivity {
    @BindView(R2.id.textView)
    TextView mTextView;

    @Autowired
    String name = "hahahha";

    @Autowired
    int age = 13;

    @Autowired(name = "boy")//映射参数名
            boolean sex;

    @Autowired
    long high = 160;

    @Autowired
    String url;

    @Autowired
    EventBusBean pac;

    @Autowired
    JavaBean obj;

    @Autowired
    List<JavaBean> objList;

    @Autowired
    Map<String, List<JavaBean>> map;

    @Autowired
    int height = 21;//上页面没有传递

    @Override
    public int getLayoutId() {
        return R.layout.activity_inject;
    }

    @Override
    public void init() {
        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac=%s,\n obj=%s, \n objList=%s,\n map=%s",
                name,
                age,
                height,
                sex,
                high,
                url,
                pac.getProject(),
                obj.getName(),
                objList.get(0).getName(),
                map.get("testMap").get(0).getName()
        );
        mTextView.setText(params);
    }
}
