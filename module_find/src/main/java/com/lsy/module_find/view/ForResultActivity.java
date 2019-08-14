package com.lsy.module_find.view;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_find.R;
import com.lsy.module_find.R2;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

@Route(path = RouterUtils.FIND_FORESULT)
public class ForResultActivity extends BaseActivity {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @Override
    public int getLayoutId() {
        return R.layout.activity_for_result;
    }

    @Override
    public void init() {
        qmuiTopBarLayout.setTitle("ForResultActivity");
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", "ForResult返回的数据");
                setResult(999, intent);
                finish();
            }
        });
    }
}
